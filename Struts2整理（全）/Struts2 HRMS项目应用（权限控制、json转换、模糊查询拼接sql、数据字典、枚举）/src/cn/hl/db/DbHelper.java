package cn.hl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC������
 * 	1�������������
 * @author Terry
 *
 */
public class DbHelper {
	//��ʼ���ַ�
	private static String driver	="com.mysql.jdbc.Driver";
	private static String url 		= "jdbc:mysql://localhost:3306/EmployeeDB?useUnicode=true&characterEncoding=UTF-8";
	private static String user		="root";
	private static String pwd		="123";
	
	//������
	/**
	 * ��̬�����
	 * 	������ݿ���
	 */
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��ȡ���Ӷ���
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, pwd);
	}
}
