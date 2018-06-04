package cn.hl.dao.impl;

import cn.hl.bean.Relation;
import cn.hl.dao.RelationDao;
import cn.hl.db.BaseDao;

public class RelationDaoImpl extends BaseDao implements RelationDao {
	/**
	 * 检查家庭成员信息是否已经存在
	 */
	@Override
	public boolean checkRelation(int stuNo, String name, String relation) {
		//编写Sql语句
		String sql = "select* from relations where stuNo = ? and name = ? and relation = ?";
		//执行sql语句
		return this.executeQuery(Relation.class, sql,stuNo,name,relation).size()>0;
		
	}

	/**
	 * 添加家庭成员信息
	 */
	@Override
	public int add(Relation relation) {
		//编写sql语句
		String sql = "insert into relations values(default,?,?,?,?)";
		//执行sql语句
		int result = this.executrUpdate(sql,relation.getName(),relation.getRelation(),relation.getTel(),relation.getStuNo());
		return result;
	}
	

}
