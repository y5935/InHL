package cn.hl.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.hl.bean.User;

public class Servlet01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(new Date().toLocaleString() + ": servet01被调用了......");
		System.out.println("id= " + req.getParameter("id"));
		//resp.getWriter().write("OK");
		
		User u = new User(1,"Mike",true);
		Gson g = new Gson();
		String result = g.toJson(u);
		
		resp.getWriter().write(result);
	}

}
