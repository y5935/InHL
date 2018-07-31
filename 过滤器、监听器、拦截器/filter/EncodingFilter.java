package cn.hl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encode="utf-8";
	
	/**
	 * 读取初始化参数
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encode")!= null)
			encode = filterConfig.getInitParameter("encode");
	}

	/**
	 * 执行过滤操作
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//设置请求的编码格式
		request.setCharacterEncoding(encode);
		//设置响应的编码格式
		response.setCharacterEncoding(encode);
		response.setContentType("text/html;charset=" + encode);
		
		chain.doFilter(request, response);		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
