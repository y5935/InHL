package cn.hl.dao;

import java.util.List;

import cn.hl.db.BaseDao;
import cn.hl.vo.User;

public class UserDao extends BaseDao{
	/**
	 * 按照账号查询用户信息
	 * @param account
	 * @param pwd
	 * @return
	 */
	public List<User> findByAccount(String account){
		//1、编写SQL语句
		String sql = "select * from sys_users where state=1 and account=?";
		
		return this.executeQuery(User.class, sql, account);
	}
}
