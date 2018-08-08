package cn.hl.action;

import cn.hl.bean.User;

import com.opensymphony.xwork2.ModelDriven;

/**
 * 模型驱动
 * 	必须实现ModelDriven接口
 * 	成员字段必须进行实例化
 * 	必须完成get访问器
 * @author Terry
 *
 */
public class UserAction3 implements ModelDriven<User>{
	//必须进行实例化
	private User user = new User();
	
	//只有get（没有set）
	@Override
	public User getModel() {
		return user;
	}

	
	public String execute(){
		System.out.println(user);
		return "success";
	}
	

}
