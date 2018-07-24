package cn.hl.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//读取Cookie
		Cookie[] cookies = req.getCookies();
		
		//判断数组是否为空
		if(cookies == null){
			System.out.println("[RC2]系统内不包含任何Cookie");
		}
		else{
			System.out.println("======================[RC2]==========================");
			for(int i = 0;i<cookies.length;i++){
				Cookie c = cookies[i];
				
				System.out.println(c.getName() + " =============== " + c.getValue());
			}
		}
	}

}
