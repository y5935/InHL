--Լ��
--1������
--�����ڱ��ϣ��Ա���ִ�����ݲ�����һ��ǿ��������

--2������
--1�������÷���
--a�����ǿ�Լ��(not null)       -nn
--b��������Լ��(primary key)    -pk
--c����ΨһԼ��(unique key)     -uq
--d�������Լ��(check)          -ck
--e�������Լ��(foreign key)    -fk
--f����Ĭ��ֵԼ��(default)      -df

--2��������Χ����
--a�����м�Լ��
--b������Լ��

--3������
select * from student;

--��������
--����1����������ͬ��ŵ�ѧ����Ϣ
insert into student(stuno,name,classId) values(102,'Tom','2');
--����2����������ݵ�ȱʧ(���ݲ�������)
insert into student(stuno) values(103);
--����3���������༶��֮�����ݵĲ�������
insert into student(stuno,name,classId) values(102,'Tom','2000');

--1������֤���������Լ���Ч��
--2������֤������ݵ�������

--4�������м�Լ��
--1�����ǿ�Լ��   �����зǿ�Լ�����в��������null
--a��������
drop table student;

--�����м�Լ��
create table student
(
       stuNo number(4) not null,        --�Զ�����һ��Լ����
       stuName varchar2(20) constraint stu_stuName_nn not null, --ָ��Լ����
       age number(3),
       tel varchar2(15)
)

--������Լ��
create table student
(
       stuNo number(4),     
       stuName varchar2(20),
       age number(3),
       tel varchar2(15),
       --��Լ��
       --�ǿ�(not null)Լ����֧�ֱ�Լ��
       constraint not null
)


--b����д�������
--������������
insert into student values(1,'Mike',20,'2342322');
--ȱ��ѧ��
--����Լ�������ʧ��
insert into student(stuName,age,tel) values('Jack',20,'2342322');
--ȱ������
--����Լ�������ʧ��
insert into student(stuNo,age,tel) values(3,22,'2342322');

select * from student;


--2����ΨһԼ��     ��ȷ�����е�ֵֻ�ܳ���һ�Ρ�������ֶ��nullֵ
drop table student;
--�������ݱ�
--a�������м�Լ��
create table student
(
       stuNo number(4) unique,     --�Զ�����Լ����     
       stuName varchar2(20) constraint stu_name_uq unique,      --ָ��Լ����
       age number(3),
       tel varchar2(15)       
)
--b��������Լ��
create table student
(
       stuNo number(4),   
       stuName varchar2(20),
       age number(3),
       tel varchar2(15),  
       constraint stu_no_uq unique (stuNo)    
)
--������������
insert into student values(1,'Mike',20,'2342322');
--nameֵΪnull
insert into student values(2,null,20,'2342322');
--nameֵΪnull������ɹ�
insert into student values(3,null,20,'2342322');

--��ѯ����
select * from student;

--3��������Լ��     �������в���������ظ�ֵ��nullֵ
--����Լ�����Կ�����ΨһԼ����һ������������ΨһԼ�����ϸ�
--����������һ����������ÿ�����ݵ�һ��Ψһ��ʶ
drop table student;
--�������ݱ�
--a�������м�Լ��
create table student
(
       --stuNo number(4) primary key,    --δָ��Լ����
       stuNo number(4) constraint stu_no_pk primary key, --ָ��Լ����
       stuName varchar2(20) ,  
       age number(3),
       tel varchar2(15)       
);

--b��������Լ��
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3),
       tel varchar2(15),
       constraint stu_no_pk primary key(stuNo)              
);

--c����������      �����������ɶ������ɵ�
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3),
       tel varchar2(15),
       constraint stu_no_pk primary key(stuNo,stuName)              
);

--������������
insert into student values(1,'Mike',20,'2342322');
--����ʧ��(�����ֶε�ֵ�����ظ�---stuNo)
insert into student values(1,'Jack',22,'4342322');
--����ʧ��(�����ֶε�ֵ������ʹ��nullֵ)
insert into student values(null,'Jack',22,'4342322');

--��ѯ����
select * from student;


--4�������Լ����MySql��Ч����ͨ��������������ݵ����ݷ�Χ�Ƿ�Ϸ�
drop table student;
--�������ݱ�
--a�������м�Լ��
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3) check(age >=0 and age<=200),
       gender varchar(4) constraint stu_gender_ck check(gender='��' or gender = 'Ů'),
       tel varchar2(15)       
);

