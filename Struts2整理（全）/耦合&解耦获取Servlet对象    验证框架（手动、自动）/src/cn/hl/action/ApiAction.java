package cn.hl.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

public class ApiAction {
	/**
	 * 解耦方式一：
	 * 	通过ActionContext对象的getContext()获取Servlet对象
	 * @return
	 */
	public String api1(){
		//1、设置Session
		//Session中的数据是以键值对的形式存在的
		Map<String,Object> session = ActionContext.getContext().getSession();
		//将键值对存储到Map集合中
		session.put("user", "Mike");
		session.put("age", 20);
		//将Session添加到ActionContext中
		ActionContext.getContext().setSession(session);
				
		//2、Application
		Map<String,Object> application = ActionContext.getContext().getApplication();
		//设置Application的值
		application.put("count", "100");
		ActionContext.getContext().setApplication(application);
	
		
		//3、获取parameter(URL地址中的请求参数)
		//http://localhost:8080/03ServletAPI/api1.action?name=Mike&age=20&gender=true
		Map<String,Object> parameters = ActionContext.getContext().getParameters();
		//获取Key的集合
		Set<String> keys = parameters.keySet();
		//获取set的迭代器
		Iterator<String> iterator = keys.iterator();
		//遍历迭代器
		while(iterator.hasNext()){
			//获取key的值
			String key = iterator.next();
			System.out.println(key + " = " + parameters.get(key));
		}
		
		//4、request
		Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
		
		return "success";
	}
	
	/**
	 * 解耦方式二：
	 * 	StrutsStatics中定义了常用对象的字符串（字符串内容是类的完整名称）
	 * @return
	 * @throws IOException 
	 */
	public String api2() throws IOException{
		//1、获取Request对象
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		
		//通过Request对象获取Session对象
		HttpSession session = req.getSession();
		
		//通过Request对象获取application对象
		ServletContext application = req.getServletContext();
		
		//通过Reqeust对象获取请求参数
		String name = req.getParameter("name");
		
		
		//2、获取Response对象
		HttpServletResponse resp = (HttpServletResponse)ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
		resp.getWriter().print("abvc");
		
		return "success";
	}
}
