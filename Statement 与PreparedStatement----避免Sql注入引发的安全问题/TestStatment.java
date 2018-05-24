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
	 * 1��ʹ��Statement����ִ��Sql���
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void test1() throws SQLException, ClassNotFoundException{
		Scanner input = new Scanner(System.in);
		
		//��ʾ�û������û��������벢���н���
		System.out.print("�˺ţ�");
		String account = input.nextLine();
		System.out.print("���룺");
		String pwd = input.next();
		
		//1������������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡConnection����
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		//3����дSql���
		//String sql = "select * from users where account='a'";
		String sql = "select * from users where account='"+ account+ "' and pwd ='" + pwd + "'" ;
		
		//4����ȡStatment����
		Statement smt = con.createStatement();
		//5��ִ��Sql���
		ResultSet rs = smt.executeQuery(sql);
		//6���ر����Ӷ���
		con.close();
	}
	
	/**
	 * 2��ʹ��PreparedStatement����ִ��Sql���
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void test2() throws ClassNotFoundException, SQLException{
		//1������������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����ȡConnection����
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		// 3����дSql���
		String sql = "select * from users where account='a'";
		//4����ȡPreparedStatement����
		PreparedStatement ps = con.prepareStatement(sql);
		//5��ִ��Sql���
		ps.executeQuery();
		//6���ر����Ӷ���
		con.close();
		
	}
	
	/**
	 * 3������PreparedStatement�����ע��
	 * 	�������ݣ�Mike' or 1=1 -- �� 123
	 * 	�����true 
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void test3() throws ClassNotFoundException, SQLException{
		Scanner input = new Scanner(System.in);
		
		//��ʾ�û������û��������벢���н���
		System.out.print("�˺ţ�");
		String account = input.nextLine();
		System.out.print("���룺");
		String pwd = input.next();
		
		//1������������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����ȡConnection����
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		// 3����дSql���
		String sql = "select * from users where account='"+ account+ "' and pwd ='" + pwd + "'" ;
		System.out.println(sql);
		//4����ȡPreparedStatement����
		PreparedStatement ps = con.prepareStatement(sql);
		//5��ִ��Sql���
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		//6���ر����Ӷ���
		con.close();
		
	}
	
	/**
	 * 4������PreparedStatement�����ע��
	 * 	�������ݣ�Mike' or 1=1 -- �� 123
	 * 	����� false 
	 * 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	@Test
	public void test4() throws ClassNotFoundException, SQLException{
		Scanner input = new Scanner(System.in);
		
		//��ʾ�û������û��������벢���н���
		System.out.print("�˺ţ�");
		String account = input.nextLine();
		System.out.print("���룺");
		String pwd = input.next();
		
		//1������������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����ȡConnection����
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "123456");
		// 3����дSql���
		String sql = "select * from users where account=? and pwd =?" ;
		System.out.println(sql);
		//4����ȡPreparedStatement����
		PreparedStatement ps = con.prepareStatement(sql);
		//ΪPreparedStatement���ݲ����������������±��1��ʼ
		ps.setString(1, account);
		ps.setString(2, pwd);		
		
		//5��ִ��Sql���
		ResultSet rs = ps.executeQuery();
		boolean b = rs.next();
		System.out.println(b);
		//6���ر����Ӷ���
		con.close();
		
	
		
	}
	
}
