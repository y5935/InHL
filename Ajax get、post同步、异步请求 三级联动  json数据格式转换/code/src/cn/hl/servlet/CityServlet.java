package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.hl.bean.City;
import cn.hl.db.BaseDao;

public class CityServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("content-type", "text/html/charset=utf-8");
		
		//创建BaseDao对象
		BaseDao dao = new BaseDao();
		
		//编写SQL语句
		String sql = "select * from city where pid=?";
		
		String pid=(req.getParameter("pid")==null) ? "0" :req.getParameter("pid");
		
		List<City> list = dao.executeQuery(City.class, sql,pid);
		
		//将List集合转为Json对象
		Gson g = new Gson();
		String json = g.toJson(list);
		
		//响应Ajax的请求
		resp.getWriter().print(json);
	}

}
