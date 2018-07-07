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
		//获取请求参数---index的值
		//当前页索引，默认值为1
		int index = ((req.getParameter("index")) == null) ? 1 : Integer.parseInt(req.getParameter("index"));
		
		System.out.println("index=" + index);
		
		//每页记录数，默认值为2
		int pageSize = 2;
		
		//创建BaseDao
		BaseDao dao = new BaseDao();
		
		//编写SQL语句
		String sql = "select * from users limit ?,?";
		
		//执行SQL语句
		List<User> list = dao.executeQuery(User.class, sql,(index-1) * pageSize,pageSize);
		
		//数据存储到作用域中
		req.setAttribute("list", list);
		
		//获取总记录数
		int rows = dao.getRows("users");		
		//获取每页记录数(假设每页2条记录)
		//int pageSize = 2;		
		//计算总页数
		int pages = (int)Math.ceil(rows * 1.0 /pageSize);
		//将总页数存储到作用域中
		req.setAttribute("pages", pages);
		
		//将当前页索引存储到作用域中
		req.setAttribute("index", index);
		
		//跳转到list.jsp页面
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	
	}

}
