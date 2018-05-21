--1���ص�
--1)��Sql��䲻���ִ�Сд
--2)��Sql���֧�ֵ��кͶ��з�ʽ
--3)���Ӿ��ռһ��
--4)��֧������

--2��dual
--��ʱ����Ҫ���ڲ����﷨(oracle��select����from�Ӿ䲻����ȱʡ)
--a�����ȫ��Сд
select 2 
       from dual;
--b�����ȫ����д
SELECT 3 
       FROM DUAL;

--3���﷨��select ��ѯ���� from ��Դ
select 'a' 
       from dual;  
       
--4�������
--�����������+��-��*��/
select mod(2,3)
       from  dual;
       
--��ϵ�����:>��>=��<��<=��<>����=����=
--select 2>3
--       from dual;
       
--���������:||
select 2 || 'a' || 'c'
       from dual;
       
--5�����Ա�ṹ
--������dept(���ű�)
--DeptNo    ����¼���
--DName     : ��������
--Loc       ���������ڵ�

select * from dept;

--������Emp(��Ա��Ա����)
--EmpNo    : Ա�����
--EName    : Ա������
--Job      ��ְλ
--MGR      ��ֱ���쵼
--HireDate ����ְʱ��
--Sal      : н��
--Comm     : ����
--DeptNo   : �������ű��

select * from Emp;

--������SalGrade��н�ʵȼ���
--Grade    : �ȼ�
--Losal    : ���н��
--Hisal    : ���н��

select * from salgrade;

--������Bonus(����)
--Ename    : ְԱ����
--Job      : ְλ����λ
--Sal      ��н��
--Comm     ������

--6��select���
--��ѯ����Ա������Ϣ
--*  ��ͨ�������ʾ�����ֶ�(ʵ��ʹ��ʱ��������ʹ��)
--��������������
select *
       from emp;
       
--�ֶ��б�ʽ
--���Է��ز��������У���߲�ѯЧ��
select EmpNo,EName,Job,MGR,Hiredate,sal,comm,deptNo
       from emp;  
       
--��Ա�����в�ѯԱ����������Щ����
select deptno 
       from emp; 
  
--7���ų����     
--��Ա�����в�ѯԱ����������Щ���ţ�����ʾ�ظ��Ĳ��ű�ţ�
--distinct�Ӿ� �������ظ���¼
select distinct deptno 
       from emp;             
--û��ʹ���ų����
select deptno��job 
       from emp; 
--ʹ���ų���䣺�ο�deptNo��job�����ֶν����ų�
select distinct deptno��job 
       from emp;  
       
--8���������
--��ѯ����Clerk(ְԱ)����Ϣ
select * 
       from  emp
       where job = 'CLERK';
       
--��ѯ���ʸ���1100Ԫ������Ա����Ϣ
select *
       from emp
       where sal >=1100;
--��ѯ���ű����10����30������Ա����Ϣ       
select * 
       from emp
       where deptno=10 or deptno=30;       
       
--��ѯ���ű��Ϊ10�Ĳ��ž������Ϣ
--��ʾ��������ְλ��н��(н��+����)  
--a���κ����ݺ�null������������ʱ��������Ϊnull
--b������Ϊ��ѯ�ֶ��б��еĸ��ֶ�(����ʽ�����ñ���
--c����ѯ����п���ʹ�ú����ͱ��ʽ
--d��where�Ӿ��е��������ʽ�����ɶ��������ɣ���ͨ���߼��������������
--e��not��and��or
select EName,job, sal + comm sal
       from emp
       where deptno=10 and job = 'MANAGER';   
       
--9���������
--ͳ�Ƹ�����Ա������
--count()              : ͳ�Ʋ�ѯ�����������
--group by�Ӿ�         : ��ָ���ֶζ����ݽ��з���
select deptNo,count(*)
       from emp
       group by deptno;

--a��ʹ�÷����ѯʱ����ѯ�ֶ��б���ֻ�ܳ��ַ����ֶμ��ۺϺ������ʽ  
--b����������Խ��(�ֶ�Խ��)��ѯ���Խ��     
select deptNo,job
       from emp
       group by deptno,job;
         
--��ѯ������������6�˵Ĳ��ű�ż����� 
--10��having     : �Է��������ݽ���������ѯ
--where�Ӿ��ǶԷ���ǰ�����ݽ���ɸѡ��having�Ӿ��ǶԷ��������ݽ���ɸѡ        
select deptno,count(deptno)
       from emp
       group by deptno       
       having count(deptno)>=6;
       
--��н�ʴӸߵ��͵�˳���������
--11��order by   : ����ָ������ʽ���ֶε�ֵ��������
select *
       from emp
       order by sal;       
--order by�Ӿ�Ĳ���
--asc(Ĭ��)    ����������ʽ��������
select * 
       from emp
       order by sal asc;
--desc         : ���ս���ʽ��������
select * 
       from emp
       order by sal desc;

--sum()         : ��ָ���е����ݽ��л���
select deptNo, sum(sal) as total
       from emp
       where sal >1100
       group by deptno
       having sum(sal)>8700
       order by total
       
       
