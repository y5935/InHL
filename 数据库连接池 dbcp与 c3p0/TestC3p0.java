package cn.hl.pooling.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {

	public static void main(String[] args) throws SQLException {
		//获取ComboPooledDataSource对象
		//通过ComboPooledDataSource对象可以获取到数据源对象---连接池类
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//通过ComboPooledDataSolurce对象的getConnection()可以获取到连接对象
		//Connection在C3p0中被转换成了代理对象
		Connection con = dataSource.getConnection();
		System.out.println(con);
		//关闭连接对象
		con.close();

	}

}
