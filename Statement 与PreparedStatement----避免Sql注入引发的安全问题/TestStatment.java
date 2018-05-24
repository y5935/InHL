package cn.hl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

public class TestStatment {
	
	/**
	 * 1、使用Statement对象执行Sql语句
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void test1() throws SQLException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		
		//提示用户输入用户名和密码并进行接收
		System.out.print("账号：");
		String account = input.nextLine();
		System.out.print("密码：");
		String pwd = input.next();
		
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取Connection对象
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		//3、编写Sql语句
		//String sql = "select * from users where account='a'";
		String sql = "select * from users where account='"+ account+ "' and pwd ='" + pwd + "'" ;
		
		//4、获取Statment对象
		Statement smt = con.createStatement();
		//5、执行Sql语句
		ResultSet rs = smt.executeQuery(sql);
		//6、关闭连接对象
		con.close();
	}
	
	/**
	 * 2、使用PreparedStatement对象执行Sql语句
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void test2() throws ClassNotFoundException, SQLException{
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		// 2、获取Connection对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		// 3、编写Sql语句
		String sql = "select * from users where account='a'";
		//4、获取PreparedStatement对象
		PreparedStatement ps = con.prepareStatement(sql);
		//5、执行Sql语句
		ps.executeQuery();
		//6、关闭连接对象
		con.close();
		
	}
	
	/**
	 * 3、测试PreparedStatement对象的注入
	 * 	输入数据：Mike' or 1=1 -- 和 123
	 * 	结果：true 
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void test3() throws ClassNotFoundException, SQLException{
		Scanner input = new Scanner(System.in);
		
		//提示用户输入用户名和密码并进行接收
		System.out.print("账号：");
		String account = input.nextLine();
		System.out.print("密码：");
		String pwd = input.next();
		
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		// 2、获取Connection对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		// 3、编写Sql语句
		String sql = "select * from users where account='"+ account+ "' and pwd ='" + pwd + "'" ;
		System.out.println(sql);
		//4、获取PreparedStatement对象
		PreparedStatement ps = con.prepareStatement(sql);
		//5、执行Sql语句
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		//6、关闭连接对象
		con.close();
		
	}
	
	/**
	 * 4、测试PreparedStatement对象的注入
	 * 	输入数据：Mike' or 1=1 -- 和 123
	 * 	结果： false 
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void test4() throws ClassNotFoundException, SQLException{
		Scanner input = new Scanner(System.in);
		
		//提示用户输入用户名和密码并进行接收
		System.out.print("账号：");
		String account = input.nextLine();
		System.out.print("密码：");
		String pwd = input.next();
		
		//1、加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		// 2、获取Connection对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		// 3、编写Sql语句
		String sql = "select * from users where account=? and pwd =?" ;
		System.out.println(sql);
		//4、获取PreparedStatement对象
		PreparedStatement ps = con.prepareStatement(sql);
		//为PreparedStatement传递参数。参数的索引下标从1开始
		ps.setString(1, account);
		ps.setString(2, pwd);		
		
		//5、执行Sql语句
		ResultSet rs = ps.executeQuery();
		boolean b = rs.next();
		System.out.println(b);
		//6、关闭连接对象
		con.close();
		
	
		
	}
	
}
