--1、特点
--1)、Sql语句不区分大小写
--2)、Sql语句支持单行和多行方式
--3)、子句独占一行
--4)、支持缩进

--2、dual
--临时表，主要用于补齐语法(oracle中select语句的from子句不允许缺省)
--a、语句全部小写
select 2 
       from dual;
--b、语句全部大写
SELECT 3 
       FROM DUAL;

--3、语法：select 查询内容 from 来源
select 'a' 
       from dual;  
       
--4、运算符
--算术运算符：+、-、*、/
select mod(2,3)
       from  dual;
       
--关系运算符:>、>=、<、<=、<>（！=）、=
--select 2>3
--       from dual;
       
--连接运算符:||
select 2 || 'a' || 'c'
       from dual;
       
--5、测试表结构
--表名：dept(部门表)
--DeptNo    ：记录编号
--DName     : 部门名称
--Loc       ：部门所在地

select * from dept;

--表名：Emp(雇员表，员工表)
--EmpNo    : 员工编号
--EName    : 员工姓名
--Job      ：职位
--MGR      ：直属领导
--HireDate ：入职时间
--Sal      : 薪资
--Comm     : 奖金
--DeptNo   : 所属部门编号

select * from Emp;

--表名：SalGrade（薪资等级）
--Grade    : 等级
--Losal    : 最低薪资
--Hisal    : 最高薪资

select * from salgrade;

--表名：Bonus(奖金)
--Ename    : 职员姓名
--Job      : 职位、岗位
--Sal      ：薪资
--Comm     ：奖金

--6、select语句
--查询所有员工的信息
--*  ：通配符，表示所有字段(实际使用时尽量避免使用)
--返回所有数据列
select *
       from emp;
       
--字段列表方式
--可以返回部分数据列，提高查询效率
select EmpNo,EName,Job,MGR,Hiredate,sal,comm,deptNo
       from emp;  
       
--从员工表中查询员工都属于哪些部门
select deptno 
       from emp; 
  
--7、排除语句     
--从员工表中查询员工都属于哪些部门（不显示重复的部门编号）
--distinct子句 ：消除重复记录
select distinct deptno 
       from emp;             
--没有使用排除语句
select deptno，job 
       from emp; 
--使用排除语句：参考deptNo和job两个字段进行排除
select distinct deptno，job 
       from emp;  
       
--8、条件语句
--查询所有Clerk(职员)的信息
select * 
       from  emp
       where job = 'CLERK';
       
--查询工资高于1100元的所有员工信息
select *
       from emp
       where sal >=1100;
--查询部门编号是10或者30的所有员工信息       
select * 
       from emp
       where deptno=10 or deptno=30;       
       
--查询部门编号为10的部门经理的信息
--显示：姓名、职位、薪资(薪资+奖金)  
--a、任何数据和null进行算数运算时，其结果均为null
--b、可以为查询字段列表中的各字段(或表达式）设置别名
--c、查询结果中可以使用函数和表达式
--d、where子句中的条件表达式可以由多个部分组成，并通过逻辑运算符进行连接
--e、not、and、or
select EName,job, sal + comm sal
       from emp
       where deptno=10 and job = 'MANAGER';   
       
--9、分组语句
--统计各部门员工数量
--count()              : 统计查询结果的总行数
--group by子句         : 按指定字段对数据进行分组
select deptNo,count(*)
       from emp
       group by deptno;

--a、使用分组查询时，查询字段列表中只能出现分组字段及聚合函数表达式  
--b、分组条件越多(字段越多)查询结果越多     
select deptNo,job
       from emp
       group by deptno,job;
         
--查询部门人数多于6人的部门编号及人数 
--10、having     : 对分组后的数据进行条件查询
--where子句是对分组前的数据进行筛选；having子句是对分组后的数据进行筛选        
select deptno,count(deptno)
       from emp
       group by deptno       
       having count(deptno)>=6;
       
--按薪资从高到低的顺序进行排序
--11、order by   : 按照指定排序方式对字段的值进行排序
select *
       from emp
       order by sal;       
--order by子句的参数
--asc(默认)    ：按照升序方式进行排序
select * 
       from emp
       order by sal asc;
--desc         : 按照降序方式进行排序
select * 
       from emp
       order by sal desc;

--sum()         : 对指定列的数据进行汇总
select deptNo, sum(sal) as total
       from emp
       where sal >1100
       group by deptno
       having sum(sal)>8700
       order by total
       
       
