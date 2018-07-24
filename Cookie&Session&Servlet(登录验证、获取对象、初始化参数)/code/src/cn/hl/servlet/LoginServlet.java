package cn.hl.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取用户提交的账号和密码
		String account = req.getParameter("account");
		String pwd = req.getParameter("pwd");
		
		//通过Jdbc执行登录验证
		if(checkUser(account,pwd,req))
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	/**
	 * 执行登录验证
	 * @param account
	 * @param pwd
	 */
	private boolean checkUser(String account, String pwd,HttpServletRequest req) {
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "123";
		
		boolean result = false;
		
		try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2、获取连接对象
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3、获取PreparedStatement对象
			String sql = "select * from users where account=? and pwd=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//4、设置ps对象所需的参数
			ps.setString(1, account);
			ps.setString(2, pwd);
			
			//5、执行SQL语句
			ResultSet rs = ps.executeQuery();
			result = rs.next();
			//判断Result是否为true
			if(result){
				//如果用户登录成功，则把用户的姓名添加到Session中
				HttpSession session = req.getSession();
				
				System.out.println(rs.getString("userName"));
				session.setAttribute("user",rs.getString("userName"));
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	
}
