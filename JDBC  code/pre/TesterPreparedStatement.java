package cn.hl.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TesterPreparedStatement {

	/**
	 * ʹ��PreparedStatement���в�ѯ
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testSelect() throws SQLException, ClassNotFoundException {
		// ��д���ݿ������ַ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		// �û���
		String user = "scott";
		// ����
		String password = "tiger";

		// ����һ��������������
		Class.forName("oracle.jdbc.OracleDriver");
		// ���������ȡ���Ӷ���
		Connection con = DriverManager.getConnection(url, user, password);
		// ����������ȡPreparedStatement
		String sql = "select * from sys_users";
		PreparedStatement ps = con.prepareStatement(sql);

		// �����ģ�ִ��Sql���
		ResultSet rs = ps.executeQuery();

		// �����壺��ȡ����
		rs.next();
		System.out.println(rs.getString(1));

		rs.close();
		ps.close();
		con.close();
	}
	
	@Test
	public void testAdd() throws SQLException, ClassNotFoundException {
		// ��д���ݿ������ַ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		// �û���
		String user = "scott";
		// ����
		String password = "tiger";

		// ����һ��������������
		Class.forName("oracle.jdbc.OracleDriver");
		// ���������ȡ���Ӷ���
		Connection con = DriverManager.getConnection(url, user, password);
		// ����������ȡPreparedStatement
		//����Sql���ģ��
		String sql = "insert into sys_users values(users_id.nextval,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//Ϊģ��Ĳ�����ֵ
		ps.setString(1, "�γ���");
		ps.setString(2, "he");
		ps.setString(3, "123456");
		ps.setInt(4, 1);

		// �����ģ�ִ��Sql���
		ResultSet rs = ps.executeQuery();

		// �����壺��ȡ����
		rs.next();
		System.out.println(rs.getString(1));

		rs.close();
		ps.close();
		con.close();
	}
}
