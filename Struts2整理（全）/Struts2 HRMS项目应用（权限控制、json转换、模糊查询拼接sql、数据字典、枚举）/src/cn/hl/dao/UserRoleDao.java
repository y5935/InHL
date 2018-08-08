package cn.hl.dao;

import java.util.List;

import cn.hl.db.BaseDao;
import cn.hl.vo.UserRole;

public class UserRoleDao extends BaseDao{
	/**
	 * 按照用户Id查询对应的角色（Role）列表
	 * @param userId
	 * @return
	 */
	public List<UserRole> getByUserId(int userId){
		//编写SQL语句
		String sql = "select * from sys_user_role where userId=?";
		
		return this.executeQuery(UserRole.class, sql, userId);
	}
}
