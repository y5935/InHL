--ģ����ѯ
--��ѯн�ʷ�Χ��1100~1500֮�������Ա����Ϣ
--1��ָ��ȡֵ��Χ��ģ����ѯ
--a����ϵ���������ɸѡ
select *
       from emp
       where sal >=1100 and sal<=1500;
       
--b��ʹ��between...and������ɸѡ(�����߽�ı��ʽ)
select *
       from emp
       where sal between 1100 and 1500;
       
--2���������ݽ���ƥ��
--%          ��ͨ�������ʾ���ⳤ�ȵ���������
--(not)like  : ����ָ����ʽ���в�ѯ
select *
       from emp
       where ename like 'S%';   
 
select *
       from emp
       where ename not like 'S%';       
--��ѯ���������а�����ĸT��Ա������           
select *
       from emp
       where ename like '%T%';
       
--��ѯ���������е����ڶ�����ĸ��T��Ա������
--_          ��ͨ�������ʾһ�����ȵ������ַ�
select *
       from emp
       where ename like '%T_';
       
--��ѯ���ű��Ϊ10��30������Ա����Ϣ
select *
       from emp
       where deptno=10 or deptno=30;   
--��not��in   : ��������ж�ָ���ֶε�ֵ�Ƿ��ڼ��Ϸ�Χ��       
select *
       from emp
       where deptno in (10,30);

select *
       from emp
       where deptno not in (10,30) ;
--��ѯ����û�н����Ա����Ϣ
--is (not) null  : �ж��ֶε�ֵ�Ƿ�Ϊnull
--null�����ض���ֵ����ֻ��һ����ǡ������޷��á�=�����бȽ�       
select *
       from emp
       where comm is null;
  
--��ѯ���н���Ϊnull��Ա����Ϣ
select *
       from emp
       where comm is not null;
       
--���ڲ�ѯ
--��ѯ1980-12-17����ְ��Ա����Ϣ
--��������������Ҫ��''������
select * 
       from emp
       where hiredate ='1-1-80'
                          
