--DDL
--1、Oracle中常用对象（了解）
--  表（Tables）           ：存储数据的基本单位，表由行和列(字段)组成
--  视图(Views)            ：一个虚拟表，数据来自于各个表
--  存储过程（Procedures） : 一个功能代码段(可以理解为java的方法)
--  序列(Squeences)        ：顺序产生一个有规律的数字
--  索引(indexes)          ：一种排序方式

--2、数据字典                 ：存储数据库的信息(其实就是表)

--user_tables（视图）      ：返回所有用户表的信息
select * 
       from user_tables;
       
--user_objects（视图）     ：返回所有用户表及约束信息
select *
       from user_objects;  

--user_catalog(视图)       ：返回当前用户的所有分类       
select *
       from user_catalog;  
       
--3、命名规范
--a、以字母、数字、"_"、"$"及"#"组成
--b、长度不能超过30个字符
--c、不能使用oracle的关键字和保留字 
--d、不能使用已经存在的对象名进行重复命名

--4、数据类型(掌握)
--varchar2（长度）           ：可变长度的字符类型(将多余空间进行回收)，存储需要空间较多，且长度不固定的数据
--char(长度)                 ：长度不可变的字符类型 ，一般多用于存储长度确定的数据。如：手机号码、身份证号码                    
--number(n,m)                ：表示数值类型，可以存储整数和浮点数；n表示总长度，m表示小数位数
--long                       ：长字符类型，最大可以存储2G内容
--date                       ：日期类型
--clob                       ：存储字符类型数据，最大可以存储4G内容
--blob                       ：存储二进制类型数据，最大可以存储4G内容



--5、建表(掌握)
--1）语法
create table 表名
(
       列名 类型[(size)][,]
       ......       
);

--2)建表
--a、白手起家方式
create table score
(
       stuNo number,                   --学号
       stuName varchar2(10)，          --姓名
       age number,                     --年龄
       birthDay date,                  --出生日期
       gender char(2)                  --性别
)

select * from score;
select * from user_tables;

--b、继承方式
--创建一个与emp表同结构的新表,同时会复制数据
create table emp2
as
       select * from emp;
select * from emp2;

--创建一个与emp具有部分相同字段的新表，同时会复制数据
create table emp3
as
       select EmpNo,Job,MGR,Sal from emp;
       
select * from emp3;
       
--创建一个与emp具有相同字段的新表，不复制数据
create table emp5
as
       select * from emp where --deptno = 1;
                               1=2;
       
select * from emp5;

--创建一个基于多表的新表
create table emp6
as
       select empno,ename,sal,dname
              from emp e left join dept d on e.deptno = d.deptno
              where 1=2;
select * from emp6;              

select * from user_tables;
       

--6、修改表
--a、修改列
select * from student

--语法：alter table 表名 modify 列名 类型[（size）]
--修改student表的name字段。长度改为50个长度
alter table student
modify name varchar2(50);

--修改student表的name字段。长度改为2个长度
--表中无任何数据，可以随意修改
--表中有数据，列的新长度必须和数据的最大长度相等(小于最大长度会报错)
--表中有数据，列的类型必须是同类型或大于当前的类型
alter table student
modify name varchar2(2);

select * from student;
--b、修改表名
--语法：rename 原表名 to 新表名
rename emp6 to emp7;

--7、删除表
--语法：drop table 表名;
drop table emp7;
--删除一个表存在的表会出现异常
drop table emp6;
