package cn.hl.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TesterPreparedStatement {

	/**
	 * 使用PreparedStatement进行查询
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testSelect() throws SQLException, ClassNotFoundException {
		// 编写数据库连接字符串
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		// 用户名
		String user = "scott";
		// 密码
		String password = "tiger";

		// 步骤一：加载驱动程序
		Class.forName("oracle.jdbc.OracleDriver");
		// 步骤二：获取连接对象
		Connection con = DriverManager.getConnection(url, user, password);
		// 步骤三：获取PreparedStatement
		String sql = "select * from sys_users";
		PreparedStatement ps = con.prepareStatement(sql);

		// 步骤四：执行Sql语句
		ResultSet rs = ps.executeQuery();

		// 步骤五：读取数据
		rs.next();
		System.out.println(rs.getString(1));

		rs.close();
		ps.close();
		con.close();
	}
	
	@Test
	public void testAdd() throws SQLException, ClassNotFoundException {
		// 编写数据库连接字符串
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		// 用户名
		String user = "scott";
		// 密码
		String password = "tiger";

		// 步骤一：加载驱动程序
		Class.forName("oracle.jdbc.OracleDriver");
		// 步骤二：获取连接对象
		Connection con = DriverManager.getConnection(url, user, password);
		// 步骤三：获取PreparedStatement
		//定义Sql语句模板
		String sql = "insert into sys_users values(users_id.nextval,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//为模板的参数赋值
		ps.setString(1, "何长友");
		ps.setString(2, "he");
		ps.setString(3, "123456");
		ps.setInt(4, 1);

		// 步骤四：执行Sql语句
		ResultSet rs = ps.executeQuery();

		// 步骤五：读取数据
		rs.next();
		System.out.println(rs.getString(1));

		rs.close();
		ps.close();
		con.close();
	}
}
