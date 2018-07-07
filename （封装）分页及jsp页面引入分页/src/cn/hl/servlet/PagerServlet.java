package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.bean.User;
import cn.hl.common.Pager;
import cn.hl.db.BaseDao;

public class PagerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BaseDao dao = new BaseDao();
		//获取总记录数
		int rows = dao.getRows("users");
		//获取PageSize
		int pageSize =2;
		
		//获取当前页索引
		int index = (req.getParameter("index")==null) ? 1: Integer.parseInt(req.getParameter("index"));
		
		//创建分页对象
		Pager page = new Pager(rows, pageSize, index);
		
		//查询数据
		String sql = "select * from users limit ?,?";
		List<User> list = dao.executeQuery(User.class, sql, page.getOffSet(),page.getPageSize());
		
		//设置分页数据
		page.setList(list);
		
		//将对象存储到缓冲区
		req.setAttribute("page", page);
		
		//执行页面跳转
		req.getRequestDispatcher("list2.jsp").forward(req, resp);
	}

}
