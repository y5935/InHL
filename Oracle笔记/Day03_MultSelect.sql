--������ϲ�ѯ
--��ѯ������ʹ�ö����ͬʱ�����ѯ�����ս�����γ�һ����ѯ�����
--Ŀ�ģ�ʹ���ݸ�������

--��ѯ�༶��Ϣ
select * 
       from class;

--��ѯѧ����Ϣ
select *
       from student;   

101    Mike   1     1   ��Ӣ101
102    Jack   2     -   -

--1���ѿ����˻�
--����һ�㲻��Ҫ�����Ĳ�ѯ���
select *
       from student,class
       
--2����ֵ������ѯ
--ֻ�е��������ʽ��ֵ������ֵͬʱ���ݲŻᱻ��ʾ
select *
       from student,class
       where student.classId = class.classId; 
       
--3����ʾ������
--�����ֳ���ͬ���ֶ�ʱ��Ϊ�������ֶε�������
--��Ҫʹ�ñ�(��)����Ϊǰ׺���б�ʶ����ʽΪ����(��)��.�ֶ���
select stuNo,Student.name,student.classId,class.name
       from student,class
       where student.classId = class.classId; 
       
--4�������
--�������ʽ����ʹ�ò�ѯ�����������
select stuNo,s.name,s.classId,c.name
       from student s,class c
       where s.classId = c.classId; 
      
--��ѯ���е�Ա����ʾ��ͬʱ��ʾԱ�����������źͲ������ڵ�
--5����ֵ��ѯ VS �ǵ�ֵ��ѯ
--��ѯԱ���Ĺ��š��������������š��������ڵؼ����ʵȼ�
select empno,ename,dname,loc,grade
       from emp e,dept d,salgrade s
       where e.deptno=d.deptno and (e.sal>=s.losal and e.sal<=s.hisal)
       
--��ѯԱ���Ĺ��š�������ֱ��������ְ����
--6���������� VS ������
select a.empno,a.ename,b.ename,a.hiredate
       from emp a,emp b
       where a.mgr = b.empno

--7���������
--1����������     ��ֻ�е��������ʽ����ʱ���ݲŻ�����ڽ������
--2����������     
--     a����������
--     b����������
--     c��ȫ������

--a����������
--����   ��δ��(+�����б�ǵ���������Ӧ�ı��Ϊ����
--�ӱ�   ����(+�����б�ǵ���������Ӧ�ı��Ϊ�ӱ�
--�������ӣ��������ʽ�У���=�����ı���Ϊ����
--�������Ӳ�ѯʱ������ʾ���������е����ݣ��ӱ���ƥ�������Ҳ�������ʾ
--��������������ڴӱ���û��ƥ��������ֱ��ʹ��null������ʾ
select *
       from student s,class c
       where s.classId=c.classid(+); 
       
--b����������
--�������� �����������ʽ�С�=���Ҳ�ı�Ϊ����
select *
       from student s,class c
       where s.classId(+)=c.classid; 
       
--c��ȫ������
--��֧�ָ��﷨                        
select *
       from student s,class c
       where s.classId(+)=c.classid(+); 
       
--�﷨ȱ�㣺���������Ͳ�ѯ������д��where�����
--�������������ң����벻������

--8��Sql 99
--1)����������(�ѿ����˻�)
select *
       from student cross join class
       
--2�����������
--a��������     ����inner�� join ... on
select *
       from student a  join class b
       on a.classid = b.classid;

--b����������  ��left ��outer�� join ... on
--��join������ı�Ϊ�����Ҳ��Ϊ�ӱ���ѯʱ����ʾ��������������
--�ӱ���ƥ�����ݻ������ʾ�����ܱ�ƥ������ڽ��������null�������
select *
       from student a left join class b
       on a.classId= b.classId;       
              

--c����������  ��right ��outer�� join ... on
--��join����Ҳ�ı�Ϊ��������Ϊ�ӱ���ѯʱ����ʾ��������������
--�ӱ���ƥ�����ݻ������ʾ�����ܱ�ƥ������ڽ��������null�������
select *
       from student a right join class b
       on a.classId= b.classId; 
       
--d��ȫ������(������)  ��full ��outer�� join 
--ȫ�����൱����������Ϊ������ѯ������������Ӻ��������ӵĺϼ�

--��˼�������������Ӻ�ȫ������ʲô����
--�������ӵĽ�����ǵѿ����˻���ȫ���ӵĽ������������ + ������
select *
       from student a full join class b
       on a.classId= b.classId; 
       
--3������Ȼ����
--�Զ�����������֮��Ĺ�����ϵ(�����ֶ�)�Զ�������������
--��ѯ���������������       
select *
       from emp natural join dept; 
       
--4����using����
--�Զ�����using()���ֶ�����������
--Ҫ�������б���ͬʱ������ͬ����ͬ���͵���
--��ѯ���������������
select *
       from emp join dept using(deptno);                 
           
select *
       from student join class using(classId); 
       
--��������Ȼ����using���ӵ�����
--��������Ҫͨ��on�ؼ���ָ������������������Բ��������ù�ϵ
--��Ȼ������Ҫ�������ù�ϵ
--using������Ҫ������ͬ���ֶ�����ͬʱ����ҲҪ��ͬ       
