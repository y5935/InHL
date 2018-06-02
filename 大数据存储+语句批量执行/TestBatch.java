package cn.hl.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;



public class TestBatch {
	/**
	 * 1����ͳ��ʽ
	 * ��Students���в���10000������
	 * ��ʱ��9969
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void add1() throws ClassNotFoundException, SQLException{
		//1���������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		
		//��ȡ��ʼ��ʱ��
		long begin = System.currentTimeMillis();
		//ѭ��1���
		for(int i = 1;i<=1000;i++){
			//2����ȡ���Ӷ���
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
			//3����дSql���
			String sql = "insert into students values(?,?)";
			
			//4����ȡStatement����
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setString(2, "Student" + i);
			
			//5��ִ��Sql���
			ps.executeUpdate();
			//6���ر����Ӷ���
			con.close();
		}
		//��ȡ������ʱ��
		long end = System.currentTimeMillis();
		
		System.out.println("��ʱ��" + (end - begin));
	}
	
	/**
	 * 2�������ύ��ʽ
	 * ��Students���в���10000������
	 * 	��ʱ5304
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void add2() throws SQLException, ClassNotFoundException{
		//1���������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		
		//��ȡ��ʼ��ʱ��
		long begin = System.currentTimeMillis();
		//2����ȡ���Ӷ���
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		//3����дSql���
		String sql = "insert into students values(?,?)";
		
		//4����ȡStatement����
		PreparedStatement ps = con.prepareStatement(sql);
		
		for(int i = 1;i<=1000;i++){
			ps.setInt(1, i);
			ps.setString(2, "Student" + i);
			//�������
			ps.addBatch();
		}
		
		//5��ִ��Sql���
		//ps.executeUpdate();
		ps.executeBatch();
		//6���ر����Ӷ���
		con.close();
		
		//��ȡ������ʱ��
		long end = System.currentTimeMillis();
				
		System.out.println("��ʱ��" + (end - begin));
	}
}
