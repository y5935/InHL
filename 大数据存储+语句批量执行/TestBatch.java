package cn.hl.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;



public class TestBatch {
	/**
	 * 1、传统方式
	 * 向Students表中插入10000表数据
	 * 用时：9969
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void add1() throws ClassNotFoundException, SQLException{
		//1、加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取开始的时间
		long begin = System.currentTimeMillis();
		//循环1万次
		for(int i = 1;i<=1000;i++){
			//2、获取连接对象
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
			//3、编写Sql语句
			String sql = "insert into students values(?,?)";
			
			//4、获取Statement对象
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setString(2, "Student" + i);
			
			//5、执行Sql语句
			ps.executeUpdate();
			//6、关闭连接对象
			con.close();
		}
		//获取结束的时间
		long end = System.currentTimeMillis();
		
		System.out.println("用时：" + (end - begin));
	}
	
	/**
	 * 2、批量提交方式
	 * 向Students表中插入10000表数据
	 * 	用时5304
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void add2() throws SQLException, ClassNotFoundException{
		//1、加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取开始的时间
		long begin = System.currentTimeMillis();
		//2、获取连接对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		//3、编写Sql语句
		String sql = "insert into students values(?,?)";
		
		//4、获取Statement对象
		PreparedStatement ps = con.prepareStatement(sql);
		
		for(int i = 1;i<=1000;i++){
			ps.setInt(1, i);
			ps.setString(2, "Student" + i);
			//批量添加
			ps.addBatch();
		}
		
		//5、执行Sql语句
		//ps.executeUpdate();
		ps.executeBatch();
		//6、关闭连接对象
		con.close();
		
		//获取结束的时间
		long end = System.currentTimeMillis();
				
		System.out.println("用时：" + (end - begin));
	}
}
