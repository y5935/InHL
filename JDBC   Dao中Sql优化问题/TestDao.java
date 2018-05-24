package cn.hl.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cn.hl.bean.Grade;
import cn.hl.db.BaseDao;

public class TestDao {
	
	/**
	 * 使用BaseDao获取Grade表中的数据
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	@Test
	public void getGrade() throws InstantiationException, IllegalAccessException, SQLException{
		BaseDao dao = new BaseDao();
		List<Grade> list=dao.executeQuery(Grade.class, "select * from grade");
		
		System.out.println(list);
	}
}


