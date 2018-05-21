--函数
--1、分类：单行函数、多行函数
--   1)、单行函数：输入数据为一个数据值，输出结果为一个数据值
--   2)、多行函数：输入数据为多个数据值，输出结果为一个数据值

--2、单行函数
--1)、字符函数
--a、lower()     ：将字符内容全部转为小写
select lower('AbcDe') 
       from dual;

--在查询条件中使用lower()，查询时不再需要关心内容的大小写问题      
select * 
       from emp
       where lower(job) ='clerk'
--b、upper()     ：将字符串内容全部转为大写
select upper('aBcDD')
       from dual;


--c、initcap()   ：将各单词首字母大写
select initcap('he chang you')
       from dual;
       
--两个相连的单词视为一个单词进行处理       
select initcap('he changyou')
       from dual;
          
select initcap(eName)
       from emp;    

--d、trim()      ：去除字符串内容的首尾空格(无法去除中间空格)
--ltrim()、rtrim()
select trim('    a  b     ') || 'd'
       from dual;

--e、lpad()      ： 使用指定字符从源字符串左侧进行填充。
--注：只有当源字符串的长度大于指定长度时才进行填充
--如果源字符串长度大于长度限制时，会对源字符串进行截取      
SELECT LPAD('Page 1',1,'*.') 
   FROM DUAL;

--f、rpad()      ：使用指定字符串从源字符串内容的右侧进行填充
SELECT rpad('Page 1',20,'*.') 
   FROM DUAL;
   
--g、replace()   ：使用指定字符内容替换源字符串中指定字符内容
select replace('chinese','e','E')
       from dual;

--h、substr()    ：从指定位置截取指定长度的字符内容
--索引下标从1开始
select substr('chinese',2,2)
       from dual;  
       
--i、length()    ：返回字符串的长度
select length('abc')
       from dual;      
       
--j、concat()    ：连接两个字符串
select concat('abc','123')
       from dual;      

--2)、数值函数
--a、mod()       ：求余函数(计算两个数相除的余数)
select mod(5,2)
       from dual;

--b、round()     ：四舍五入函数
select round(2.5632,2),round(2.5632,1),round(2,2)
       from dual;
       
--c、trunc()     ：截取函数       
select trunc(2.5632,2),trunc(2.5632,1),trunc(2,2)
       from dual;

--3)、日期函数
--a、sysdate     ：返回当前的系统时间
select sysdate 
       from dual;
       
--b、日类型数据的运算
--日期类型可以与整数类型的数据执行加、减运算。运算结果=当前日期+n天
--日期类型不支持乘除运算
select sysdate + 5.7
       from dual;
       
select sysdate - 5
       from dual;       
--错误：sysdate与5会执行算术运算
select sysdate * 5
       from dual;
--两个日期之间如果执行减法运算，则相当于计算两个日期之间的时间差       
select sysdate-hiredate
       from emp;       
       
--c、months_between()：计算两个日期之间的月份差
select months_between(sysdate,hiredate)
       from emp;
       
--d、add_months() ：在当前日期基础上增加n个月
select add_months(sysdate,2)
       from dual;
       
--某员工与公司签订了2年的就业合同，计算员工的离职时间
select add_months(sysdate,12*2)
       from dual;       


--d、last_day()   ：获取当前日期的最后一天
select last_day(sysdate+5)
       from dual;
       
--e、next_day()   ：获取当前星期在下一周的日期
select next_day('1-1月-2017','星期五')
       from dual;
       
SELECT NEXT_DAY(to_date('2017-2-1','yyyy-MM-dd'),'TUESDAY') 
     FROM DUAL;
       
--f、trunc() ：对日期的指定部分进行截取，其余部分用1进行表示   
--year、month、day  
select trunc(sysdate, 'DAY')
       from dual;

--g、round()   ：对日期进行四舍五入       
select round(sysdate,'year')
       from dual;   

--4)、转换函数
--类型转换 : 隐式转换(自动进行)、显式转换(函数)
--a）、隐式转换
--varchar2（char) <---> number
--varchar2（char) <---> date

--varchar2（char) ---> number
select 2+'6'
       from dual;
--varchar2（char) <--- number       
select 2 || '6'
       from dual;       
--varchar2（char) ---> date
select add_months('14-1月-2017',4)
       from dual;
--varchar2(char) <--- date       
select sysdate || 'abc'
       from dual;  
       
-- b)、显示转换
--不是所有字符类型都可以和date、number自动实现转换操作
--oracle提供了一些函数来实现类型的强制转换功能
--①、to_char()   ：可以将日期、数值类型的数据转为character类型
--将数值转为字符类型
select 0001,to_char(0001)
       from dual;  
       
--将日期转为字符类型       
select to_char(sysdate)
       from dual;  
       
--②、to_number()   ：将字符类型转为数值类型
select to_number('20')
       from dual;   

--③、to_date()     ：将字符类型转为日期类型
select to_date('2012-02-03','yyyy-MM-dd')
       from dual;  
       
--④、nvl()        ：判断参数1的值是否为null或''，
--如果是则返回参数2的值，否则返回参数1的值
select nvl(null,'abc'),nvl('','abc'),nvl('1','abc')
       from dual;                            
       
--计算员工的当月应发工资=工资 + 奖金
select EmpNo,Ename,sal + nvl(comm,0)
       from emp;  
      
--⑤、nullif()     ：判断两个表达式的结果是否相等
--如果相等则返回nnull，否则返回表达式1的结果
select nullif(3,2),nullif('3',''),nullif('',''),nullif(3,3)
       from dual;     


--5)、case...then语句
select EmpNo,Ename,case deptno
                        when 10 then 'ACCOUNTING'
                        when 20 then 'RESEARCH'
                        when 30 then 'SALES'
                        else 'Other'
                   end
       from emp;
--3、多行函数
--sum()、avg()只能用于数值类型的列
--min()、max()可以用于在日期、字符及数值类型的列上进行使用

--a、count()        ：统计数据行(值为非空的)的数量
select count(*),count(comm)
       from emp;
       
--b、sum()          ：对指定列中所有的值进行累加
select sum(sal),sum(comm)
       from emp;   

--c、avg()          ：对指定列中的数据进行求平均运算       
select avg(sal),avg(comm)
       from emp; 
--计算平均值时建议使用avg()函数       
select avg(sal), sum(sal) / count(sal)
       from emp;    

--d、min()         ：返回列中最小值       
--e、max()         ：返回列中最大值
select min(comm), max(comm)
       from emp;  
       
select min(job),min(hiredate)
       from emp;               
       
select hiredate
       from emp;
       
select * from class                      
