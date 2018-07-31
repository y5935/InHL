package cn.hl.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class CounterListener implements HttpSessionAttributeListener{

	/**
	 * 增加在线人数
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		//获取Application对象
		ServletContext  context = se.getSession().getServletContext();
		//获取Application对象中属性值
		Object obj = context.getAttribute("count");
		//判断属性值是否存在
		if(obj == null)
			context.setAttribute("count", 1);
		else{
			int count = (Integer)context.getAttribute("count");
			context.setAttribute("count",count+1 );
		}
	}
	
	/**
	 * 减少在线人数
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		//获取Application对象
		ServletContext context = se.getSession().getServletContext();
		// 获取Application对象中属性值
		Object obj = context.getAttribute("count");
		// 判断属性值是否存在
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
