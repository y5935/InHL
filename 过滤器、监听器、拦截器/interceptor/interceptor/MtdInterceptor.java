package cn.hl.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 方法拦截器
 * @author Terry
 *
 */
public class MtdInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("Method Inteceptor is do......");
		return invocation.invoke();
	}

}
