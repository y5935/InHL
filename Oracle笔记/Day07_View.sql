--��ѯԱ����Ϣ����ʾԱ���ı�š��������������š����ʵȼ���
--Ӧ������(sal + comm)
--��һ������ѯԱ������
select empno,ename,deptno,sal + nvl(comm,0) as total 
       from emp;
       
--�ڶ�������ѯԱ�����ڲ���
select empno,ename,dname,sal + nvl(comm,0) as total 
       from emp e left join dept d on e.deptno = d.deptno;      
       
--����������ѯ���ʵȼ�
 select empno,ename,dname,grade, sal + nvl(comm,0) as total 
       from emp e left join dept d on e.deptno = d.deptno      
                  left join salgrade s on e.sal between s.losal and s.hisal; 
                  
--����һ������ʱ��϶�                  
--�����������Ϊ����
--��������������˽����

--��ͼ(View)
--1��ʲô����ͼ
--��ͼ��һ������ı���ͼ�ı�����һ�β�ѯ��䡣��ͼ�е��������������ݱ�(����)

--2����ͼ������
--a���������򵥻�
--b����߰�ȫ��

--3����ͼ���﷨
/*
     create view ��ͼ��
     as
            ���;
*/

--4��������ͼ
--1)������ͼ
create view vw_emp
as
       select * from emp;
       
--ʹ����ͼ
select * from vw_emp;

--2������ͼ�е�������where����
create view vw_emp2
as
       select * from emp where job = 'CLERK';

--ʹ����ͼ
select * from vw_emp2;

--3������������ѯ����ͼ
create view vw_emp3
as
      select empno,ename,dname,grade, sal + nvl(comm,0) as total 
             from emp e left join dept d on e.deptno = d.deptno      
                  left join salgrade s on e.sal between s.losal and s.hisal;  

--ʹ����ͼ
select * from vw_emp3;

--4����������ͼ����ͼ
--���ʹ����һ����ͼ���в�ѯ
create view vw_emp4
as
       select * from vw_emp3 where grade=3;

--ʹ����ͼ
select * from vw_emp4;

--������ͼ������
--��ͼ֧��DML����(insert��delete��update)
--����ͼִ��DML����ʱ�������ͼ���漰�����ĸ�����ͼ��
--��Ϊ�漰�����������ԣ�����������ʧ��
--a������ͼ�в�ѯ����
select * from  vw_emp

--b������ͼ�в�������----���ݲ���ɹ���������Ӱ��
insert into vw_emp 
       values(9000,'LaoDa','CLERK','7369','4-1��-2018',4000,50,20)

--c��ɾ����ͼ�е�����----����ɾ���ɹ���������Ӱ��
delete vw_emp where empno=9000; 

--d���޸ĸ�����ͼ�е����� 
--�޸�vw_emp4�б��Ϊ7499�����ݡ���Ename��ֵ��Allen ��Ϊ Terry
update vw_emp4 set Ename='TERRY' where EMPNo=7499;  

--e��ɾ��������ͼ�е�����
--ɾ�����Ϊ7499������
delete vw_emp4 where empno=7499;
   
select * from emp;

--5���޸���ͼ
create or replace view vw_emp
as
       select * from emp where job='CLERK';
       
--ʹ����ͼ
select * from vw_emp;       

--6��ɾ����ͼ
drop view vw_emp;

--7��ע������
--1������ͼ����Ƕ����ͼʹ�ã�����Ҫ��������
--2������ͼ�в���ʹ�ó���ѯ�����������


--8��Ȩ�޷���
--grant Ȩ�� to �û�;
--ֻ���ɸ���Ȩ�޵��û����з��䣬�û��޷�Ϊ�Լ�����Ȩ��
grant create any view to scott;

--9��ֻ����ͼ
--ֻ����ͼֻ�ܲ�ѯ���ݣ��޷��޸�����
create or replace view vw_emp
as
       select * from emp where job='CLERK'
       with read only;

--����---sequence
--1�����ã��ṩһ���������ֵ���С�
--2���﷨
/*
       
  create sequence ������
         increment by ��ֵ       --���������ٶ�
         start with ��ֵ         --������ʼֵ
         [ maxvalue ��ֵ | NOMAXVALUE ]      --���ֵ
         [minvalue ��ֵ | NOMINVALUE ]       --��Сֵ
         [cycle | nocle ]                    --�Ƿ����
         
*/

--increment        ������


--3����������
create sequence user_id
       start with 1001
       increment by 1;
       
--4��ʹ������1
--currval        ����ȡ��ǰ������ֵ
--ע�⣺ֻ�е��ù�nextval�����ʹ��currval
select user_id.currval
       from dual;   
--nextval        ����ȡ��һ�����е�ֵ       
select user_id.nextval
       from dual;    
       
--5��ʹ������2
create sequence user_id2
       increment by 1
       start with 1
       maxvalue 5                            
       minvalue 1;              

--ʹ������
--���ﵽmaxvalueֵʱ�������쳣
select user_id2.nextval
       from dual;    
       
--6��ʹ������3
create sequence user_id3
       increment by 1
       start with 1
       maxvalue 5                            
       minvalue 1
       cache 4
       cycle;          
        
--����cycle�󵱴ﵽ���ֵʱ�������¿�ʼ
--cycle�����cache���ã���cache��ֵ����С��maxvalue
select user_id3.nextval
       from dual; 
       
--7�����е�ʹ�� 
--�ڲ�������ʱΪ�������ṩһ��������ֵ
select * 
       from department; 
       
insert into department values(user_id.nextval,'�����ҵ��');            
insert into department values(user_id.nextval,'�г���');
insert into department values(user_id.nextval,'���ز�');
       
--8���ѷ� ����ν�ѷ������ʹ�ù����в����˲�����������
--����ԭ��
--a��������ݱ�����һ������
--b�����ݲ���ʧ�ܣ����ݱ��ع�(�����޷��ع�)
--c��ִ�й����в������쳣

insert into department values(user_id.nextval,'�ܼ��');
rollback;

--9������
--����ʹ�ù����о���Ϊÿһ������һ������������              
