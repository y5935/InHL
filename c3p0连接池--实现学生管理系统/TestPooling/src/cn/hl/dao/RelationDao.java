package cn.hl.dao;

import cn.hl.bean.Relation;

public interface RelationDao {
	
	/**
	 * ��֤��ͥ��Ա��ϵ�Ƿ��Ѿ�����
	 * @param stuNo
	 * @param name
	 * @param relation
	 * @return
	 */
	public boolean checkRelation(int stuNo,String name,String relation);
	/**
	 * ��Ӽ�ͥ��Ա��Ϣ
	 * @param relation
	 * @return
	 */
	public int add(Relation relation);
}
