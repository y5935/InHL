package cn.hl.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 需要继承于TagSupport
 * @author Terry
 *
 */
public class ShowInfo extends TagSupport{
	//属性，对应于配置文件的attribute
	private String name;
	private boolean other;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOther(boolean other){
		this.other = other;
	}


	/**
	 * 控制标签后的内容的显示方式
	 * 	EVAL_PAGE		：正常显示标签后的内容
	 * 	SKIP_PAGE		：忽略标签后内容的显示
	 */
	@Override
	public int doEndTag() throws JspException {
		System.out.println("do End Tag......");
		
		if(other){
			return EVAL_PAGE;
		}
		else{
			return SKIP_PAGE;
		}
	}

	/**
	 * 控制标签中的内容的显示方式
	 * 	EVAL_BODY_INCLUDE	：包含标签的内容（将标签中间内容添加到输出流中）
	 * 	SKIP_BODY			：忽略标签的内容（不进行输出）
	 */
	@Override
	public int doStartTag() throws JspException {
		System.out.println("do start Tag......");
		
		if("baidu".equals(name))
			return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY; 
		
	}
	
}
