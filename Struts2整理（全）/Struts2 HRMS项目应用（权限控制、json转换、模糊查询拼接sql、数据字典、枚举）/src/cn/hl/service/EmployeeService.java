package cn.hl.service;

import java.util.List;

import cn.hl.dao.EmployeeDao;
import cn.hl.util.Pagger;
import cn.hl.vo.Employee;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();
	
	public int add(Employee emp){
		return dao.add(emp);
	}
	
	/**
	 * 按Id删除用户信息
	 * @param id
	 * @return
	 */
	public int delete(int id){
		return dao.delete(id);
	}
	
	/**
	 * 按照分页方式查询数据
	 * @param pagger
	 * @return
	 */
	public void getList(Pagger<Employee> pagger){
		//设置总记录数
		pagger.setRows(dao.getRows());
		//通过dao对象查询数据
		List<Employee> list = dao.getList(pagger);
		System.out.println(list);
		//设置pagger对象的data属性
		pagger.setData(list);
		//return dao.getList(pagger);
	}
	
	public List<Employee> getByExp(Employee emp){
		return dao.getByExp(emp);
	}
}
