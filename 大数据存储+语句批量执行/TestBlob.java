package cn.hl.lob;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestBlob {
	/**
	 * ��E:\1.jpg�洢Picture����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void add() throws ClassNotFoundException, SQLException, FileNotFoundException{
		//1����������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���Ӷ���
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "123456");
		
		//4����дSql���
		String sql = "insert into Picture values(?,?)";
		
		//3����ȡStatement����
		PreparedStatement ps = con.prepareStatement(sql);
		
		//���ò���
		ps.setInt(1, 1);
		ps.setBlob(2, new FileInputStream("e:\\1.jpg"));
				
		//5��ִ��Sql���
		int result = ps.executeUpdate();
		
		//6���ر�����
		con.close();
		
		System.out.println("��Ӱ������Ϊ��" + result);
	}
	
	/**
	 * ��ȡ���ݱ��е�blob��������
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	@Test
	public void read() throws ClassNotFoundException, SQLException, IOException{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ���Ӷ���
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "123456");
		//��дsql���
		String sql = "select * from Picture where picid=1";
		//��ȡstatement����
		PreparedStatement ps = con.prepareStatement(sql);
		//ִ��Sql���
		ResultSet rs = ps.executeQuery();
		
		//��ȡResultSet�е�����
		if(rs.next()){
			//1������ȡ����
			Blob blob = rs.getBlob("pic");
			//2��������һ�����������
			FileOutputStream os = new FileOutputStream("c:\\2.jpg");
			//3����������д�뵽ָ��λ��
			os.write(blob.getBytes(1,(int)blob.length()));
			//4����ǿ����ջ�����
			os.flush();
			//5�����ر�������
			os.close();
		}
		
		//�ر�����
		con.close();
	}
}
