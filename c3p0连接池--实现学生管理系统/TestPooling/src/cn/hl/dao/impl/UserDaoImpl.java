package cn.hl.dao.impl;

import java.util.List;

import cn.hl.bean.User;
import cn.hl.dao.UserDao;
import cn.hl.db.BaseDao;

/**
 * 增（添加数据）
 * 删（按Id删除 数据）
 * 改（按Id修改数据）
 * 查（查询所有数据、按id查询单一数据、多条件查询）
 * 
 * @author Lens
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public int add(User user){
		return 0;
		
	}
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int update(User user){
		return 0;
		
	}
	
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public int delete(int id){
		return id;
		
	}
	 
	/**
	 * 实现用户登录验证
	 * 按照账号和密码查询用户信息 
	 * @param account
	 * @param pwd
	 * @return
	 */
	public User getByAccount(String account,String pwd){
		//编写Sql语句
		String sql = "select* from users where account=? and pwd =?";
		//执行查询
		List<User> list = this.executeQuery(User.class, sql, account,pwd);
		//判断查询结果（如果集合中元素多于0个表示验证成功）
	/*	if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}*/
		return (list.size()>0) ? list.get(0) : null;
	}
	
	
	
}
