--��ѯ��SALES��������Ա������Ϣ
--��ʽһ�����Ӳ�ѯ
--ȱ�㣺ͨ�������γ�һ���µı���������������
--�ŵ㣺һ�������ɲ�ѯ
select e.*
       from emp e left join dept d
       on e.deptno = d.deptno
       where lower(d.dname)='sales'
       
--��ʽ�����������в�ѯ
--�ŵ㣺��ѯ�����в���ֱ�ӶԴ������ݽ��в���
--ȱ�㣺��Ҫִ�ж������
--��ѯ���ű��
select deptno 
       from dept
       where dname='SALES';     
--��ѯԱ�����в��ű��Ϊ30�����м�¼
select *
       from emp
       where deptno=30; 
       
--1���Ӳ�ѯ
--��һ����ѯ�����Ϊ��һ����ѯ�����������ֽ���ʹ��
--���ǾͰ������Ĳ�ѯ����Ϊ�Ӳ�ѯ
select *
       from emp
       where deptno=(select deptno 
                            from dept where dname='SALES');
--2������
--1)�������Ӳ�ѯ
--ֻ����һ�н�����Ӳ�ѯ�ͳ�Ϊ�����Ӳ�ѯ
--a����ֵ�Ӳ�ѯ
select *
       from emp
       where deptno=(select deptno 
                            from dept where dname='SALES');
                            
--b���ǵ�ֵ�Ӳ�ѯ
--��ѯ���й��ʱ�scott�ߵ�Ա������Ϣ
--����1 ����ѯscott�Ĺ���
select sal
       from emp where lower(ename)='scott';
       
--����2����ѯ��scott���ʸߵ�Ա����Ϣ
select *
       from emp
       where sal >(select sal
                          from emp where lower(ename)='scott')       
                            

--��ѯ��scott��ͬһ���ŵ�����Ա������Ϣ
--��ѯscott�����ڲ���
select deptno 
       from emp where lower(ename)='scott'  
       
--��ѯ����Ա������Ϣ
select *
       from emp
       where lower(ename) != 'scott' and deptno =(select deptno 
       from emp where lower(ename)='scott' )   
       
       
--c��ע������
--�����Ӳ�ѯֻ�ܷ��ص��е��еĽ��
--�����Ӳ�ѯ���ض�������
select *
       from emp
       where deptno =(select deptno ,ename
              from emp where lower(ename)='scott' )   
              
--�����Ӳ�ѯ���ض�������
select *
       from emp
       where deptno =(select deptno 
              from emp where lower(ename)='scott' or lower(ename)='allen')               
                   
--2)�������Ӳ�ѯ    
--�Ӳ�ѯ�ķ��ؽ��Ϊ��������

--��ѯ��������ΪRESEARCH��SALES������Ա����Ϣ
select deptno
       from dept where dname='RESEARCH' or  dname='SALES'  
       
--��not�� in�Ӳ�ѯ     ����ѯָ���е�ֵ�Ƿ�����ڼ��Ϸ�����
--ֻ֧�ֶ��е�������
select *
       from emp
       where deptno in(select deptno
             from dept where dname='RESEARCH' or  dname='SALES' )  

--�����Ӳ�ѯ�����˶�������             
select *
       from emp
       where deptno in(select deptno,dname
             from dept where dname='RESEARCH' or  dname='SALES' )
             
--��ѯн�ʸ��ڲ��ű��Ϊ20������Ա���Ĺ���
--��ѯ���ű��Ϊ20������Ա����н��
select sal
       from emp where deptno = 20  

--any       ��������������һ��ֵƥ�伴������Ҫ��
select *
       from emp 
       where deptno != 20 and  sal >any(select sal
       from emp where deptno = 20) 
       
--=any     : deptNo��(10,15)�е�����һ��ֵ��ȼ���(��in�Ӿ�����)
select *
       from dept
       where deptno = any(10,15)              

