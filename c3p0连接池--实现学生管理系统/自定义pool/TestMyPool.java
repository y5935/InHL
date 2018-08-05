package cn.hl.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestMyPool {
	public static void main(String[] args) {
		
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			MyPool pool = new MyPool();
		try{
			conn = pool.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from account where id = 1");
			if(rs.next()){
				System.out.println(rs.getInt("id") + ":" + rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat!= null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pool.returnConn(conn);
		}
		
	
	}
}
