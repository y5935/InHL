package cn.hl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service is do......");
		
		//设置请求的编码格式
		req.setCharacterEncoding("utf-8");
		
		
		String id = req.getParameter("id");
		int param = Integer.parseInt(id);
		
		//响应客户端Ajax的请求
		//只能通过Writer的pring()方法进行响应
		if(param >10)
			resp.getWriter().print("true");
		else
			resp.getWriter().print("false");
		
		
		/*
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//输出参数信息
		/*
		String name= req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println();
		*/
		//req.getRequestDispatcher("non-js.jsp").forward(req, resp);
	}

}
