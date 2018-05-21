--多表联合查询
--查询过程中使用多个表同时参与查询，最终结果将形成一个查询结果集
--目的：使数据更加完整

--查询班级信息
select * 
       from class;

--查询学生信息
select *
       from student;   

101    Mike   1     1   精英101
102    Jack   2     -   -

--1、笛卡尔乘积
--错误：一般不需要这样的查询结果
select *
       from student,class
       
--2、等值条件查询
--只有当条件表达式的值具有相同值时数据才会被显示
select *
       from student,class
       where student.classId = class.classId; 
       
--3、显示部分列
--当出现出现同名字段时，为了区分字段的所属表，
--需要使用表(别)名作为前缀进行标识。格式为：表(别)名.字段名
select stuNo,Student.name,student.classId,class.name
       from student,class
       where student.classId = class.classId; 
       
--4、表别名
--表别名方式可以使得查询语句更清晰简洁
select stuNo,s.name,s.classId,c.name
       from student s,class c
       where s.classId = c.classId; 
      
--查询所有的员工显示，同时显示员工的所属部门和部门所在地
--5、等值查询 VS 非等值查询
--查询员工的工号、姓名、所属部门、部门所在地及工资等级
select empno,ename,dname,loc,grade
       from emp e,dept d,salgrade s
       where e.deptno=d.deptno and (e.sal>=s.losal and e.sal<=s.hisal)
       
--查询员工的工号、姓名、直属经理及入职日期
--6、非自连接 VS 自连接
select a.empno,a.ename,b.ename,a.hiredate
       from emp a,emp b
       where a.mgr = b.empno

--7、多表连接
--1）、内连接     ：只有当条件表达式成立时数据才会出现在结果集中
--2）、外连接     
--     a、左外连接
--     b、右外连接
--     c、全外连接

--a、左外连接
--主表   ：未被(+）进行标记的条件所对应的表称为主表
--从表   ：被(+）进行标记的条件所对应的表称为从表
--左外连接：条件表达式中，“=”左侧的表作为主表
--左外连接查询时，将显示主表中所有的数据，从表中匹配的数据也会进行显示
--如果主表中数据在从表中没有匹配数据则直接使用null进行显示
select *
       from student s,class c
       where s.classId=c.classid(+); 
       
--b、右外连接
--右外连接 ：以条件表达式中“=”右侧的表为主表
select *
       from student s,class c
       where s.classId(+)=c.classid; 
       
--c、全外连接
--不支持该语法                        
select *
       from student s,class c
       where s.classId(+)=c.classid(+); 
       
--语法缺点：连接条件和查询条件都写在where语句中
--造成语句条件混乱，代码不够清晰

--8、Sql 99
--1)、交叉连接(笛卡尔乘积)
select *
       from student cross join class
       
--2）、多表连接
--a、内连接     ：【inner】 join ... on
select *
       from student a  join class b
       on a.classid = b.classid;

--b、左外连接  ：left 【outer】 join ... on
--以join语句左侧的表为主表，右侧表为从表。查询时会显示主表中所有数据
--从表中匹配数据会进行显示，不能被匹配的数在结果集中用null进行填充
select *
       from student a left join class b
       on a.classId= b.classId;       
              

--c、左外连接  ：right 【outer】 join ... on
--以join语句右侧的表为主表，左侧表为从表。查询时会显示主表中所有数据
--从表中匹配数据会进行显示，不能被匹配的数在结果集中用null进行填充
select *
       from student a right join class b
       on a.classId= b.classId; 
       
--d、全外连接(满连接)  ：full 【outer】 join 
--全连接相当于是两个表互为主表。查询结果是左外连接和右外连接的合集

--【思考：】交叉连接和全连接有什么区别？
--交叉连接的结果集是笛卡尔乘积；全连接的结果集是左连接 + 有连接
select *
       from student a full join class b
       on a.classId= b.classId; 
       
--3）、自然连接
--自动根据两个表之间的关联关系(关联字段)自动建立连接条件
--查询结果集与内联相似       
select *
       from emp natural join dept; 
       
--4）、using内联
--自动根据using()的字段名建立内联
--要求两表中必须同时都存在同名且同类型的列
--查询结果集与内联相似
select *
       from emp join dept using(deptno);                 
           
select *
       from student join class using(classId); 
       
--内联、自然连及using连接的区别
--内连接需要通过on关键字指定连接条件，表见可以不建立引用关系
--自然连接需要建立引用关系
--using连接需要具有相同的字段名，同时类型也要相同       
