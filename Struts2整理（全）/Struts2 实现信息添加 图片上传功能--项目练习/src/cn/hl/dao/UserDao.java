package cn.hl.dao;

import cn.hl.bean.User;
import cn.hl.db.BaseDao;

public class UserDao extends BaseDao{
	public int add(User user){
		//编写SQL语句
		String sql = "insert into users values(default,?,?,?,?,?,?,?)";
		
		return this.executeUpdate(sql, user.getName(),user.isGender(),user.getAge(),user.getIdCard(),user.getPhoto(),user.getTel(),user.getAddress());
	}
}
