package cn.hl.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimeInterceptor extends AbstractInterceptor{
	
	/**
	 * 拦截器的处理方法
	 * invoke将调用下一个拦截器的请求处理方法。如果后续没有拦截器，则将调用Action的请求处理方法进行执行。
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//请求处理方法执行前调用
		//System.out.println("before:TimeInterceptor is do......");
		Long begin = System.currentTimeMillis();
		
		//调用请求处理方法
		String result = invocation.invoke();
		
		//请求处理方法执行后调用
		System.out.println("after:TimeInterceptor is do......");
		Long end = System.currentTimeMillis();
		
		String name = invocation.getProxy().getActionName();
		System.out.println(name + "执行用时：" + (end - begin));
		
		return result;
	}
}
