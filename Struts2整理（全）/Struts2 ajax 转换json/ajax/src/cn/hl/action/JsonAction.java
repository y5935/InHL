package cn.hl.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import cn.hl.bean.User;

public class JsonAction {
	//定义私有的JSONArray类型对象
	private JSONArray json;
	
	/**
	 * 请求处理方法
	 * @return
	 */
	public String list(){
		//创建集合对象
		/*
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"Mike",20));
		list.add(new User(2,"Jack",24));
		list.add(new User(3,"Tom",22));
		list.add(new User(4,"Jerry",20));
		*/
		
		User list = new User(1,"Mike",20);
		//将对象转为JSONArray类型的数据
		json = JSONArray.fromObject(list);
		
		return "success";
	}

	public JSONArray getJson() {
		return json;
	}

	public void setJson(JSONArray json) {
		this.json = json;
	}
}
