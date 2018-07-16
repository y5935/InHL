package cn.hl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC工具类
 * 	1、负责加载驱动类
 * @author Terry
 *
 */
public class DbHelper {
	//初始化字符串
	private static String driver	="com.mysql.jdbc.Driver";
	private static String url 		= "jdbc:mysql://localhost:3306/studentdb";
	private static String user		="root";
	private static String pwd		="123456";
	
	//加载驱动
	/**
	 * 静态代码块
	 * 	加载数据库驱动
	 */
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, pwd);
	}
}
