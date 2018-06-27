package cn.hl.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuperServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service() is do......");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() is do......");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(´ø²Î) is do......");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() is do......");
	}

	
	
}
