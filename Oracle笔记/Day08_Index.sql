--1��rowid��rownumα��
--1)��rowid
--rowid���ڼ�¼����ʱ�Զ������ļ�¼��š�Ĭ�������rowid�ǲ���ʾ��
--rowid��¼����������������ϵ�λ��,rowid�Ǽ�¼�������ַ
--ͨ��rowid���Կ��ٶ�λ����¼
--���Ǽ�¼λ�÷����ı䣬����rowid��ֵ�ǹ̶������

--��ʽ��OOOOOO  FFF   BBBBBB   RRR


--��ѯemp������
select *
       from emp;
       
--����һ������
insert into emp 
       values(9000,'Terry','CLERK',7566,'2-2��-2008',900,0,10)
       
--����rowid�Ĳ�ѯ
select e.*,rowid 
       from emp e;  
       
--2����rownum
--rownum��ִ�в�ѯʱ��������һ��˳��š�ÿ�β�ѯʱ˳��Ŷ��Ǵ�1��ʼ
--rownum��Ϊwhere����ʱ��ֻ����<��<=����(��Ϊÿ�β�ѯʱ���ݵ�rownunm�����²���)

--��ѯ��������
select e.*,rownum 
       from emp e;
       
--��ѯ������������������ (��������)
--rownum���´�1��ʼ
select e.*,rownum 
       from emp e
       where sal >2200;

--��ѯ������
--rownum���¼��˳���Ӧ������ʵλ�÷����ı�
--rownum��ִ��select���ʱ������order byִ��ʱrownum�Ѿ�����           
select rownum ,e.*
       from emp e
       where sal >2200
       order by sal desc; 
       
--top-n
--a������ѯн����ߵ�����Ա������Ϣ
--����ʹ��<=��>=���޷��ﵽ��Ҫ��Ч��
select rownum ,e.*
       from emp e 
       where rownum >=3
       order by sal desc; 
--��ȷ������
--��һ���������ݽ�������       
select e.*
       from emp e 
       order by sal desc; 
       
--�ڶ�������������������Ϊһ���±�Ȼ����±��н��в�ѯ
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t;      
                    
--�����������������ݽ���ɸѡ
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t  
       where rownum<=3; 
       
       
--b������ѯн�������ǵ�4~6��Ա����Ϣ(��ҳ��ʾ)
--�����޷���ѯ���κ�����      
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t  
       where rownum>3 and rownum <=6; 
       
--��ȷ
--��һ������ѯ�õ�6������
select rownum as id, t.*
       from (select e.*
                    from emp e 
                    order by sal desc) t  
       where  rownum <=6; 
       
--�ڶ���������ѯ�����Ϊһ�����������ʹ��
select *
       from (select rownum as id, t.*
                 from (select e.*
                              from emp e 
                              order by sal desc) t  
                 where  rownum <=6)
       where id >3; 
       

--2������
--a������ �����������ֵ��Ŀ¼�����������ݱ��Ƕ����洢�ġ�
--b������ ����Ч������ݵĲ�ѯЧ��(û�в�������ʱ��ѯʹ�õ���ȫ��ɨ��)
--c��ʵ�� ������������B+����ʽ����ʵ�ֵġ�
--d������ ��
--   �١�Ĭ������������������ΨһԼ��ʱ���Զ��������� 
--   �ڡ��ֶ���ʽ��һ��������λͼ����

/*
--   �ۼ������������ݵ�����˳��������ţ�ֻ�ܴ���һ��
--   �Ǿۼ������������ж�� 
*/

--e����������
--   �١����ݷֲ���Χ�Ϲ�
--   �ڡ����ݽ϶�
--   �ۡ�������Ϊwhere�����������ʹ��
--   �ܡ����ݸ��Ƿ�Χռ����������2%-4%
--f������Ҫ����������
--   �١����ݱ�ǳ�С
--   �ڡ����ݽ�Ϊ����
--   �ۡ�һ�㲻��where�����г��ֵ��ֶ�
--   �ܡ���������ɾ�ĵ����ݲ����齨����

--g����������
--�١��﷨��
/*
     create [bitmap|unique] index ������
            on ����(���� [asc|desc])
*/

--�ڡ�Ϊename�д�������
create index emp_idx_ename
       on emp(ename asc);
       
--ʹ������
--�ص㣺��������Ҫ��ʽʹ�ã����õ�������ʱ�����������Զ�ʹ�ã�**��
select * 
       from emp
       where ename like 'A%';
       
--�ۡ�Ϊ�����д�������
--�����ݷֲ��ķ�Χ�ǳ�С������ʹ��bitmap����
create bitmap index emp_idx_deptno
       on emp(deptno);
       
--�ܡ�Ϊ���ź͹��ʴ�������
--����������ʹ��ʱ��ֻ��ͬʱʹ�ø��������������ֶ�ʱ�����Ż���Ч
create index emp_idx_sal_dept
       on emp(deptno asc,sal desc);       

--h��ɾ������
drop index emp_idx_sal_dept;

--i��������ȱ��
--�����ݱ����insert��delete��update����ʱ����Ҫͬʱά�������ļ�
--�������������󣬻ή��insert��delete��update��ִ��Ч��
--j��ʹ�ý���
--   �١��Ǳ�Ҫ����£���Ҫ���ⴴ������
--   �ڡ����ڶ����������ؽ� 

--k���ؽ�����
alter index ������;    



--3���洢����
--1��������
--    �洢������һ��Ԥ����ָ��ļ��ϡ�
--2�����ŵ�
--    a����ʡ��������
--    b����߰�ȫ��
--    c�����ִ��Ч��
--3�����﷨
/*
      create procedure �洢������(�����б�)
      as
      begin
           ����;
      end
      
*/  

--4)��ʾ��
--�١��򵥴洢����---�޲����洢����
--���û���κβ���()����ʡ��
--����ֻ��һ�������begin��end����ʡ�ԣ����ǲ�����
create procedure pro_emp_add as
begin
       insert into dept values(50,'Design','����');
       commit;
end pro_emp_add;
       
--ʹ�ô洢����
pro_emp_all;

select * from dept;

--�ڡ��������洢����
create or replace procedure pro_emp_del(no number) as
begin
       delete dept where deptno=no;
       commit;
end pro_emp_del;

--���ô洢����
begin
    pro_emp_del(50);
end;   


--�ۡ�����
--��������in--���������out--�������;int out--�����������
--����һ�����ű�ź󣬷��ز�������
create or replace procedure pro_dept_getname(no in number,n out varchar2(14))
as
begin
       select dname into n
              from dept where deptno =no;  
end pro_dept_getname;    


    
                                                                   
