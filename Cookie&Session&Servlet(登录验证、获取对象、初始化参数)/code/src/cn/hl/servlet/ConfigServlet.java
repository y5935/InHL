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
		//��ȡServletConfig����
		//ͨ���ö�����Ի�ȡ��Servlet�ĳ�ʼ������
		ServletConfig config = this.getServletConfig();
		
		//��ȡ��ʼ������
		String str = config.getInitParameter("eMail");
		System.out.println(str);
	}

}
