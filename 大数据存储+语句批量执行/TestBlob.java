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
	 * 将E:\1.jpg存储Picture表中
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void add() throws ClassNotFoundException, SQLException, FileNotFoundException{
		//1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取连接对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "123456");
		
		//4、编写Sql语句
		String sql = "insert into Picture values(?,?)";
		
		//3、获取Statement对象
		PreparedStatement ps = con.prepareStatement(sql);
		
		//设置参数
		ps.setInt(1, 1);
		ps.setBlob(2, new FileInputStream("e:\\1.jpg"));
				
		//5、执行Sql语句
		int result = ps.executeUpdate();
		
		//6、关闭连接
		con.close();
		
		System.out.println("受影响行数为：" + result);
	}
	
	/**
	 * 读取数据表中的blob类型数据
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	@Test
	public void read() throws ClassNotFoundException, SQLException, IOException{
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "123456");
		//编写sql语句
		String sql = "select * from Picture where picid=1";
		//获取statement对象
		PreparedStatement ps = con.prepareStatement(sql);
		//执行Sql语句
		ResultSet rs = ps.executeQuery();
		
		//读取ResultSet中的数据
		if(rs.next()){
			//1）、读取数据
			Blob blob = rs.getBlob("pic");
			//2）、创建一个输出流对象
			FileOutputStream os = new FileOutputStream("c:\\2.jpg");
			//3）、将对象写入到指定位置
			os.write(blob.getBytes(1,(int)blob.length()));
			//4）、强制清空缓冲区
			os.flush();
			//5）、关闭流对象
			os.close();
		}
		
		//关闭连接
		con.close();
	}
}