-->any     ��deptno��ֵ���ڣ�10,25��������һ��ֵ����             
select *
       from dept
       where deptno > any(10,25)              

--<any     ��deptno��ֵС��(10,25)������һ��ֵ����                                                 
select *
       from dept
       where deptno < any(10,25) 
       

--��ѯ�Ȳ��ű��Ϊ20������Ա�����ʸߵ�Ա����Ϣ   
--��ѯ����Ϊ20������Ա������    
select sal
       from emp where deptno = 20    

--all       ��������������ֵ��ƥ�伴����Ҫ��       
--һ�㲻����� ��= ������Ϊ�޷�����
select *
       from emp
       where sal > all(select sal
             from emp where deptno = 20)   
             
-->all       ����ѯ�ȼ���������ֵ����ļ�¼
select *
       from dept
       where deptno >all(10,20,25)                                          
     
--<all       ����ѯ�ȼ���������ֵ��С�ļ�¼
select *
       from dept
       where deptno <=all(10,20,25)
       
--exists�Ӳ�ѯ
--exists     ���Ӳ�ѯ����Ƿ��������з���
select * 
       from emp
       where exists(select * from emp where job='CLERK')
       
--in��exists������
--in   ��in�Ӳ�ѯ�Ὣ�������ʽ���ֶ�ֵ���Ӳ�ѯ�Ľ������ÿһ���ֶ�ֵ���жԱȣ�
--���ֵƥ�������ݽ�����ӵ���ѯ������У��������ݽ�������
/*
       List list = new ArrayList();
       list.add(1);
       list.add(2);
       
       //�ж�3�ڼ���list���Ƿ����
       for(Object o : list){
                  if(o == 3) return true;
       }
       return false;
*/       


--exists   ��existsֻ�ж��Ӳ�ѯ�Ƿ�����˲�ѯ�������
--����Ӳ�ѯ����������0�򷵻�true�����򷵻�false
/*
           List list = new ArrayList();
           list.add(1);
           list.add(2);
           
           return list.size()>0;
*/

--in�Ӳ�ѯ�᷵�ز�ѯ�������exists�Ӳ�ѯֵ���ز���ֵ

--˵��
--1�����Ӳ�ѯ�������Ӳ�ѯ�����滻
--2�������ѯ��������ڶ��������Ҫʹ�����Ӳ�ѯ��������ʹ���Ӳ�ѯ
--3������ʹ��exists���in




--��ѯ���۲�����Ա������Ϣ
--��ʾԱ���Ĺ��š���������ְ���ڡ������������ơ����ʵȼ�
--������������Դ�ڲ�ͬ������������ʹ�ö�����Ӳ�ѯ������
--1����ѯ����Ա����Ϣ
select *
       from emp;           
               
--2����Ա����Ͳ��ű�������Ӳ�ѯ�������ӣ�
select *
       from emp e, dept d
       where  e.deptno = d.deptno(+);  
       
--3����Ա�������ź�н�ʵȼ�����������Ӳ�ѯ�������ӣ�
 select *
       from emp e, dept d ,salgrade s
       where  e.deptno = d.deptno(+) and e.sal between s.losal and s.hisal(+);          

--4��������������޸�
 select empno,ename,hiredate,sal,dname,grade
       from emp e, dept d ,salgrade s
       where  e.deptno = d.deptno(+) 
              and e.sal between s.losal and s.hisal(+)   
              and d.dName='SALES';
              
--a��ִ��Ա����Ͳ��ű�����
/*
--�����ѯ��ʾ��
select *
       from emp e left join dept d on e.deptno = d.deptno
                  left join bonus b on e.ename = b.ename;
*/

select *
       from emp e left join dept d on e.deptno = d.deptno
                  left join salgrade s on e.sal between s.losal and s.hisal
       where d.dname ='SALES';
 
--����ѯ�������Ϊ��һ����ѯ���Ľ��������ʹ��      
select * from (select * from emp) a
                   
