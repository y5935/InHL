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
	 * 执行登录验证
	 * 	验证依据：
	 * 		1、Session中是否具有user属性
	 * 		2、user属性的值是否为null
	 *	特殊情况
	 *		1、如果请求的资源为login.jsp则不需要验证
	 *		2、如果请求是执行登录验证则不需要验证
	 *	操作
	 *		同过验证继续请求
	 *		验证失败条转回登录页面
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取请求资源的信息(/Mng/ , /Mng/user(判断是否包含op参数)
		HttpServletRequest req = (HttpServletRequest)request;
		
		String uri = req.getRequestURI();
		String op = (req.getParameter("op") == null) ? "" : req.getParameter("op");
		
		
		System.out.println(uri + " | " + op);
		//直接访问登录界面
		if("/Mng/".equals(uri) || uri.endsWith("login.jsp")){
			chain.doFilter(request, response);
		}
		//请求user执行登录验证
		else if(uri.endsWith("user") && "login".equals(op)){
			chain.doFilter(request, response);
		} 
		else{
			//如果请求的资源不是登录页面，也不是执行登录验证
			//检查session
			//获取Session
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
