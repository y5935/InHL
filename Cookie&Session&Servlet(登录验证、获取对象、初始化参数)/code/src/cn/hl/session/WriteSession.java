package cn.hl.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 创建Session
 * @author Terry
 *
 */
public class WriteSession extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、创建Session
		//如果Session不存在(读取Session关联信息失败，则创建一个Session)
		//如果存在Session则返回一个和当前请求相关联的Session(JSessionId)
		HttpSession session = req.getSession();
		
		//获取当前Session的Id
		System.out.println("sessionId = " + session.getId());
		//获取当前Session是否是新创建的
		System.out.println("isNew = " + session.isNew());
		
		//2、保存Session的值
		//session的值是以键指对的形式存在的
		session.setAttribute("user", "Mike");
		//如果session的名称已经存在，在此使用会替换原有session的值
		session.setAttribute("user", "Rose");
		
		//3、设置Session的过期时间，以秒为单位
		//如果其值设置为0则表示永不过期
		//Session的特点：如果在Session过期时间达到前用户有过新的请求时，过期时间将重新计算
		
		//过期时间设置方式：代码方式、配置文件（Tomcat >> conf >> web.xml >> session-configure.单位：分钟）
		session.setMaxInactiveInterval(20);
		
		//4、使Session失效
		//session使无法直接删除的，只能过期或失效
		session.invalidate();
		
		//5、移除当前Session中的一个属性值（键值对）
		session.removeAttribute("user");
		
		
		/*
		//读取Cookie中的SessionId
		Cookie[] cookies = req.getCookies();
		if(cookies == null)
			System.out.println("不存在任何Cookie");
		else
			for(int i=0;i<cookies.length;i++){
				System.out.println(cookies[i].getName() + " +=+ " + cookies[i].getValue());
			}
		*/
	}

}
