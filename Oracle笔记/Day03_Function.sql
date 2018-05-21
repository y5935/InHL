--����
--1�����ࣺ���к��������к���
--   1)�����к�������������Ϊһ������ֵ��������Ϊһ������ֵ
--   2)�����к�������������Ϊ�������ֵ��������Ϊһ������ֵ

--2�����к���
--1)���ַ�����
--a��lower()     �����ַ�����ȫ��תΪСд
select lower('AbcDe') 
       from dual;

--�ڲ�ѯ������ʹ��lower()����ѯʱ������Ҫ�������ݵĴ�Сд����      
select * 
       from emp
       where lower(job) ='clerk'
--b��upper()     �����ַ�������ȫ��תΪ��д
select upper('aBcDD')
       from dual;


--c��initcap()   ��������������ĸ��д
select initcap('he chang you')
       from dual;
       
--���������ĵ�����Ϊһ�����ʽ��д���       
select initcap('he changyou')
       from dual;
          
select initcap(eName)
       from emp;    

--d��trim()      ��ȥ���ַ������ݵ���β�ո�(�޷�ȥ���м�ո�)
--ltrim()��rtrim()
select trim('    a  b     ') || 'd'
       from dual;

--e��lpad()      �� ʹ��ָ���ַ���Դ�ַ�����������䡣
--ע��ֻ�е�Դ�ַ����ĳ��ȴ���ָ������ʱ�Ž������
--���Դ�ַ������ȴ��ڳ�������ʱ�����Դ�ַ������н�ȡ      
SELECT LPAD('Page 1',1,'*.') 
   FROM DUAL;

--f��rpad()      ��ʹ��ָ���ַ�����Դ�ַ������ݵ��Ҳ�������
SELECT rpad('Page 1',20,'*.') 
   FROM DUAL;
   
--g��replace()   ��ʹ��ָ���ַ������滻Դ�ַ�����ָ���ַ�����
select replace('chinese','e','E')
       from dual;

--h��substr()    ����ָ��λ�ý�ȡָ�����ȵ��ַ�����
--�����±��1��ʼ
select substr('chinese',2,2)
       from dual;  
       
--i��length()    �������ַ����ĳ���
select length('abc')
       from dual;      
       
--j��concat()    �����������ַ���
select concat('abc','123')
       from dual;      

--2)����ֵ����
--a��mod()       �����ຯ��(�������������������)
select mod(5,2)
       from dual;

--b��round()     ���������뺯��
select round(2.5632,2),round(2.5632,1),round(2,2)
       from dual;
       
--c��trunc()     ����ȡ����       
select trunc(2.5632,2),trunc(2.5632,1),trunc(2,2)
       from dual;

--3)�����ں���
--a��sysdate     �����ص�ǰ��ϵͳʱ��
select sysdate 
       from dual;
       
--b�����������ݵ�����
--�������Ϳ������������͵�����ִ�мӡ������㡣������=��ǰ����+n��
--�������Ͳ�֧�ֳ˳�����
select sysdate + 5.7
       from dual;
       
select sysdate - 5
       from dual;       
--����sysdate��5��ִ����������
select sysdate * 5
       from dual;
--��������֮�����ִ�м������㣬���൱�ڼ�����������֮���ʱ���       
select sysdate-hiredate
       from emp;       
       
--c��months_between()��������������֮����·ݲ�
select months_between(sysdate,hiredate)
       from emp;
       
--d��add_months() ���ڵ�ǰ���ڻ���������n����
select add_months(sysdate,2)
       from dual;
       
--ĳԱ���빫˾ǩ����2��ľ�ҵ��ͬ������Ա������ְʱ��
select add_months(sysdate,12*2)
       from dual;       


--d��last_day()   ����ȡ��ǰ���ڵ����һ��
select last_day(sysdate+5)
       from dual;
       
--e��next_day()   ����ȡ��ǰ��������һ�ܵ�����
select next_day('1-1��-2017','������')
       from dual;
       
SELECT NEXT_DAY(to_date('2017-2-1','yyyy-MM-dd'),'TUESDAY') 
     FROM DUAL;
       
--f��trunc() �������ڵ�ָ�����ֽ��н�ȡ�����ಿ����1���б�ʾ   
--year��month��day  
select trunc(sysdate, 'DAY')
       from dual;

--g��round()   �������ڽ�����������       
select round(sysdate,'year')
       from dual;   

--4)��ת������
--����ת�� : ��ʽת��(�Զ�����)����ʽת��(����)
--a������ʽת��
--varchar2��char) <---> number
--varchar2��char) <---> date

--varchar2��char) ---> number
select 2+'6'
       from dual;
--varchar2��char) <--- number       
select 2 || '6'
       from dual;       
--varchar2��char) ---> date
select add_months('14-1��-2017',4)
       from dual;
--varchar2(char) <--- date       
select sysdate || 'abc'
       from dual;  
       
-- b)����ʾת��
--���������ַ����Ͷ����Ժ�date��number�Զ�ʵ��ת������
--oracle�ṩ��һЩ������ʵ�����͵�ǿ��ת������
--�١�to_char()   �����Խ����ڡ���ֵ���͵�����תΪcharacter����
--����ֵתΪ�ַ�����
select 0001,to_char(0001)
       from dual;  
       
--������תΪ�ַ�����       
select to_char(sysdate)
       from dual;  
       
--�ڡ�to_number()   �����ַ�����תΪ��ֵ����
select to_number('20')
       from dual;   

--�ۡ�to_date()     �����ַ�����תΪ��������
select to_date('2012-02-03','yyyy-MM-dd')
       from dual;  
       
--�ܡ�nvl()        ���жϲ���1��ֵ�Ƿ�Ϊnull��''��
--������򷵻ز���2��ֵ�����򷵻ز���1��ֵ
select nvl(null,'abc'),nvl('','abc'),nvl('1','abc')
       from dual;                            
       
--����Ա���ĵ���Ӧ������=���� + ����
select EmpNo,Ename,sal + nvl(comm,0)
       from emp;  
      
--�ݡ�nullif()     ���ж��������ʽ�Ľ���Ƿ����
--�������򷵻�nnull�����򷵻ر��ʽ1�Ľ��
select nullif(3,2),nullif('3',''),nullif('',''),nullif(3,3)
       from dual;     


--5)��case...then���
select EmpNo,Ename,case deptno
                        when 10 then 'ACCOUNTING'
                        when 20 then 'RESEARCH'
                        when 30 then 'SALES'
                        else 'Other'
                   end
       from emp;
--3�����к���
--sum()��avg()ֻ��������ֵ���͵���
--min()��max()�������������ڡ��ַ�����ֵ���͵����Ͻ���ʹ��

--a��count()        ��ͳ��������(ֵΪ�ǿյ�)������
select count(*),count(comm)
       from emp;
       
--b��sum()          ����ָ���������е�ֵ�����ۼ�
select sum(sal),sum(comm)
       from emp;   

--c��avg()          ����ָ�����е����ݽ�����ƽ������       
select avg(sal),avg(comm)
       from emp; 
--����ƽ��ֵʱ����ʹ��avg()����       
select avg(sal), sum(sal) / count(sal)
       from emp;    

--d��min()         ������������Сֵ       
--e��max()         �������������ֵ
select min(comm), max(comm)
       from emp;  
       
select min(job),min(hiredate)
       from emp;               
       
select hiredate
       from emp;
       
select * from class                      
