package cn.hl.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ͻ���д��Cookie
 * @author Terry
 *
 */
public class WriteCookie extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1������Cookie
		Cookie c1 = new Cookie("c1",new Date().toLocaleString());
		Cookie c2 = new Cookie("c2",new Date().toLocaleString());
		Cookie c3 = new Cookie("c3",new Date().toLocaleString());
		Cookie c4 = new Cookie("c4",new Date().toLocaleString());
		Cookie c5 = new Cookie("c5",new Date().toLocaleString());
		
		//2������Cookie�Ĺ���ʱ��
		//setMaxAge�����Ĳ������Ϊ��ֵ���ʾCookie�����洢��������ر���Cookie����ɾ����
		//��������ʱ���Cookie�ᱻ����ɾ��
		//-1ΪĬ��ֵ
		//setMaxAge���������ĵ�λΪ��
		c2.setMaxAge(-1);
		//����C3�Ĺ���ʱ��Ϊ90��
		c3.setMaxAge(90);
		//����C4�Ĺ���ʱ��Ϊһ��
		c4.setMaxAge(60*60*24*7);
		//����C5�Ĺ���ʱ��Ϳɷ���·��
		c5.setMaxAge(60*60*24*7);
		
		//3������Cookie�ķ���·��
		//����ֻ��ָ��·���µ���Դ���Է��ʵ�ǰCookie
		//·����ʽ��/��Ŀ��/·��/��Դ��
		c5.setPath("/03CookieServlet/car/rc2");
		
		//4����Cookie��ӵ�Response�����͸��ͻ��ˣ�
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3);
		resp.addCookie(c4);
		resp.addCookie(c5);
		
		System.out.println("Cookie�����ɹ�......");
	}

}
