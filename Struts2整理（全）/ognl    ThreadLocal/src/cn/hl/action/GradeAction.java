package cn.hl.action;

import java.util.Map;

import cn.hl.bean.Grade;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 通过OGNL读取数据
 * @author Terry
 *
 */
public class GradeAction {
	public String ognl(){
		//1、数据存储到ValueStack中
		//1)、获取ValueStack对象
		ValueStack stack = ActionContext.getContext().getValueStack();
		
		stack.set("str","Hello Ognl");
		
		//2)、创建grade对象
		Grade g = new Grade("1","精英101");
		stack.set("g", g);
		
		//2、数据存储到Context中
		//1)、数据存储到ContextMap中
		ActionContext context = ActionContext.getContext();
		context.getContextMap().put("g1", new Grade("2","精英102(ContextMap)"));
	
		//2)、数据存储到Session中
		context.getSession().put("g2", new Grade("3","精英103(session)"));
		
		//3)、数据存储到application中
		context.getApplication().put("g3", new Grade("4","精英104(application)"));
		
		return "success";
	}
}
