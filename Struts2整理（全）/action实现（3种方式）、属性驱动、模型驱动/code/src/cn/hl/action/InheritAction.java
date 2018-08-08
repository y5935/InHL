package cn.hl.action;

import com.opensymphony.xwork2.Action;

/**
 * 实现方式
 * 	创建类并实现Action接口
 * 
 *  优点：
 *  	具有一定的约束性，减少了错误的发生
 *  缺点：
 *  	通过实现的方式实现的Action，使类具有了侵入性，降低了代码的迁移性
 *  
 *  Action（接口）的成员
 *  	success		:表示Action执行成功，需要将结果展示给用户
 *  	none		:表示Action执行成功，但不需要象用户展示任何内容。如：下载功能
 *  	error		:表示Action执行失败，需要向用户展示一个错误视图
 *  	input		:表示需要跳转到输入表单时使用
 *  	login		:表示需要用户执行登录时使用
 * 
 * @author Terry
 *
 */
public class InheritAction implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("InheritAction.execute() is do......");
		//return null;
		return SUCCESS;
	}

}
