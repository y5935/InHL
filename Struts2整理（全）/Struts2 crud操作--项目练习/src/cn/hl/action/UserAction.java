package cn.hl.action;

import java.util.ArrayList;
import java.util.List;

import cn.hl.bean.User;
import cn.hl.dao.UserDao;

public class UserAction {
	private User user = new User();
	private List<User> list = new ArrayList<User>();
	
	UserDao dao = new UserDao();
	
	/**
	 * 查询所有用户信息列表
	 * @return
	 */
	public String getAll(){
		list = dao.getAll();
		System.out.println(list);
		
		if(list != null)
			return "list";
		else
			return "error";
	}
	
	/**
	 * 添加用户信息到数据库
	 * @return
	 */
	public String add(){
		System.out.println(user);
		
		if(dao.add(user)>0)
			return "success";
		else
			return "error";
	}
	
	/**
	 * 按照Id加载用户数据
	 * @return
	 */
	public String getById(){
		if(user.getUserId()>0){
			user=dao.getById(user.getUserId());
		
			return "input";
		}
		else
			return "error";
	}
	
	public String update(){
		System.out.println(user);
		
		if(dao.update(user)>0)
			return "success";
		else
			return "error";
	}
	
	public String delete(){
		if(dao.delete(user.getUserId())>0)
			return "success";
		else
			return "error";
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
