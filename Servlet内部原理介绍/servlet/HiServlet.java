package cn.hl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet就是一个特殊的Java类
 * Servlet继承于HttpServlet
 * 重写快捷键:ctrl + shift + r
 * @author Terry
 *
 */
public class HiServlet extends HttpServlet{

	/**
	 * 重写父类(HttpServlet)的service()方法
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		//输出HiServlet is do......
		System.out.println("HiServlet is do......");
	}

}
