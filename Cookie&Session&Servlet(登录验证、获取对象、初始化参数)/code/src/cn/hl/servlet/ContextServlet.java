package cn.hl.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、获取对象
		//方式一(推荐使用。一般在Servlet中使用)
		ServletContext c1 = this.getServletContext();		
		//方式二
		ServletContext c2 = this.getServletConfig().getServletContext();		
		//方式三
		ServletContext c3 = req.getSession().getServletContext();		
		//方式四
		ServletContext c4 = req.getServletContext();
		
		System.out.println(c1 == c2 && c1 == c3 && c1 == c4);
		
		//2、读取配置参数
		String ip = c1.getInitParameter("ip");
		System.out.println("ip = " + ip);
		
		//3、获取指定路径对应的物理路径
		//文件上传、下载时经常使用
		String path = c2.getRealPath("/");
		System.out.println("path =" + path);
		
		//4、获取指定文件的IO流
		InputStream is = c3.getResourceAsStream("/index.jsp");
		System.out.println(is);		
	}

}
