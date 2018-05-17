package cn.hl.jdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestConnection {
	/**
	 * ��ȡ���ݿ����Ӷ���
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void testConnect() throws ClassNotFoundException, SQLException{
		//url��ʽ��jdbc������Э������
		//orlcle��url��ʽ��jdbc:oracle:thin:������ַ:�˿ں�:���ݿ�����
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//�û���
		String user = "scott";
		//����
		String password ="tiger";
		
		//����һ����������
		//Referenced >> ojdbc6.jar >> oracle.jdbc >> OracleDriver
		//����Ҽ� >> Copy Qualified Name
		Class.forName("oracle.jdbc.OracleDriver");
		
		//�������ͨ��������������ȡ���Ӷ���
		Connection con = DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * ִ�����ݲ������
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void testInsert() throws ClassNotFoundException, SQLException{
		//��д���ݿ������ַ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//�û���
		String user = "scott";
		//����
		String password ="tiger";
		
		//����һ��������������
		Class.forName("oracle.jdbc.OracleDriver");
		
		//���������ȡ���Ӷ���
		Connection con = DriverManager.getConnection(url, user, password);
		
		//����������ȡStatment���͵Ķ���
		Statement smt = con.createStatement();
		
		//�����ģ���дSql���
		String sql = "insert into teacher values('t004','Mike')";
		//���岽��ִ��Sql���
		int result = smt.executeUpdate(sql);
		
		System.out.println("result = " + result);
	}
	
	/**
	 * ִ�������޸����
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdate() throws SQLException, ClassNotFoundException{
		//��д���ݿ������ַ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//�û���
		String user = "scott";
		//����
		String password ="tiger";
		
		//����һ��������������
		Class.forName("oracle.jdbc.OracleDriver");
		
		//���������ȡConnection����
		Connection con = DriverManager.getConnection(url, user, password);
		
		//����������ȡStatement����
		Statement smt = con.createStatement();
		
		//�����ģ���дSql���
		String sql = "update teacher set TName = '��÷÷' where Tno = 't002'";
		
		//ִ��Sql���
		int result = smt.executeUpdate(sql);
		
		System.out.println("result = " + result);
	}
	
	/**
	 * ִ�в�ѯ���
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testSelect() throws SQLException, ClassNotFoundException{
		//��д���ݿ������ַ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//�û���
		String user = "scott";
		//����
		String password ="tiger";
		
		//����һ��������������
		Class.forName("oracle.jdbc.OracleDriver");
		
		//���������ȡ���Ӷ���
		Connection con = DriverManager.getConnection(url, user, password);
		
		//����������ȡStatement����
		Statement smt = con.createStatement();
		
		//�����ģ���дSql���
		String sql = "select * from teacher";
		
		//�����壺ִ��Sql���
		ResultSet rs = smt.executeQuery(sql);
		
		while(rs.next())
			System.out.println(rs.getString(1)+ "\t" + rs.getString("tname"));
	}
	
	/**
	 * ����淶
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testClose() throws SQLException, ClassNotFoundException{
		//��д���ݿ������ַ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//�û���
		String user = "scott";
		//����
		String password ="tiger";
		
		//����һ��������������
		Class.forName("oracle.jdbc.OracleDriver");
		
		//���������ȡ���Ӷ���
		Connection con = DriverManager.getConnection(url, user, password);
		
		//����������ȡStatement����
		Statement smt = con.createStatement();
		
		//�����ģ���дSql���
		String sql = "select * from teacher";
		
		//�����壺ִ��Sql���
		ResultSet rs = smt.executeQuery(sql);
		
		while(rs.next())
			System.out.println(rs.getString(1)+ "\t" + rs.getString("tname"));
		
		if(rs != null){
			rs.close();
		}
		
		if(smt != null){
			smt.close();
		}
		
		if(con != null){
			con.close();
		}		
	}
	
	@Test
	public void testAll(){
		//�����ַ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//�û���
		String user = "scott";
		//����
		String pwd = "tiger";
		
		Connection con = null;
		Statement smt = null;
		ResultSet rs =null;
		
		try {
			//����һ����������
			Class.forName("oracle.jdbc.OracleDriver");
			
			//���������ȡ���Ӷ���
			con =  DriverManager.getConnection(url, user, pwd);
			
			//����������ȡStatement����
			smt = con.createStatement();
			
			//�����ģ���дSql���
			String sql = "select * from teacher";
			
			//�����壺ִ��Sql���
			rs =  smt.executeQuery(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//���������ͷ���Դ
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(smt != null){
				try {
					smt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		try {
			if(rs.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
