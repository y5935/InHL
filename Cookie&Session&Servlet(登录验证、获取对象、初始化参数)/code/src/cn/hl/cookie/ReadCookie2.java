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
		//��ȡCookie
		Cookie[] cookies = req.getCookies();
		
		//�ж������Ƿ�Ϊ��
		if(cookies == null){
			System.out.println("[RC2]ϵͳ�ڲ������κ�Cookie");
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
