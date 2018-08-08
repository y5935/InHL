package cn.hl.action;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

/**
 * 耦合的方式
 * 	需要实现ServletRequestAware(或ServletContextAware)
 * 	步骤：
 * 		1、创建类并实现于ServletRequestWare接口
 * 		2、创建私有成员对象req
 * 		3、实现接口方法
 * 		4、创建请求处理方法
 * 
 * @author Terry
 *
 */
public class ApiAction2 implements ServletRequestAware{
	//HttpServletRequest类型的成员对象
	private HttpServletRequest req;
	
	//为成员对象赋值
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.req = request;		
	}

	//请求处理方法
	public String api3(){
		//1、获取Session
		HttpSession session = req.getSession();
		
		//2、获取Cookie
		Cookie[] cookies = req.getCookies();
		
		//3、获取Application
		ServletContext application = req.getServletContext();
		
		//4、获取请求参数
		String name = req.getParameter("name");	
		
		return "success";
	}
}
