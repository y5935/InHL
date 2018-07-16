package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.bean.User;
import cn.hl.db.BaseDao;

public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean result = false;
		//获取请求参数
		String op = req.getParameter("op");
		String account = req.getParameter("account");
		
		//通过数据库验证账号是否存在
		if("check".equals(op)){
			BaseDao dao = new BaseDao();
			
			//编写SQL语句
			String sql = "select * from users where account=?";
			//执行SQL语句
			List<User> list = dao.executeQuery(User.class, sql, account);
			result = list.size()>0;
		}
		
		//响应Ajax的请求
		resp.getWriter().print(result);
	}

}
