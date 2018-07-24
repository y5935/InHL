package cn.hl.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 读取Cookie
 * @author Terry
 *
 */
public class ReadCookie extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//读取Cookie
		Cookie[] cookies = req.getCookies();
		
		//输出Cookie数组
		if(cookies != null){
			//遍历cookies数组集合
			for(int i = 0;i<cookies.length;i++){
				//得到当前cookies集合中的Cookie对象
				Cookie c = cookies[i];
				
				//输出Cookie的名字和值
				System.out.println(c.getName() + " = " + c.getValue());
			}
		}
		else{
			System.out.println("当前系统中不存在任何Cookie");
		}
		
	}

}
