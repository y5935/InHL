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
		//1����ȡ����
		//��ʽһ(�Ƽ�ʹ�á�һ����Servlet��ʹ��)
		ServletContext c1 = this.getServletContext();		
		//��ʽ��
		ServletContext c2 = this.getServletConfig().getServletContext();		
		//��ʽ��
		ServletContext c3 = req.getSession().getServletContext();		
		//��ʽ��
		ServletContext c4 = req.getServletContext();
		
		System.out.println(c1 == c2 && c1 == c3 && c1 == c4);
		
		//2����ȡ���ò���
		String ip = c1.getInitParameter("ip");
		System.out.println("ip = " + ip);
		
		//3����ȡָ��·����Ӧ������·��
		//�ļ��ϴ�������ʱ����ʹ��
		String path = c2.getRealPath("/");
		System.out.println("path =" + path);
		
		//4����ȡָ���ļ���IO��
		InputStream is = c3.getResourceAsStream("/index.jsp");
		System.out.println(is);		
	}

}
