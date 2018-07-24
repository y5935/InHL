package cn.hl.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȡCookie
 * @author Terry
 *
 */
public class ReadCookie extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡCookie
		Cookie[] cookies = req.getCookies();
		
		//���Cookie����
		if(cookies != null){
			//����cookies���鼯��
			for(int i = 0;i<cookies.length;i++){
				//�õ���ǰcookies�����е�Cookie����
				Cookie c = cookies[i];
				
				//���Cookie�����ֺ�ֵ
				System.out.println(c.getName() + " = " + c.getValue());
			}
		}
		else{
			System.out.println("��ǰϵͳ�в������κ�Cookie");
		}
		
	}

}
