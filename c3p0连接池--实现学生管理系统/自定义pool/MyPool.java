package cn.hl.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MyPool  {
	private static List<Connection> pool = new LinkedList<Connection>();
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (int i = 0; i < 5; i++) {
				Connection conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=UTF-8",
								"root", "123456");
				pool.add(conn);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException {
		if(pool.size()>0){
			for (int i = 0; i < 3; i++) {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb1?useUnicode=true&characterEncoding=UTF-8",
								"root", "123456");
				pool.add(conn);
			}
		}
		Connection conn = pool.remove(0);
		return conn;
	}
	
	public void  returnConn(Connection conn){
		try {
			if(conn != null && !conn.isClosed()){
				pool.add(conn); 
				System.out.println("成功还回一个连接，" + "池中还剩" + pool.size() + "个连接。。。");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
