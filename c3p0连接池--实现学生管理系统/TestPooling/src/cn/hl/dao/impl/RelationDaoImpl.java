package cn.hl.dao.impl;

import cn.hl.bean.Relation;
import cn.hl.dao.RelationDao;
import cn.hl.db.BaseDao;

public class RelationDaoImpl extends BaseDao implements RelationDao {
	/**
	 * ����ͥ��Ա��Ϣ�Ƿ��Ѿ�����
	 */
	@Override
	public boolean checkRelation(int stuNo, String name, String relation) {
		//��дSql���
		String sql = "select* from relations where stuNo = ? and name = ? and relation = ?";
		//ִ��sql���
		return this.executeQuery(Relation.class, sql,stuNo,name,relation).size()>0;
		
	}

	/**
	 * ��Ӽ�ͥ��Ա��Ϣ
	 */
	@Override
	public int add(Relation relation) {
		//��дsql���
		String sql = "insert into relations values(default,?,?,?,?)";
		//ִ��sql���
		int result = this.executrUpdate(sql,relation.getName(),relation.getRelation(),relation.getTel(),relation.getStuNo());
		return result;
	}
	

}
