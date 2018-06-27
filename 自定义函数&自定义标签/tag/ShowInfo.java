package cn.hl.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * ��Ҫ�̳���TagSupport
 * @author Terry
 *
 */
public class ShowInfo extends TagSupport{
	//���ԣ���Ӧ�������ļ���attribute
	private String name;
	private boolean other;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOther(boolean other){
		this.other = other;
	}


	/**
	 * ���Ʊ�ǩ������ݵ���ʾ��ʽ
	 * 	EVAL_PAGE		��������ʾ��ǩ�������
	 * 	SKIP_PAGE		�����Ա�ǩ�����ݵ���ʾ
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
	 * ���Ʊ�ǩ�е����ݵ���ʾ��ʽ
	 * 	EVAL_BODY_INCLUDE	��������ǩ�����ݣ�����ǩ�м�������ӵ�������У�
	 * 	SKIP_BODY			�����Ա�ǩ�����ݣ������������
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
