package cn.hl.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取ServletConfig对象
		//通过该对象可以获取到Servlet的初始化参数
		ServletConfig config = this.getServletConfig();
		
		//获取初始化参数
		String str = config.getInitParameter("eMail");
		System.out.println(str);
	}

}
