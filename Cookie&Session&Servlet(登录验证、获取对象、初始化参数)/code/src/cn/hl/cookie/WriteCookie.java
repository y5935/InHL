package cn.hl.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 向客户端写入Cookie
 * @author Terry
 *
 */
public class WriteCookie extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、创建Cookie
		Cookie c1 = new Cookie("c1",new Date().toLocaleString());
		Cookie c2 = new Cookie("c2",new Date().toLocaleString());
		Cookie c3 = new Cookie("c3",new Date().toLocaleString());
		Cookie c4 = new Cookie("c4",new Date().toLocaleString());
		Cookie c5 = new Cookie("c5",new Date().toLocaleString());
		
		//2、设置Cookie的过期时间
		//setMaxAge（）的参数如果为负值则表示Cookie不被存储（浏览器关闭则Cookie立即删除）
		//超过过期时间的Cookie会被立即删除
		//-1为默认值
		//setMaxAge（）参数的单位为秒
		c2.setMaxAge(-1);
		//设置C3的过期时间为90秒
		c3.setMaxAge(90);
		//设置C4的过期时间为一周
		c4.setMaxAge(60*60*24*7);
		//设置C5的过期时间和可访问路径
		c5.setMaxAge(60*60*24*7);
		
		//3、设置Cookie的访问路径
		//设置只有指定路径下的资源可以访问当前Cookie
		//路径格式：/项目名/路径/资源名
		c5.setPath("/03CookieServlet/car/rc2");
		
		//4、将Cookie添加到Response（发送给客户端）
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3);
		resp.addCookie(c4);
		resp.addCookie(c5);
		
		System.out.println("Cookie创建成功......");
	}

}
