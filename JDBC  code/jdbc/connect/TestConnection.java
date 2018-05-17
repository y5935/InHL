package cn.hl.jdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestConnection {
	/**
	 * 获取数据库连接对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void testConnect() throws ClassNotFoundException, SQLException{
		//url格式：jdbc：厂商协议类型
		//orlcle的url格式：jdbc:oracle:thin:主机地址:端口号:数据库名称
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//用户名
		String user = "scott";
		//密码
		String password ="tiger";
		
		//步骤一：加载驱动
		//Referenced >> ojdbc6.jar >> oracle.jdbc >> OracleDriver
		//鼠标右键 >> Copy Qualified Name
		Class.forName("oracle.jdbc.OracleDriver");
		
		//步骤二：通过驱动管理器获取连接对象
		Connection con = DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * 执行数据插入语句
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void testInsert() throws ClassNotFoundException, SQLException{
		//编写数据库连接字符串
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//用户名
		String user = "scott";
		//密码
		String password ="tiger";
		
		//步骤一：加载驱动程序
		Class.forName("oracle.jdbc.OracleDriver");
		
		//步骤二：获取连接对象
		Connection con = DriverManager.getConnection(url, user, password);
		
		//步骤三：获取Statment类型的对象
		Statement smt = con.createStatement();
		
		//步骤四：编写Sql语句
		String sql = "insert into teacher values('t004','Mike')";
		//第五步：执行Sql语句
		int result = smt.executeUpdate(sql);
		
		System.out.println("result = " + result);
	}
	
	/**
	 * 执行数据修改语句
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdate() throws SQLException, ClassNotFoundException{
		//编写数据库连接字符串
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//用户名
		String user = "scott";
		//密码
		String password ="tiger";
		
		//步骤一：加载驱动程序
		Class.forName("oracle.jdbc.OracleDriver");
		
		//步骤二：获取Connection对象
		Connection con = DriverManager.getConnection(url, user, password);
		
		//步骤三：获取Statement对象
		Statement smt = con.createStatement();
		
		//步骤四：编写Sql语句
		String sql = "update teacher set TName = '韩梅梅' where Tno = 't002'";
		
		//执行Sql语句
		int result = smt.executeUpdate(sql);
		
		System.out.println("result = " + result);
	}
	
	/**
	 * 执行查询语句
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testSelect() throws SQLException, ClassNotFoundException{
		//编写数据库连接字符串
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//用户名
		String user = "scott";
		//密码
		String password ="tiger";
		
		//步骤一：加载驱动程序
		Class.forName("oracle.jdbc.OracleDriver");
		
		//步骤二：获取连接对象
		Connection con = DriverManager.getConnection(url, user, password);
		
		//步骤三：获取Statement对象
		Statement smt = con.createStatement();
		
		//步骤四：编写Sql语句
		String sql = "select * from teacher";
		
		//步骤五：执行Sql语句
		ResultSet rs = smt.executeQuery(sql);
		
		while(rs.next())
			System.out.println(rs.getString(1)+ "\t" + rs.getString("tname"));
	}
	
	/**
	 * 编码规范
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testClose() throws SQLException, ClassNotFoundException{
		//编写数据库连接字符串
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//用户名
		String user = "scott";
		//密码
		String password ="tiger";
		
		//步骤一：加载驱动程序
		Class.forName("oracle.jdbc.OracleDriver");
		
		//步骤二：获取连接对象
		Connection con = DriverManager.getConnection(url, user, password);
		
		//步骤三：获取Statement对象
		Statement smt = con.createStatement();
		
		//步骤四：编写Sql语句
		String sql = "select * from teacher";
		
		//步骤五：执行Sql语句
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
		//连接字符串
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		//用户名
		String user = "scott";
		//密码
		String pwd = "tiger";
		
		Connection con = null;
		Statement smt = null;
		ResultSet rs =null;
		
		try {
			//步骤一：加载驱动
			Class.forName("oracle.jdbc.OracleDriver");
			
			//步骤二：获取连接对象
			con =  DriverManager.getConnection(url, user, pwd);
			
			//步骤三：获取Statement对象
			smt = con.createStatement();
			
			//步骤四：编写Sql语句
			String sql = "select * from teacher";
			
			//步骤五：执行Sql语句
			rs =  smt.executeQuery(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//步骤六：释放资源
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
