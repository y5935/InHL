package cn.hl.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReadSession extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取Session对象
		HttpSession session = req.getSession();
		
		//读取Session的值
		String user = (String)session.getAttribute("user");
		System.out.println("[R]user = " + user);
		
	}

}
