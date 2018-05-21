--查询“SALES”的所有员工的信息
--方式一：连接查询
--缺点：通过连接形成一个新的表后造成数据量过多
--优点：一条语句完成查询
select e.*
       from emp e left join dept d
       on e.deptno = d.deptno
       where lower(d.dname)='sales'
       
--方式二：单独进行查询
--优点：查询过程中不会直接对大量数据进行操作
--缺点：需要执行多条语句
--查询部门编号
select deptno 
       from dept
       where dname='SALES';     
--查询员工表中部门编号为30的所有记录
select *
       from emp
       where deptno=30; 
       
--1、子查询
--把一个查询语句作为另一个查询语句的条件部分进行使用
--我们就把这样的查询语句称为子查询
select *
       from emp
       where deptno=(select deptno 
                            from dept where dname='SALES');
--2、分类
--1)、单行子查询
--只返回一行结果的子查询就称为单行子查询
--a、等值子查询
select *
       from emp
       where deptno=(select deptno 
                            from dept where dname='SALES');
                            
--b、非等值子查询
--查询所有工资比scott高的员工的信息
--步骤1 ：查询scott的工资
select sal
       from emp where lower(ename)='scott';
       
--步骤2：查询比scott工资高的员工信息
select *
       from emp
       where sal >(select sal
                          from emp where lower(ename)='scott')       
                            

--查询和scott在同一部门的所有员工的信息
--查询scott的所在部门
select deptno 
       from emp where lower(ename)='scott'  
       
--查询其他员工的信息
select *
       from emp
       where lower(ename) != 'scott' and deptno =(select deptno 
       from emp where lower(ename)='scott' )   
       
       
--c、注意事项
--错误：子查询只能返回单行单列的结果
--错误：子查询返回多列数据
select *
       from emp
       where deptno =(select deptno ,ename
              from emp where lower(ename)='scott' )   
              
--错误：子查询返回多行数据
select *
       from emp
       where deptno =(select deptno 
              from emp where lower(ename)='scott' or lower(ename)='allen')               
                   
--2)、多行子查询    
--子查询的返回结果为多行数据

--查询部门名称为RESEARCH或SALES的所有员工信息
select deptno
       from dept where dname='RESEARCH' or  dname='SALES'  
       
--【not】 in子查询     ：查询指定列的值是否包含在集合返回内
--只支持多行单列数据
select *
       from emp
       where deptno in(select deptno
             from dept where dname='RESEARCH' or  dname='SALES' )  

--错误，子查询返回了多列数据             
select *
       from emp
       where deptno in(select deptno,dname
             from dept where dname='RESEARCH' or  dname='SALES' )
             
--查询薪资高于部门编号为20的任意员工的工资
--查询部门编号为20的所有员工的薪资
select sal
       from emp where deptno = 20  

--any       ：与结果集中任意一个值匹配即可满足要求
select *
       from emp 
       where deptno != 20 and  sal >any(select sal
       from emp where deptno = 20) 
       
--=any     : deptNo和(10,15)中的任意一个值相等即可(与in子句相似)
select *
       from dept
       where deptno = any(10,15)              

-->any     ：deptno的值大于（10,25）中任意一个值即可             
select *
       from dept
       where deptno > any(10,25)              

--<any     ：deptno的值小于(10,25)中任意一个值即可                                                 
select *
       from dept
       where deptno < any(10,25) 
       

--查询比部门编号为20的所有员工工资高的员工信息   
--查询部门为20的所有员工工资    
select sal
       from emp where deptno = 20    

--all       ：与结果集中所有值均匹配即满足要求       
--一般不会出现 “= ”，因为无法满足
select *
       from emp
       where sal > all(select sal
             from emp where deptno = 20)   
             
-->all       ：查询比集合中所有值都大的记录
select *
       from dept
       where deptno >all(10,20,25)                                          
     
--<all       ：查询比集合中所有值都小的记录
select *
       from dept
       where deptno <=all(10,20,25)
       
--exists子查询
--exists     ：子查询语句是否有数据行返回
select * 
       from emp
       where exists(select * from emp where job='CLERK')
       
--in和exists的区别
--in   ：in子查询会将条件表达式的字段值与子查询的结果集中每一个字段值进行对比，
--如果值匹配则数据将被添加到查询结果集中，否则数据将被丢弃
/*
       List list = new ArrayList();
       list.add(1);
       list.add(2);
       
       //判断3在集合list中是否存在
       for(Object o : list){
                  if(o == 3) return true;
       }
       return false;
*/       


--exists   ：exists只判断子查询是否产生了查询结果集，
--如果子查询的行数大于0则返回true，否则返回false
/*
           List list = new ArrayList();
           list.add(1);
           list.add(2);
           
           return list.size()>0;
*/

--in子查询会返回查询结果集，exists子查询值返回布尔值

--说明
--1、连接查询可以用子查询进行替换
--2、如果查询结果来自于多个表，则需要使用连接查询；否则建议使用子查询
--3、尽量使用exists替代in




--查询销售部所有员工的信息
--显示员工的工号、姓名、入职日期、所属部门名称、工资等级
--分析：数据来源于不同的三个表，所以使用多表连接查询更合适
--1、查询所有员工信息
select *
       from emp;           
               
--2、对员工表和部门表进行连接查询（左连接）
select *
       from emp e, dept d
       where  e.deptno = d.deptno(+);  
       
--3、对员工、部门和薪资等级建立多表连接查询（左连接）
 select *
       from emp e, dept d ,salgrade s
       where  e.deptno = d.deptno(+) and e.sal between s.losal and s.hisal(+);          

--4、对语句进行最后修改
 select empno,ename,hiredate,sal,dname,grade
       from emp e, dept d ,salgrade s
       where  e.deptno = d.deptno(+) 
              and e.sal between s.losal and s.hisal(+)   
              and d.dName='SALES';
              
--a、执行员工表和部门表联查
/*
--三表查询的示例
select *
       from emp e left join dept d on e.deptno = d.deptno
                  left join bonus b on e.ename = b.ename;
*/

select *
       from emp e left join dept d on e.deptno = d.deptno
                  left join salgrade s on e.sal between s.losal and s.hisal
       where d.dname ='SALES';
 
--将查询结果集作为另一个查询语句的结果集进行使用      
select * from (select * from emp) a
                   
