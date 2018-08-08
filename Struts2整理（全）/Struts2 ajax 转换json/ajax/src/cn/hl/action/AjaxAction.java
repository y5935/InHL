package cn.hl.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * ServletApi实现Ajax
 * @author Terry
 *
 */
public class AjaxAction {
	private int id;
	
	/**
	 * 请求处理方法
	 * @return
	 * @throws IOException
	 */
	public String execute() throws IOException{
		//通过ServletApi获取Response对象
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		//通过Response对象进行响应
		if(id>0){
			resp.getWriter().print("Yes");
		}
		else{
			resp.getWriter().print("No");
		}
		
		//对于Ajax的响应只能通过Response对象进行
		//所以返回值设置为null
		return null;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
}