--��������
--����ʧ�ܣ�Υ�����Ա�Լ��
insert into student values(1,'Mike',999,'��','234234');
insert into student values(1,'Mike',199,'��','234234');

select * from student;

--5)�����Լ��
--�������ṩ���ݵı��Ϊ������(grade)
--�����ʹ�������������ݵı�ͳ�Ϊ�����(Student)
--�������ϵ��Ҫ��������Ͻ��д���
--�١���������ʱ��������е��ֶ�ֵ��Student.gradeNo����������grade���в�����ʱ������ʧ��
--�ڡ����������������е������������������ù�ϵʱ���������ù�ϵ�������޷�ɾ��
drop table student;
--�������ݱ�
create table grade
(
       gradeNo number(4) primary key,
       gradeName varchar2(20)
);
--a�������м�Լ��
create table student
(
       stuNo number(4) ,
       stuName varchar2(20) ,  
       age number(3),
       gradeNo number(4),
       constraint stu_gradeNo_fk foreign key(gradeNo) references grade(gradeNo)
);

--��������
insert into grade values(1,'һ��һ��');
insert into student values(1,'Mike',20,1);

--���ݲ���ʧ�ܣ���Ϊ�����ڱ��Ϊ2�İ༶��Ϣ
insert into student values(2,'Jack',20,2);
--ɾ��ʧ�ܣ���Ϊ�������(Student)�д������ù�ϵ
delete  from grade where gradeNo = 1;
--ɾ���ɹ�����Ϊ���������ù�ϵ
delete  from grade where gradeNo = 2;

insert into grade values(2,'һ�����');

--��ѯ����
select * from student s, grade g 
         where s.gradeno = g.gradeno(+);
select * from grade; 

--6����Ĭ��ֵ  
create table grade
(
       gradeNo number(4) ,
       gradeName varchar2(20),
       note varchar2(200) default '����һ������ʲô��û����'
);   

--��ѯ����
select * from grade;   

--��������
--��Ҫʹ��Ĭ��ֵʱ����ֱ��ʹ��default�ؼ���
insert into grade values(1,'һ��һ��',default);

--��δ��Ĭ��ֵ�ֶ��ṩʱ���н��Զ�ʹ��Ĭ��ֵ
insert into grade(gradeNo,gradeName) values(1,'һ��һ��');
--�޷�ʹ��Ĭ��ֵ����Ϊ�ֶε�ֵ��''
insert into grade values(1,'һ��һ��','');

--4���޸�Լ��
--���һ��û���κ�Լ���ı�
create table student
(
       stuNo number(4),     
       stuName varchar2(20),
       age number(3),
       tel varchar2(15)
 );
--1�������Լ��
--����Լ��
alter table student
      add constraint stu_no_pk primary key(stuNo);
--���Լ��      
alter table student
      add constraint stu_age_ck check(age>=0 and age<=200);
      
--��������
insert into student
       values(1,'Mike',201,'234234');  
       
select * from student;  

delete from student;     
           
--2��������Լ��
alter table student 
      disable constraint stu_age_ck;

--3��������Լ��
alter table student
      enable constraint stu_age_ck;

--5��ɾ��Լ��
alter table student
      drop constraint stu_age_ck;





--�������ű�������
--���ű�ţ���ֵ���ͣ�����������(�ַ����ͣ��ǿգ�
create table department
(
       deptNo number constraint dept_no_pk primary key,
       deptName varchar(20) constraint dept_name_nn not null
);

create table users
(
       userId number,
       userName varchar2(20) not null,
       accountName varchar2(20) not null,
       pwd varchar2(20) not null,
       deptNo number,
       
       --���Լ��
       constraint user_pk_id primary key(userId),
       constraint user_account_uq unique(accountName),
       constraint user_pwd_ck check(length(pwd)>=6 and length(pwd)<=20),
       constraint user_deptNo_fk foreign key(deptNo) references department(deptNo)
);

--����Ա����������
--Ա����ţ���ֵ���ͣ����������������ַ����ͣ��ǿգ���
--�˺ţ��ַ����ͣ��ǿա�Ψһ��
--���루�ַ����ͣ��ǿգ�����Ϊ6~20���������ţ���ֵ�������


