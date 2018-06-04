package cn.hl.dao;

import cn.hl.bean.Relation;

public interface RelationDao {
	
	/**
	 * 验证家庭成员关系是否已经存在
	 * @param stuNo
	 * @param name
	 * @param relation
	 * @return
	 */
	public boolean checkRelation(int stuNo,String name,String relation);
	/**
	 * 添加家庭成员信息
	 * @param relation
	 * @return
	 */
	public int add(Relation relation);
}
