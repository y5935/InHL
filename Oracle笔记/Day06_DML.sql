--DML
select * from user_tables
select * from score

--1、增(插入数据)
--语法：insert into 表名(字段名列表) values(值列表)
--向score表插入数据

--1)、为所有列插入数据
--a）、带有列名：为所有字段(列)都插入数据
insert into score(stuno,stuname,age,birthday,gender)
       values(1,'Mike',20,'3-1月-2018','T')
--b)、省略列名：为所有字段(列)都插入数据
--省略字段列表插入数据时，必须为所有字段显示提供值(包含默认值列)  
--如果只提供部分列的数据值，插入将失败     
insert into score
       values(2,'Jack',22,'3-2月-2018','T') 
       
--执行失败       
insert into score
       values(3,'Rose',18)             
--2）、为部分列提供数据
--为部分列插入数据时，必须显示提供字段名列表
insert into score(stuno,stuname,age)
       values(3,'Rose',18)

--显式提供字段列表时，字段的先后顺序可以不和表结构一致
insert into score(stuname,stuno,age)
       values('Rose',3,18)
       
--3）、导入数据       
insert into score(stuno,stuname)
       select stuNo,name from student
       
--带条件的插入语句 
insert into score(stuno,stuname)
       select stuNo,name from student
       where stuNo != 1  
       
--注意：           
--①、字段名和值的位置必须一一对应
--②、插入数据的长度必须小于或等于字段的长度
--③、插入数据时，必须符合字段的约束


--2、改
--语法：update 表名 set 字段名 = 值 [，......]
--             [where 条件表达式]

--1)、省略了where语句：将更新当前表中所有数据行
update score set age = 20;

--2）、带有where语句：将更新符合条件的所有数据行
update score set age = 20
       where stuname='Mike'
       
--3)、带条件的多字段更新语句       
update score set age = 22,birthday='3-1月-2018',gender='t'
       where stuno=102

--注意事项
--     ①、如果省略了where条件将更新所有的数据行

select * from score;

--3、删
--语法：delete [from] 表名  [where 条件表达式]
--1）、带条件的删除语句：只删除符合条件的数据
--a、带有from子句
delete from  score where stuno=103;            
--b、省略了from字母
delete  score where stuno=103;

--c、不带条件的删除语句：删除所有的数据行
delete score;

select * from score;

--注意事项
--     ①、省略了where条件的删除语句将删除所有的数据行
--     ②、删除数据时不能违反主外键约束

--4、清空表数据
--1）、delete语句
--清除后的数据可以被回滚
delete student;

--2）、truncate语句
--清除后的数据无法被回滚
truncate table student;


select * from student;

--DCL
--rollback    ：回滚操作，将所有对数据的操作恢复到上一次提交的状态
--commit      ：对所有没有进行提交的数据提进行提交，提交后的数据将处于持久化状态
--rollback、commit只对dml语句有效，对ddl语句无效(也可以理解为ddl的语句是自提交的)
--执行插入语句
insert into score(stuno,stuname,age,birthday,gender)
       values(1,'Mike',20,'3-1月-2018','T');
       
insert into score(stuno,stuname,age,birthday,gender)
       values(2,'Rose',18,'3-2月-2018','F');       

--将缓冲区中的数据提交到数据库中
commit;       
--将数据恢复到插入前的状态(操作被回滚了)       
rollback;       
 
      
select *
       from score;       

