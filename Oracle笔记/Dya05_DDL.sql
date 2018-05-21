--DDL
--1��Oracle�г��ö����˽⣩
--  ��Tables��           ���洢���ݵĻ�����λ�������к���(�ֶ�)���
--  ��ͼ(Views)            ��һ����������������ڸ�����
--  �洢���̣�Procedures�� : һ�����ܴ����(�������Ϊjava�ķ���)
--  ����(Squeences)        ��˳�����һ���й��ɵ�����
--  ����(indexes)          ��һ������ʽ

--2�������ֵ�                 ���洢���ݿ����Ϣ(��ʵ���Ǳ�)

--user_tables����ͼ��      �����������û������Ϣ
select * 
       from user_tables;
       
--user_objects����ͼ��     �����������û���Լ����Ϣ
select *
       from user_objects;  

--user_catalog(��ͼ)       �����ص�ǰ�û������з���       
select *
       from user_catalog;  
       
--3�������淶
--a������ĸ�����֡�"_"��"$"��"#"���
--b�����Ȳ��ܳ���30���ַ�
--c������ʹ��oracle�Ĺؼ��ֺͱ����� 
--d������ʹ���Ѿ����ڵĶ����������ظ�����

--4����������(����)
--varchar2�����ȣ�           ���ɱ䳤�ȵ��ַ�����(������ռ���л���)���洢��Ҫ�ռ�϶࣬�ҳ��Ȳ��̶�������
--char(����)                 �����Ȳ��ɱ���ַ����� ��һ������ڴ洢����ȷ�������ݡ��磺�ֻ����롢���֤����                    
--number(n,m)                ����ʾ��ֵ���ͣ����Դ洢�����͸�������n��ʾ�ܳ��ȣ�m��ʾС��λ��
--long                       �����ַ����ͣ������Դ洢2G����
--date                       ����������
--clob                       ���洢�ַ��������ݣ������Դ洢4G����
--blob                       ���洢�������������ݣ������Դ洢4G����



--5������(����)
--1���﷨
create table ����
(
       ���� ����[(size)][,]
       ......       
);

--2)����
--a��������ҷ�ʽ
create table score
(
       stuNo number,                   --ѧ��
       stuName varchar2(10)��          --����
       age number,                     --����
       birthDay date,                  --��������
       gender char(2)                  --�Ա�
)

select * from score;
select * from user_tables;

--b���̳з�ʽ
--����һ����emp��ͬ�ṹ���±�,ͬʱ�Ḵ������
create table emp2
as
       select * from emp;
select * from emp2;

--����һ����emp���в�����ͬ�ֶε��±�ͬʱ�Ḵ������
create table emp3
as
       select EmpNo,Job,MGR,Sal from emp;
       
select * from emp3;
       
--����һ����emp������ͬ�ֶε��±�����������
create table emp5
as
       select * from emp where --deptno = 1;
                               1=2;
       
select * from emp5;

--����һ�����ڶ����±�
create table emp6
as
       select empno,ename,sal,dname
              from emp e left join dept d on e.deptno = d.deptno
              where 1=2;
select * from emp6;              

select * from user_tables;
       

--6���޸ı�
--a���޸���
select * from student

--�﷨��alter table ���� modify ���� ����[��size��]
--�޸�student���name�ֶΡ����ȸ�Ϊ50������
alter table student
modify name varchar2(50);

--�޸�student���name�ֶΡ����ȸ�Ϊ2������
--�������κ����ݣ����������޸�
--���������ݣ��е��³��ȱ�������ݵ���󳤶����(С����󳤶Ȼᱨ��)
--���������ݣ��е����ͱ�����ͬ���ͻ���ڵ�ǰ������
alter table student
modify name varchar2(2);

select * from student;
--b���޸ı���
--�﷨��rename ԭ���� to �±���
rename emp6 to emp7;

--7��ɾ����
--�﷨��drop table ����;
drop table emp7;
--ɾ��һ������ڵı������쳣
drop table emp6;
