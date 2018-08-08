
package cn.hl.action;

import cn.hl.bean.User;

import com.opensymphony.xwork2.Action;



/**
 * 属性驱动方式获取表单数据（自定义类型作为属性）
 * 
 * 	将表单提交的数据以Action属性（成员字段）的形式进接收
 * 
 * 注意：如果是引用类型作为属性值，不需要进行实例化
 *
 * @author Terry
 *
 */
public class UserAction2 implements Action{
	private User user;	// = new User();
	
	/**
	 * 请求处理方法
	 */
	@Override
	public String execute(){
		System.out.println(user);
		System.out.println("==========================================\n");
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
