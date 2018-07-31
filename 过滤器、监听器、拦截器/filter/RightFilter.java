package cn.hl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RightFilter implements Filter{
	
	/**
	 * ִ�е�¼��֤
	 * 	��֤���ݣ�
	 * 		1��Session���Ƿ����user����
	 * 		2��user���Ե�ֵ�Ƿ�Ϊnull
	 *	�������
	 *		1������������ԴΪlogin.jsp����Ҫ��֤
	 *		2�����������ִ�е�¼��֤����Ҫ��֤
	 *	����
	 *		ͬ����֤��������
	 *		��֤ʧ����ת�ص�¼ҳ��
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//��ȡ������Դ����Ϣ(/Mng/ , /Mng/user(�ж��Ƿ����op����)
		HttpServletRequest req = (HttpServletRequest)request;
		
		String uri = req.getRequestURI();
		String op = (req.getParameter("op") == null) ? "" : req.getParameter("op");
		
		
		System.out.println(uri + " | " + op);
		//ֱ�ӷ��ʵ�¼����
		if("/Mng/".equals(uri) || uri.endsWith("login.jsp")){
			chain.doFilter(request, response);
		}
		//����userִ�е�¼��֤
		else if(uri.endsWith("user") && "login".equals(op)){
			chain.doFilter(request, response);
		} 
		else{
			//����������Դ���ǵ�¼ҳ�棬Ҳ����ִ�е�¼��֤
			//���session
			//��ȡSession
			HttpSession session = req.getSession();
			if(session.getAttribute("user") == null)
				req.getRequestDispatcher("login.jsp").forward(request, response);
			else
				chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	
}
