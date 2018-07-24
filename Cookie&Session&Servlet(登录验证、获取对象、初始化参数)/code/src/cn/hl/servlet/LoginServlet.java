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
		//��ȡ�û��ύ���˺ź�����
		String account = req.getParameter("account");
		String pwd = req.getParameter("pwd");
		
		//ͨ��Jdbcִ�е�¼��֤
		if(checkUser(account,pwd,req))
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	/**
	 * ִ�е�¼��֤
	 * @param account
	 * @param pwd
	 */
	private boolean checkUser(String account, String pwd,HttpServletRequest req) {
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "123";
		
		boolean result = false;
		
		try {
			//1����������
			Class.forName("com.mysql.jdbc.Driver");
			
			//2����ȡ���Ӷ���
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3����ȡPreparedStatement����
			String sql = "select * from users where account=? and pwd=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//4������ps��������Ĳ���
			ps.setString(1, account);
			ps.setString(2, pwd);
			
			//5��ִ��SQL���
			ResultSet rs = ps.executeQuery();
			result = rs.next();
			//�ж�Result�Ƿ�Ϊtrue
			if(result){
				//����û���¼�ɹ�������û���������ӵ�Session��
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
