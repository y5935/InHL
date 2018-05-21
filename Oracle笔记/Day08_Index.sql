--1、rowid和rownum伪列
--1)、rowid
--rowid是在记录创建时自动产生的记录编号。默认情况下rowid是不显示的
--rowid记录了数据在物理磁盘上的位置,rowid是记录的物理地址
--通过rowid可以快速定位到记录
--除非记录位置发生改变，否则rowid的值是固定不变的

--格式：OOOOOO  FFF   BBBBBB   RRR


--查询emp表数据
select *
       from emp;
       
--插入一条数据
insert into emp 
       values(9000,'Terry','CLERK',7566,'2-2月-2008',900,0,10)
       
--带有rowid的查询
select e.*,rowid 
       from emp e;  
       
--2）、rownum
--rownum是执行查询时所产生的一个顺序号。每次查询时顺序号都是从1开始
--rownum作为where条件时，只能与<或<=连用(因为每次查询时数据的rownunm会重新产生)

--查询所有数据
select e.*,rownum 
       from emp e;
       
--查询符合条件的所有数据 (部分数据)
--rownum重新从1开始
select e.*,rownum 
       from emp e
       where sal >2200;

--查询后排序
--rownum与记录的顺序对应，但现实位置发生改变
--rownum在执行select语句时产生，order by执行时rownum已经存在           
select rownum ,e.*
       from emp e
       where sal >2200
       order by sal desc; 
       
--top-n
--a）、查询薪资最高的三名员工的信息
--错误：使用<=或>=都无法达到需要的效果
select rownum ,e.*
       from emp e 
       where rownum >=3
       order by sal desc; 
--正确做法：
--第一步：对数据进行排序       
select e.*
       from emp e 
       order by sal desc; 
       
--第二步：将排序后的数据视为一个新表，然后从新表中进行查询
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t;      
                    
--第三步：对有序数据进行筛选
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t  
       where rownum<=3; 
       
       
--b）、查询薪资排序是第4~6的员工信息(分页显示)
--错误：无法查询到任何数据      
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t  
       where rownum>3 and rownum <=6; 
       
--正确
--第一步：查询得到6条数据
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t  
       where  rownum <=6; 
       
--第二步：将查询结果作为一个基础表进行使用
select *
       from (select rownum as id, t.*
                 from (select e.*
                              from emp e 
                              order by sal desc) t  
                 where  rownum <=6)
       where id >3; 
       

--2、索引
--a、描述 ：索引就像字典的目录。索引和数据表是独立存储的。
--b、作用 ：有效提高数据的查询效率(没有采用索引时查询使用的是全表扫描)
--c、实现 ：索引采用了B+树方式进行实现的。
--d、分类 ：
--   ①、默认索引：创建主键、唯一约束时会自动创建索引 
--   ②、手动方式：一般索引、位图索引

/*
--   聚集索引：对数据的物理顺序进行重排，只能创建一个
--   非聚集索引：可以有多个 
*/

--e、创建条件
--   ①、数据分布范围较广
--   ②、数据较多
--   ③、经常作为where条件或表连接使用
--   ④、数据覆盖范围占数据总数的2%-4%
--f、不需要创建的条件
--   ①、数据表非常小
--   ②、数据较为集中
--   ③、一般不在where条件中出现的字段
--   ④、经常做增删改的数据不建议建索引

--g、创建索引
--①、语法：
/*
     create [bitmap|unique] index 索引名
            on 表名(列名 [asc|desc])
*/

--②、为ename列创建索引
create index emp_idx_ename
       on emp(ename asc);
       
--使用索引
--特点：索引不需要显式使用，当用到索引列时，索引将被自动使用（**）
select * 
       from emp
       where ename like 'A%';
       
--③、为部门列创建索引
--当数据分布的范围非常小，建议使用bitmap索引
create bitmap index emp_idx_deptno
       on emp(deptno);
       
--④、为部门和工资创建索引
--复合索引：使用时，只有同时使用复合索引中所有字段时索引才会生效
create index emp_idx_sal_dept
       on emp(deptno asc,sal desc);       

--h、删除索引
drop index emp_idx_sal_dept;

--i、索引的缺点
--对数据表进行insert、delete及update操作时，需要同时维护索引文件
--索引创建索引后，会降低insert、delete及update的执行效率
--j、使用建议
--   ①、非必要情况下，不要随意创建索引
--   ②、定期对索引进行重建 

--k、重建索引
alter index 索引名;    



--3、存储过程
--1）、概述
--    存储过程是一组预编译指令的集合。
--2）、优点
--    a、节省网络流量
--    b、提高安全性
--    c、提高执行效率
--3）、语法
/*
      create procedure 存储过程名(参数列表)
      as
      begin
           语句段;
      end
      
*/  

--4)、示例
--①、简单存储过程---无参数存储过程
--如果没有任何参数()可以省略
--语句段只有一条语句则begin和end可以省略，但是不建议
create procedure pro_emp_add as
begin
       insert into dept values(50,'Design','北京');
       commit;
end pro_emp_add;
       
--使用存储过程
pro_emp_all;

select * from dept;

--②、带参数存储过程
create or replace procedure pro_emp_del(no number) as
begin
       delete dept where deptno=no;
       commit;
end pro_emp_del;

--调用存储过程
begin
    pro_emp_del(50);
end;   


--③、参数
--参数方向：in--输入参数；out--输出参数;int out--输入输出参数
--输入一个部门编号后，返回部门名称
create or replace procedure pro_dept_getname(no in number,n out varchar2(14))
as
begin
       select dname into n
              from dept where deptno =no;  
end pro_dept_getname;    


    
                                                                   
