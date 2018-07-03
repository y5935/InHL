package cn.hl.dao;

import java.util.List;

import cn.hl.bean.User;
import cn.hl.db.BaseDao;

public class UserDao extends BaseDao{
	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 */
	public int add(User user){
		//编写sql语句
		String sql = "insert into Users values(default,?,?,?)";
		
		//调用executeUpdate方法
		return this.executeUpdate(sql, user.getAccount(),user.getPwd(),user.getUserName());
	}
	
	/**
	 * 按Id更新用户信息
	 * @param user
	 * @return
	 */
	public int update(User user){
		String sql = "update users set userName=?,account=?,pwd=? where userId=?";
		
		//执行SQL语句
		return this.executeUpdate(sql, user.getUserName(),user.getAccount(),user.getPwd(),user.getUserId());
	}
	
	/**
	 * 按Id删除用户信息
	 * @param id
	 * @return
	 */
	public int delete(String id){
		String sql = "delete from users where userId=?";
		
		//执行SQL语句
		return this.executeUpdate(sql, id);
	}
	
	/**
	 * 查询所有用户列表
	 * @return
	 */
	public List<User> getAll(){
		String sql = "select * from users";
		
		//执行SQL语句
		return this.executeQuery(User.class, sql);
	}
	
	/**
	 * 按照Id查询指定用户的信息
	 * @param id
	 * @return
	 */
	public User getById(String id){
		String sql = "select * from users where userid=?";
		
		List<User> list = this.executeQuery(User.class, sql, id);
		return (list.size()>0) ? list.get(0) : null;
	}
	
	/**
	 * 按照姓名执行模糊查询
	 * @param name
	 * @return
	 */
	public List<User> getByName(String name){
		String sql = "select * from users where userName like ?";
		return this.executeQuery(User.class, sql, "%" + name + "%");
	}
}
