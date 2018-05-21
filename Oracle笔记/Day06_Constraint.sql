--约束
--1、概述
--建立在表上，对表上执行数据操作的一种强制性限制

--2、分类
--1）、作用分类
--a）、非空约束(not null)       -nn
--b）、主键约束(primary key)    -pk
--c）、唯一约束(unique key)     -uq
--d）、检查约束(check)          -ck
--e）、外键约束(foreign key)    -fk
--f）、默认值约束(default)      -df

--2）、按范围分类
--a）、列级约束
--b）、表级约束

--3、作用
select * from student;

--插入数据
--问题1：插入了相同编号的学生信息
insert into student(stuno,name,classId) values(102,'Tom','2');
--问题2：造成了数据的缺失(数据不完整型)
insert into student(stuno) values(103);
--问题3：造成了与班级表之间数据的不完整性
insert into student(stuno,name,classId) values(102,'Tom','2000');

--1）、保证数据完整性及有效性
--2）、保证表间数据的完整性

--4、创建列级约束
--1）、非空约束   ：带有非空约束的列不允许插入null
--a、创建表
drop table student;

--创建列级约束
create table student
(
       stuNo number(4) not null,        --自动创建一个约束名
       stuName varchar2(20) constraint stu_stuName_nn not null, --指定约束名
       age number(3),
       tel varchar2(15)
)

--创建表级约束
create table student
(
       stuNo number(4),     
       stuName varchar2(20),
       age number(3),
       tel varchar2(15),
       --表级约束
       --非空(not null)约束不支持表级约束
       constraint not null
)


--b、编写插入语句
--插入完整数据
insert into student values(1,'Mike',20,'2342322');
--缺少学号
--创建约束后插入失败
insert into student(stuName,age,tel) values('Jack',20,'2342322');
--缺少姓名
--创建约束后插入失败
insert into student(stuNo,age,tel) values(3,22,'2342322');

select * from student;


--2）、唯一约束     ：确保列中的值只能出现一次。允许出现多个null值
drop table student;
--创建数据表
--a、创建列级约束
create table student
(
       stuNo number(4) unique,     --自动生成约束名     
       stuName varchar2(20) constraint stu_name_uq unique,      --指定约束名
       age number(3),
       tel varchar2(15)       
)
--b、创建表级约束
create table student
(
       stuNo number(4),   
       stuName varchar2(20),
       age number(3),
       tel varchar2(15),  
       constraint stu_no_uq unique (stuNo)    
)
--插入完整数据
insert into student values(1,'Mike',20,'2342322');
--name值为null
insert into student values(2,null,20,'2342322');
--name值为null，插入成功
insert into student values(3,null,20,'2342322');

--查询数据
select * from student;

--3）、主键约束     ：主键列不允许出现重复值及null值
--主键约束可以看做是唯一约束的一种特例，他比唯一约束更严格
--主键：主键一般用于区分每条数据的一个唯一标识
drop table student;
--创建数据表
--a、创建列级约束
create table student
(
       --stuNo number(4) primary key,    --未指定约束名
       stuNo number(4) constraint stu_no_pk primary key, --指定约束名
       stuName varchar2(20) ,  
       age number(3),
       tel varchar2(15)       
);

--b、创建表级约束
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3),
       tel varchar2(15),
       constraint stu_no_pk primary key(stuNo)              
);

--c、复合主键      ：主键列是由多个列组成的
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3),
       tel varchar2(15),
       constraint stu_no_pk primary key(stuNo,stuName)              
);

--插入完整数据
insert into student values(1,'Mike',20,'2342322');
--插入失败(主键字段的值出现重复---stuNo)
insert into student values(1,'Jack',22,'4342322');
--插入失败(主键字段的值不允许使用null值)
insert into student values(null,'Jack',22,'4342322');

--查询数据
select * from student;


--4）、检查约束（MySql无效）：通过条件语句检查数据的数据范围是否合法
drop table student;
--创建数据表
--a、创建列级约束
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3) check(age >=0 and age<=200),
       gender varchar(4) constraint stu_gender_ck check(gender='男' or gender = '女'),
       tel varchar2(15)       
);

--插入数据
--插入失败，违反了性别约束
insert into student values(1,'Mike',999,'阿','234234');
insert into student values(1,'Mike',199,'男','234234');

select * from student;

--5)、外键约束
--主键表：提供数据的表称为主键表(grade)
--外键表：使用主键表中数据的表就称为外键表(Student)
--主外键关系需要在外键表上进行创建
--①、插入数据时，当外键列的字段值（Student.gradeNo）在主键表（grade）中不存在时，插入失败
--②、当主键表中主键列的数据与外键表存在引用关系时，存在引用关系的数据无法删除
drop table student;
--创建数据表
create table grade
(
       gradeNo number(4) primary key,
       gradeName varchar2(20)
);
--a、创建列级约束
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3),
       gradeNo number(4),
       constraint stu_gradeNo_fk foreign key(gradeNo) references grade(gradeNo)
);

--插入数据
insert into grade values(1,'一年一班');
insert into student values(1,'Mike',20,1);

--数据插入失败，因为不存在编号为2的班级信息
insert into student values(2,'Jack',20,2);
--删除失败，因为在外键表(Student)中存在引用关系
delete  from grade where gradeNo = 1;
--删除成功，因为不存在引用关系
delete  from grade where gradeNo = 2;

insert into grade values(2,'一年二班');

--查询数据
select * from student s, grade g 
         where s.gradeno = g.gradeno(+);
select * from grade; 

--6）、默认值  
create table grade
(
       gradeNo number(4) ,
       gradeName varchar2(20),
       note varchar2(200) default '这个家伙很懒，什么都没留下'
);   

--查询数据
select * from grade;   

--插入数据
--需要使用默认值时，列直接使用default关键字
insert into grade values(1,'一年一班',default);

--当未对默认值字段提供时，列将自动使用默认值
insert into grade(gradeNo,gradeName) values(1,'一年一班');
--无法使用默认值，因为字段的值是''
insert into grade values(1,'一年一班','');

--4、修改约束
--添加一个没有任何约束的表
create table student
(
       stuNo number(4),     
       stuName varchar2(20),
       age number(3),
       tel varchar2(15)
 );
--1）、添加约束
--主键约束
alter table student
      add constraint stu_no_pk primary key(stuNo);
--检查约束      
alter table student
      add constraint stu_age_ck check(age>=0 and age<=200);
      
--插入数据
insert into student
       values(1,'Mike',201,'234234');  
       
select * from student;  

delete from student;     
           
--2）、禁用约束
alter table student 
      disable constraint stu_age_ck;

--3）、启用约束
alter table student
      enable constraint stu_age_ck;

--5、删除约束
alter table student
      drop constraint stu_age_ck;





--创建部门表，包含：
--部门编号（数值类型）、部门名称(字符类型，非空）
create table department
(
       deptNo number constraint dept_no_pk primary key,
       deptName varchar(20) constraint dept_name_nn not null
);

create table users
(
       userId number,
       userName varchar2(20) not null,
       accountName varchar2(20) not null,
       pwd varchar2(20) not null,
       deptNo number,
       
       --添加约束
       constraint user_pk_id primary key(userId),
       constraint user_account_uq unique(accountName),
       constraint user_pwd_ck check(length(pwd)>=6 and length(pwd)<=20),
       constraint user_deptNo_fk foreign key(deptNo) references department(deptNo)
);

--创建员工表，包含：
--员工编号（数值类型，主键）、姓名（字符类型，非空）、
--账号（字符类型，非空、唯一）
--密码（字符类型，非空，长度为6~20，所属部门（数值，外键）


