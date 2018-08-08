package cn.hl.action;

import java.util.List;

import net.sf.json.JSONArray;
import cn.hl.service.EmployeeService;
import cn.hl.util.Pagger;
import cn.hl.vo.Employee;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class EmployeeAction {
	private Employee emp = new Employee();
	private JSONArray root;
	private Pagger<Employee> pager = new Pagger<Employee>();
	private EmployeeService service = new EmployeeService();
	
	/**
	 * 添加员工信息
	 * @return
	 */
	public String add(){
		System.out.println(emp);
		service.add(emp);
		
		return "success";
	}
	
	/**
	 * 获取所有数据列表
	 * @return
	 */
	public String getAll(){
		System.out.println("getAll is do......");
		//读取数据
		service.getList(pager);
		root = JSONArray.fromObject(pager);
			
		System.out.println(pager);
		return "success";
	}
	
	/**
	 * 按照Id删除用户信息
	 * @return
	 */
	public String delete(){
		if(service.delete(emp.getEmpId())>0)
			return "success";
		else
			return "error";
	}
	
	public String getByExp(){
		System.out.println("emp = " + emp);
		List<Employee> list = service.getByExp(emp);
		root = JSONArray.fromObject(list);
		
		return "success";
	}
	
	

	public Pagger getPager() {
		return pager;
	}

	public void setPager(Pagger pager) {
		this.pager = pager;
	}	
	
	public JSONArray getRoot() {
		return root;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}	
	
	
}
