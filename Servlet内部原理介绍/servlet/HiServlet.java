package cn.hl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet����һ�������Java��
 * Servlet�̳���HttpServlet
 * ��д��ݼ�:ctrl + shift + r
 * @author Terry
 *
 */
public class HiServlet extends HttpServlet{

	/**
	 * ��д����(HttpServlet)��service()����
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		//���HiServlet is do......
		System.out.println("HiServlet is do......");
	}

}
