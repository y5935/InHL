package cn.hl.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ����Session
 * @author Terry
 *
 */
public class WriteSession extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1������Session
		//���Session������(��ȡSession������Ϣʧ�ܣ��򴴽�һ��Session)
		//�������Session�򷵻�һ���͵�ǰ�����������Session(JSessionId)
		HttpSession session = req.getSession();
		
		//��ȡ��ǰSession��Id
		System.out.println("sessionId = " + session.getId());
		//��ȡ��ǰSession�Ƿ����´�����
		System.out.println("isNew = " + session.isNew());
		
		//2������Session��ֵ
		//session��ֵ���Լ�ָ�Ե���ʽ���ڵ�
		session.setAttribute("user", "Mike");
		//���session�������Ѿ����ڣ��ڴ�ʹ�û��滻ԭ��session��ֵ
		session.setAttribute("user", "Rose");
		
		//3������Session�Ĺ���ʱ�䣬����Ϊ��λ
		//�����ֵ����Ϊ0���ʾ��������
		//Session���ص㣺�����Session����ʱ��ﵽǰ�û��й��µ�����ʱ������ʱ�佫���¼���
		
		//����ʱ�����÷�ʽ�����뷽ʽ�������ļ���Tomcat >> conf >> web.xml >> session-configure.��λ�����ӣ�
		session.setMaxInactiveInterval(20);
		
		//4��ʹSessionʧЧ
		//sessionʹ�޷�ֱ��ɾ���ģ�ֻ�ܹ��ڻ�ʧЧ
		session.invalidate();
		
		//5���Ƴ���ǰSession�е�һ������ֵ����ֵ�ԣ�
		session.removeAttribute("user");
		
		
		/*
		//��ȡCookie�е�SessionId
		Cookie[] cookies = req.getCookies();
		if(cookies == null)
			System.out.println("�������κ�Cookie");
		else
			for(int i=0;i<cookies.length;i++){
				System.out.println(cookies[i].getName() + " +=+ " + cookies[i].getValue());
			}
		*/
	}

}
