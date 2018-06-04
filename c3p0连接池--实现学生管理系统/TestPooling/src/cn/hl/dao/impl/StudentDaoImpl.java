package cn.hl.dao.impl;

import java.util.List;

import cn.hl.bean.Student;
import cn.hl.dao.StudentDao;
import cn.hl.db.BaseDao;

public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public Student getById(int id) {
		String sql = "select * from students where stuNo = ?";
		//����executeQuery()������ѯѧ����Ϣ
		List<Student> list = this.executeQuery(Student.class, sql, id);
		//���ز�ѯ����ѧ����Ϣ
		return (list.size()>0) ? list.get(0) : null;
	}

}
