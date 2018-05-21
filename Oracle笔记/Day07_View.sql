--查询员工信息。显示员工的编号、姓名、所属部门、工资等级、
--应发工资(sal + comm)
--第一步：查询员工工资
select empno,ename,deptno,sal + nvl(comm,0) as total 
       from emp;
       
--第二步：查询员工所在部门
select empno,ename,dname,sal + nvl(comm,0) as total 
       from emp e left join dept d on e.deptno = d.deptno;      
       
--第三步：查询工资等级
 select empno,ename,dname,grade, sal + nvl(comm,0) as total 
       from emp e left join dept d on e.deptno = d.deptno      
                  left join salgrade s on e.sal between s.losal and s.hisal; 
                  
--问题一、花费时间较多                  
--问题二、语句较为复杂
--问题三、存在隐私问题

--视图(View)
--1、什么是视图
--视图是一种虚拟的表，视图的本质是一段查询语句。视图中的数据来自于数据表(基表)

--2、视图的作用
--a、复杂语句简单化
--b、提高安全性

--3、视图的语法
/*
     create view 视图名
     as
            语句;
*/

--4、创建视图
--1)、简单视图
create view vw_emp
as
       select * from emp;
       
--使用视图
select * from vw_emp;

--2）、视图中的语句包含where条件
create view vw_emp2
as
       select * from emp where job = 'CLERK';

--使用视图
select * from vw_emp2;

--3）、创建多表查询的视图
create view vw_emp3
as
      select empno,ename,dname,grade, sal + nvl(comm,0) as total 
             from emp e left join dept d on e.deptno = d.deptno      
                  left join salgrade s on e.sal between s.losal and s.hisal;  

--使用视图
select * from vw_emp3;

--4）、基于视图的视图
--语句使用另一个视图进行查询
create view vw_emp4
as
       select * from vw_emp3 where grade=3;

--使用视图
select * from vw_emp4;

--操作视图的数据
--视图支持DML操作(insert、delete及update)
--对视图执行DML操作时，如果视图是涉及到多表的复杂视图，
--因为涉及到数据完整性，操作可能是失败
--a、从视图中查询数据
select * from  vw_emp

--b、向视图中插入数据----数据插入成功，基表受影响
insert into vw_emp 
       values(9000,'LaoDa','CLERK','7369','4-1月-2018',4000,50,20)

--c、删除视图中的数据----数据删除成功，基表受影响
delete vw_emp where empno=9000; 

--d、修改复杂视图中的数据 
--修改vw_emp4中编号为7499的数据。将Ename的值从Allen 改为 Terry
update vw_emp4 set Ename='TERRY' where EMPNo=7499;  

--e、删除复杂视图中的数据
--删除编号为7499的数据
delete vw_emp4 where empno=7499;
   
select * from emp;

--5、修改视图
create or replace view vw_emp
as
       select * from emp where job='CLERK';
       
--使用视图
select * from vw_emp;       

--6、删除视图
drop view vw_emp;

--7、注意事项
--1）、视图可以嵌套视图使用，但不要超过三层
--2）、视图中不能使用除查询语句以外的语句


--8、权限分配
--grant 权限 to 用户;
--只能由更高权限的用户进行分配，用户无法为自己分配权限
grant create any view to scott;

--9、只读视图
--只读视图只能查询数据，无法修改数据
create or replace view vw_emp
as
       select * from emp where job='CLERK'
       with read only;

--序列---sequence
--1、作用：提供一个有序的数值序列。
--2、语法
/*
       
  create sequence 序列名
         increment by 数值       --设置增长速度
         start with 数值         --设置起始值
         [ maxvalue 数值 | NOMAXVALUE ]      --最大值
         [minvalue 数值 | NOMINVALUE ]       --最小值
         [cycle | nocle ]                    --是否回收
         
*/

--increment        ：增长


--3、创建序列
create sequence user_id
       start with 1001
       increment by 1;
       
--4、使用序列1
--currval        ：获取当前的序列值
--注意：只有调用过nextval后才能使用currval
select user_id.currval
       from dual;   
--nextval        ：获取下一个序列的值       
select user_id.nextval
       from dual;    
       
--5、使用序列2
create sequence user_id2
       increment by 1
       start with 1
       maxvalue 5                            
       minvalue 1;              

--使用序列
--当达到maxvalue值时将出现异常
select user_id2.nextval
       from dual;    
       
--6、使用序列3
create sequence user_id3
       increment by 1
       start with 1
       maxvalue 5                            
       minvalue 1
       cache 4
       cycle;          
        
--加入cycle后当达到最大值时可以重新开始
--cycle必须和cache连用，且cache的值必须小于maxvalue
select user_id3.nextval
       from dual; 
       
--7、序列的使用 
--在插入数据时为数据列提供一个连续的值
select * 
       from department; 
       
insert into department values(user_id.nextval,'软件事业部');            
insert into department values(user_id.nextval,'市场部');
insert into department values(user_id.nextval,'公关部');
       
--8、裂缝 ：所谓裂缝就是在使用过程中产生了不连续的数据
--产生原因：
--a、多个数据表公用了一个序列
--b、数据插入失败，数据被回滚(序列无法回滚)
--c、执行过程中产生了异常

insert into department values(user_id.nextval,'总监办');
rollback;

--9、建议
--建议使用过程中尽量为每一个表建立一个独立的序列              
