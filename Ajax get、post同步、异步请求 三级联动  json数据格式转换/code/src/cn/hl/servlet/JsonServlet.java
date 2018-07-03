package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.hl.bean.User;
import cn.hl.db.BaseDao;

public class JsonServlet extends HttpServlet {

	/**
	 * Json:javascript object notation。简称为Javascript对象简谱
	 * Json是一种轻量级的数据交换格式。一种独立于语言的文本格式
	 * Json格式可以有效的提高网络的传输效率，同时可以跨平台
	 * Json的数据都是以键值对的形式存在的
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//通过Dao对象查询数据
		BaseDao dao = new BaseDao();
		
		//编写SQL语句
		String sql = "select * from users";
		List<User> list = dao.executeQuery(User.class, sql);
		
		
		
		//响应Ajax请求
		if(list.size()>0){
			//获取第一个元素
			User u = list.get(0);
			//工具类，提供了Json格式转换的相关方法
			Gson g = new Gson();
			String json = g.toJson(u);
			
			//处理单一对象
			System.out.println(json);
			resp.getWriter().print(json);
			
			/*
			//处理集合对象
			String json2 = g.toJson(list);
			System.out.println(json2);
			*/
		}
		else
			resp.getWriter().print("");
		
	}

}
