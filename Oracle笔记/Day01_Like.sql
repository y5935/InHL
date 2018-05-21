--模糊查询
--查询薪资范围在1100~1500之间的所有员工信息
--1、指定取值范围的模糊查询
--a、关系运算符进行筛选
select *
       from emp
       where sal >=1100 and sal<=1500;
       
--b、使用between...and语句进行筛选(包含边界的表达式)
select *
       from emp
       where sal between 1100 and 1500;
       
--2、部分内容进行匹配
--%          ：通配符，表示任意长度的任意内容
--(not)like  : 按照指定格式进行查询
select *
       from emp
       where ename like 'S%';   
 
select *
       from emp
       where ename not like 'S%';       
--查询所有姓名中包含字母T的员工姓名           
select *
       from emp
       where ename like '%T%';
       
--查询所有姓名中倒数第二个字母是T的员工姓名
--_          ：通配符，表示一个长度的任意字符
select *
       from emp
       where ename like '%T_';
       
--查询部门编号为10和30的所有员工信息
select *
       from emp
       where deptno=10 or deptno=30;   
--（not）in   : 运算符，判断指定字段的值是否在集合范围内       
select *
       from emp
       where deptno in (10,30);

select *
       from emp
       where deptno not in (10,30) ;
--查询所有没有奖金的员工信息
--is (not) null  : 判断字段的值是否为null
--null不是特定的值，他只是一个标记。所以无法用“=”进行比较       
select *
       from emp
       where comm is null;
  
--查询所有奖金不为null的员工信息
select *
       from emp
       where comm is not null;
       
--日期查询
--查询1980-12-17日入职的员工信息
--如期类型数据需要用''引起来
select * 
       from emp
       where hiredate ='1-1-80'
                          
