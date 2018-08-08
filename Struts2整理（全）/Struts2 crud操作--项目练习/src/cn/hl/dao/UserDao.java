package cn.hl.dao;

import java.util.List;

import cn.hl.bean.User;
import cn.hl.db.BaseDao;

public class UserDao extends BaseDao {
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public int add(User user){
		//定义SQL语句
		String sql = "insert into users values(default,?,?,?,?,?)";
		
		return this.executeUpdate(sql, user.getAccount(),user.getPwd(),user.getUserName(),user.getAge(),user.isGender());
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int update(User user){
		String sql = "update users set userName=?,account=?,pwd=?,age=?,gender=? where userId=?";
		
		return this.executeUpdate(sql, user.getUserName(),user.getAccount(),user.getPwd(),user.getAge(),user.isGender(),user.getUserId());
	}
	
	/**
	 * 按Id删除用户信息
	 * @param userId
	 * @return
	 */
	public int delete(int userId){
		String sql = "delete from users where userId=?";
		return this.executeUpdate(sql,userId);
	}
	
	/**
	 * 查询所有用户的信息列表
	 * @return
	 */
	public List<User> getAll(){
		String sql ="select * from users";
		
		return this.executeQuery(User.class, sql);
	}
	
	/**
	 * 按Id查询用户信息
	 * @param userId
	 * @return
	 */
	public User getById(int userId){
		String sql = "select * from users where UserId=?";
		
		List<User> list = this.executeQuery(User.class, sql, userId);
		
		if(list.size()>0)
			return list.get(0);
		else
			return null;
		
	}
}
