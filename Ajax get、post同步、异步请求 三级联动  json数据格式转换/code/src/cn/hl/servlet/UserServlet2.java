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

public class UserServlet2 extends HttpServlet {

	/**
	 * 读取User数据并转为Json格式
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//编写SQL语句
		String sql = "select * from users";
		BaseDao dao = new BaseDao();
		List<User> list = dao.executeQuery(User.class, sql);
		
		//数据转为Json格式
		Gson g = new Gson();
		String str = g.toJson(list);
		
		//数据发送回Ajax
		resp.getWriter().print(str);
	}

}
