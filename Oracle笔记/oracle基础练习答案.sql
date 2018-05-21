select *
       from emp;
       where trunc(t.�ֶ���)>=to_date('1980-01-01','yyyy-mm-dd')
       and trunc(t.�ֶ���)<to_date('1986-01-01','yyyy-mm-dd'
select getdate()

--1. ��ѯ����Ա���ı�š���������λ
select empno,ename,job 
       from emp;
       
--2. ��ѯ���еĸ�λ�б�
select distinct job
       from emp; 
       
select job
       from emp
       group by job;
       
--3. ��Ҫ�������µĸ�ʽ���н�����䣬��ʽ���£�NO:7469 
Name:SMITH Job:CLERK

select 'NO:'||empno||'Name:'||ename||'job:'||job as info
       from emp;

--4. ��ѯÿ��Ա������������н
select ename,sal*12 as yearsal
       from emp;
       
--5. ��ѯ�������ʲ����� 1500��ͬʱ��������ȡ�����Ա����Ϣ
select *
       from emp
       where sal<=1500 and comm='0' or comm is null;
       
--6. ��ѯ�� 1981 ����ְ��ȫ��Ա����Ϣ
select *
       from emp
       
       where year(hiredate)=year(getdate(1981))
 

--7. Ҫ���ѯ��Ա����Ų��� 7369��7499 ��Ա����Ϣ

select *
       from emp
       where empno!=7369 and empno!=7499;
  
select *
       from emp
       where empno not in (7369,7499);
       
--8. Ҫ���Ա���Ĺ����ɵ͵��߽�������
select *
       from emp
       order by sal ;
       
--9. �鿴�����ź�Ϊ 10 ��Ա����Ϣ����ѯ����Ϣ���չ��ʴӸߵ��ͣ�
�������������ְ���ڴ��絽������
select *
       from emp
       where deptno=10
       order by sal desc ,hiredate asc
--10. �ҳ����� 10 �����о���(MANAGER)�Ͳ��� 20 �����а���Ա
(CLERK)����ϸ����
select *    
       from emp 
       where ��deptno=10 and job='MANAGER'�� or ��deptno=20 and job='CLERK'��;
       
--11. �ҳ��Ȳ��Ǿ����ֲ��ǰ���Ա����н����ڻ���� 2000 ������
Ա��������
select *
       from emp
       where job!='MANAGER'and job!='CLERK' and sal>=2000;
       
--12. ��ʾ������"R"��Ա����
select *
       from emp
       where ename  not like '%R%'
       
        
