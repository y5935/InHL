--1、查询所有员工编号、 姓名、岗位
select EmpNo,EName,Job
       from emp;

--2、查询所有的岗位列表 
select Job
       from emp
       group by job;
 
select distinct Job
       from emp;      


--3、若要求按照以下的格式进行结果输，如：NO:7469 Name:SMITH Job:CLERK
select 'No:' || EmpNo || ' ' || 'Name:' || EName || ' ' || 'Job:' || job as Info
       from emp;

--4、查询每个员工的姓名及年薪
select EName, Sal * 12 as sal
       from emp;
       
--5、查询基本工资不大于 1500 ，同时不可以领取奖金的员工信
select *
       from emp
       where sal<=1500 and (comm is null or comm = 0)
       
--、7、要求查询出编号不是 7369 、7499的员工信息
select *
       from emp
       where Empno != 7369 and Empno <>7499

select *
       from emp
       where EmpNo not in(7369,7499)
       
--8、要求对工资由低到高进行排序
select * 
       from emp
       order by sal;
       
--9、查看出部门号为10的员工信息，查询的信息按照工资从高到低，
--若工资相等则按入职日期从早到晚排列
select *
       from emp
       where deptno=10
       order by sal desc,hiredate asc



--10、找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK)的详细资料      
select *
       from emp
       where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK')


--11、找出既不是经理又不是办事员但其薪金大于或等于2000的所有员工的资料
select *
       from emp
       where job !='MANAGER' and job !='CLERK' and sal>=2000
       
--12、显示不带有"R"的员工的姓名
select *
       from emp
       where EName not like '%R%';
