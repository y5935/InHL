select *
       from emp;
       where trunc(t.字段名)>=to_date('1980-01-01','yyyy-mm-dd')
       and trunc(t.字段名)<to_date('1986-01-01','yyyy-mm-dd'
select getdate()

--1. 查询所有员工的编号、姓名、岗位
select empno,ename,job 
       from emp;
       
--2. 查询所有的岗位列表
select distinct job
       from emp; 
       
select job
       from emp
       group by job;
       
--3. 若要求按照以下的格式进行结果输输，格式如下：NO:7469 
Name:SMITH Job:CLERK

select 'NO:'||empno||'Name:'||ename||'job:'||job as info
       from emp;

--4. 查询每个员工的姓名及年薪
select ename,sal*12 as yearsal
       from emp;
       
--5. 查询基本工资不大于 1500，同时不可以领取奖金的员工信息
select *
       from emp
       where sal<=1500 and comm='0' or comm is null;
       
--6. 查询在 1981 年入职的全部员工信息
select *
       from emp
       
       where year(hiredate)=year(getdate(1981))
 

--7. 要求查询出员工编号不是 7369、7499 的员工信息

select *
       from emp
       where empno!=7369 and empno!=7499;
  
select *
       from emp
       where empno not in (7369,7499);
       
--8. 要求对员工的工资由低到高进行排序
select *
       from emp
       order by sal ;
       
--9. 查看出部门号为 10 的员工信息，查询的信息按照工资从高到低，
若工资相等则按入职日期从早到晚排列
select *
       from emp
       where deptno=10
       order by sal desc ,hiredate asc
--10. 找出部门 10 中所有经理(MANAGER)和部门 20 中所有办事员
(CLERK)的详细资料
select *    
       from emp 
       where （deptno=10 and job='MANAGER'） or （deptno=20 and job='CLERK'）;
       
--11. 找出既不是经理又不是办事员但其薪金大于或等于 2000 的所有
员工的资料
select *
       from emp
       where job!='MANAGER'and job!='CLERK' and sal>=2000;
       
--12. 显示不带有"R"的员工的
select *
       from emp
       where ename  not like '%R%'
       
        
