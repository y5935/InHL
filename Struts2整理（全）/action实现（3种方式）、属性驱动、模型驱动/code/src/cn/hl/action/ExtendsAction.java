package cn.hl.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 继承方式实现Action
 * 	通过继承ActionSupport类进行实现
 * 
 * 	优点:
 * 		可以直接继承父类的非私有成员,达到最少代码实现Action
 * 	缺点:
 * 		具有侵入性,同时会继承父类所有非私有成员(这些成员不一定都被使用)
 * 	官方推荐方式
 * @author Terry
 *
 */
public class ExtendsAction extends ActionSupport{

}
