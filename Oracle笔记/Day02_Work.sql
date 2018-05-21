--1����ѯ����Ա����š� ��������λ
select EmpNo,EName,Job
       from emp;

--2����ѯ���еĸ�λ�б� 
select Job
       from emp
       group by job;
 
select distinct Job
       from emp;      


--3����Ҫ�������µĸ�ʽ���н���䣬�磺NO:7469 Name:SMITH Job:CLERK
select 'No:' || EmpNo || ' ' || 'Name:' || EName || ' ' || 'Job:' || job as Info
       from emp;

--4����ѯÿ��Ա������������н
select EName, Sal * 12 as sal
       from emp;
       
--5����ѯ�������ʲ����� 1500 ��ͬʱ��������ȡ�����Ա����
select *
       from emp
       where sal<=1500 and (comm is null or comm = 0)
       
--��7��Ҫ���ѯ����Ų��� 7369 ��7499��Ա����Ϣ
select *
       from emp
       where Empno != 7369 and Empno <>7499

select *
       from emp
       where EmpNo not in(7369,7499)
       
--8��Ҫ��Թ����ɵ͵��߽�������
select * 
       from emp
       order by sal;
       
--9���鿴�����ź�Ϊ10��Ա����Ϣ����ѯ����Ϣ���չ��ʴӸߵ��ͣ�
--�������������ְ���ڴ��絽������
select *
       from emp
       where deptno=10
       order by sal desc,hiredate asc



--10���ҳ�����10�����о���(MANAGER)�Ͳ���20�����а���Ա(CLERK)����ϸ����      
select *
       from emp
       where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK')


--11���ҳ��Ȳ��Ǿ����ֲ��ǰ���Ա����н����ڻ����2000������Ա��������
select *
       from emp
       where job !='MANAGER' and job !='CLERK' and sal>=2000
       
--12����ʾ������"R"��Ա��������
select *
       from emp
       where EName not like '%R%';
