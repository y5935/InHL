--DML
select * from user_tables
select * from score

--1����(��������)
--�﷨��insert into ����(�ֶ����б�) values(ֵ�б�)
--��score���������

--1)��Ϊ�����в�������
--a��������������Ϊ�����ֶ�(��)����������
insert into score(stuno,stuname,age,birthday,gender)
       values(1,'Mike',20,'3-1��-2018','T')
--b)��ʡ��������Ϊ�����ֶ�(��)����������
--ʡ���ֶ��б��������ʱ������Ϊ�����ֶ���ʾ�ṩֵ(����Ĭ��ֵ��)  
--���ֻ�ṩ�����е�����ֵ�����뽫ʧ��     
insert into score
       values(2,'Jack',22,'3-2��-2018','T') 
       
--ִ��ʧ��       
insert into score
       values(3,'Rose',18)             
--2����Ϊ�������ṩ����
--Ϊ�����в�������ʱ��������ʾ�ṩ�ֶ����б�
insert into score(stuno,stuname,age)
       values(3,'Rose',18)

--��ʽ�ṩ�ֶ��б�ʱ���ֶε��Ⱥ�˳����Բ��ͱ�ṹһ��
insert into score(stuname,stuno,age)
       values('Rose',3,18)
       
--3������������       
insert into score(stuno,stuname)
       select stuNo,name from student
       
--�������Ĳ������ 
insert into score(stuno,stuname)
       select stuNo,name from student
       where stuNo != 1  
       
--ע�⣺           
--�١��ֶ�����ֵ��λ�ñ���һһ��Ӧ
--�ڡ��������ݵĳ��ȱ���С�ڻ�����ֶεĳ���
--�ۡ���������ʱ����������ֶε�Լ��


--2����
--�﷨��update ���� set �ֶ��� = ֵ [��......]
--             [where �������ʽ]

--1)��ʡ����where��䣺�����µ�ǰ��������������
update score set age = 20;

--2��������where��䣺�����·�������������������
update score set age = 20
       where stuname='Mike'
       
--3)���������Ķ��ֶθ������       
update score set age = 22,birthday='3-1��-2018',gender='t'
       where stuno=102

--ע������
--     �١����ʡ����where�������������е�������

select * from score;

--3��ɾ
--�﷨��delete [from] ����  [where �������ʽ]
--1������������ɾ����䣺ֻɾ����������������
--a������from�Ӿ�
delete from  score where stuno=103;            
--b��ʡ����from��ĸ
delete  score where stuno=103;

--c������������ɾ����䣺ɾ�����е�������
delete score;

select * from score;

--ע������
--     �١�ʡ����where������ɾ����佫ɾ�����е�������
--     �ڡ�ɾ������ʱ����Υ�������Լ��

--4����ձ�����
--1����delete���
--���������ݿ��Ա��ع�
delete student;

--2����truncate���
--�����������޷����ع�
truncate table student;


select * from student;

--DCL
--rollback    ���ع������������ж����ݵĲ����ָ�����һ���ύ��״̬
--commit      ��������û�н����ύ������������ύ���ύ������ݽ����ڳ־û�״̬
--rollback��commitֻ��dml�����Ч����ddl�����Ч(Ҳ�������Ϊddl����������ύ��)
--ִ�в������
insert into score(stuno,stuname,age,birthday,gender)
       values(1,'Mike',20,'3-1��-2018','T');
       
insert into score(stuno,stuname,age,birthday,gender)
       values(2,'Rose',18,'3-2��-2018','F');       

--���������е������ύ�����ݿ���
commit;       
--�����ݻָ�������ǰ��״̬(�������ع���)       
rollback;       
 
      
select *
       from score;       

