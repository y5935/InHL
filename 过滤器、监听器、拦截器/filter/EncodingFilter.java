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
	 * ��ȡ��ʼ������
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encode")!= null)
			encode = filterConfig.getInitParameter("encode");
	}

	/**
	 * ִ�й��˲���
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//��������ı����ʽ
		request.setCharacterEncoding(encode);
		//������Ӧ�ı����ʽ
		response.setCharacterEncoding(encode);
		response.setContentType("text/html;charset=" + encode);
		
		chain.doFilter(request, response);		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
