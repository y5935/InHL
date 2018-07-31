package cn.hl.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class CounterListener implements HttpSessionAttributeListener{

	/**
	 * ������������
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		//��ȡApplication����
		ServletContext  context = se.getSession().getServletContext();
		//��ȡApplication����������ֵ
		Object obj = context.getAttribute("count");
		//�ж�����ֵ�Ƿ����
		if(obj == null)
			context.setAttribute("count", 1);
		else{
			int count = (Integer)context.getAttribute("count");
			context.setAttribute("count",count+1 );
		}
	}
	
	/**
	 * ������������
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		//��ȡApplication����
		ServletContext context = se.getSession().getServletContext();
		// ��ȡApplication����������ֵ
		Object obj = context.getAttribute("count");
		// �ж�����ֵ�Ƿ����
		if (obj == null)
			context.setAttribute("count", 0);
		else {
			int count = (Integer) context.getAttribute("count");
			context.setAttribute("count", count -1);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

}
