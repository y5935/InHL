package cn.hl.dao;

import java.util.ArrayList;
import java.util.List;

import cn.hl.db.BaseDao;
import cn.hl.util.Pagger;
import cn.hl.vo.Employee;

public class EmployeeDao extends BaseDao{
	/**
	 * 添加员工信息
	 * @param emp
	 * @return
	 */
	public int add(Employee emp){
		String sql = "insert into biz_emp_base values(default,?,?,?,?,?,?,?)";
		return this.executeUpdate(sql, emp.getEmpName(),emp.isGender(),emp.getDeptId(),emp.getPositionId(),
				emp.getEducation(),emp.getDegree(),emp.getState());
	}
	
	
	/**
	 * 按Id删除员工信息
	 */
	public int delete(int id){
		String sql ="delete from biz_emp_base where empId=?";
		return this.executeUpdate(sql, id);
	}
	
	/**
	 * 以分页方式查询用户数据
	 * @param pagger
	 * @return
	 */
	public List<Employee> getList(Pagger pagger){
		//1、编写SQL语句
		String sql = "select * from biz_emp_base order by EmpId limit ?,?";
		return this.executeQuery(Employee.class, sql, pagger.getIndex() * pagger.getPageSize() , pagger.getPageSize());
	}
	
	/**
	 * 多条件查询
	 * @param emp
	 * @return
	 */
	public List<Employee> getByExp(Employee emp){
		List<Object> list = new ArrayList<Object>();
		
		String sql = "select * from biz_emp_base where 1=1";
		
		System.out.println(emp.getEmpName() !=null);
		if(emp.getEmpName() !=null){
			sql += " and empName like ?";
			list.add("%"+emp.getEmpName()+"%");
		}
		
		if(emp.getDeptId() != 0){
			sql += " and deptId=?";
			list.add(emp.getDeptId());
		}
		
		System.out.println(sql + " | " + list.size());
		return this.executeQuery(Employee.class, sql, list.toArray());
	}
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getRows(){
		return this.getRows("biz_emp_base");
	}
}
