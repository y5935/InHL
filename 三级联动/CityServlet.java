package cn.hl.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.bean.City;
import cn.hl.util.DBUtil;

import com.google.gson.Gson;

public class CityServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		resp.setCharacterEncoding("utf-8");
		DBUtil db = new DBUtil();
		
		//获取请求参数
		String id = (req.getParameter("pId") != null) ? req.getParameter("pId"):"0";
		
		System.out.println(id);
		//编写Sql语句
		String sql = "select * from sys_city where pid=?";
		//执行Sql语句
		ResultSet rs = db.executeQuery(sql, id);
		
		//创建结合对象存储城市数据
		List<City> list = new ArrayList<City>();
		try {
			while(rs.next()){
				City c = new City();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setpId(rs.getInt("pid"));
				
				//将对象添加到list集合中
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			db.close();
		}
		
		//将数据转为Json格式
		Gson g = new Gson();
		String result = g.toJson(list);
		
		//将数据发送回前台
		resp.getWriter().write(result);
	}

}
