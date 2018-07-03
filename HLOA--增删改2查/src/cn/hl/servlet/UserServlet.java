package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.bean.User;
import cn.hl.dao.UserDao;

public class UserServlet extends HttpServlet {
	UserDao dao = new UserDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取操作类型（op）
		String op = req.getParameter("op");
		
		if("add".equals(op)){
			add(req,resp);
		}
		else if("load".equals(op)){
			load(req,resp);
			return;
		}
		else if("update".equals(op)){
			update(req,resp);
		}
		else if("del".equals(op)){
			delete(req,resp);
		}
		else if("find".equals(op)){
			find(req,resp);
			return;
		}
		
		getAll(req,resp);
	}

	/**
	 * 执行多条件查询
	 * 支持模糊查询
	 * 获取请求参数 -->执行查询操作 -->数据存储到作用域 -->跳转回list.jsp
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求参数
		String name = req.getParameter("name");
		
		//查询数据
		List<User> list = dao.getByName(name);
		System.out.println(list);
		
		//数据存储到作用域
		req.setAttribute("list", list);
		//跳转回list.jsp页面
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

	/**
	 * 按Id删除用户信息
	 * 获取请求参数 -->执行删除操作 --> 跳转回list.jsp页面
	 * @param req
	 * @param resp
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		
		//执行删除操作
		dao.delete(id);
	}

	/**
	 * 按照Id更新指定的数据
	 * 获取请求参数 --> 数据存储到数据库 --> 跳转回list.jsp页面
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		//获取请求参数
		User user = new User();
		user.setAccount(req.getParameter("account"));
		user.setPwd(req.getParameter("pwd"));
		user.setUserName(req.getParameter("userName"));
		user.setUserId(Integer.parseInt(req.getParameter("userId")));
		
		//保存数据到数据库
		dao.update(user);
	}

	/**
	 * 按照Id读取用户信息
	 * 读取用户信息 -->存储到作用域 --> 跳转到edit.jsp
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void load(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("id")!= null){
			User user = dao.getById(req.getParameter("id"));
			if(user != null){
				req.setAttribute("user", user);
				req.getRequestDispatcher("edit.jsp").forward(req, resp);
			}
			else{
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
		}
	}

	/**
	 * 添加用户信息到数据表
	 * 	获取请求参数 --> 将数据保存到数据库 -->跳转回list.jsp页面
	 * @param req
	 * @param resp
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		//获取请求参数
		User user = new User();
		user.setAccount(req.getParameter("account"));
		user.setPwd(req.getParameter("pwd"));
		user.setUserName(req.getParameter("userName"));
		
		//将数据插入到数据表中
		dao.add(user);		
	}

	/**
	 * 获取所有用户的列表
	 * 获取数据列表 --> 数据存储到作用域 -->跳转到list.jsp
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户列表
		List<User> list = dao.getAll();
		
		//将数据添加到作用域中
		req.setAttribute("list", list);

		//请求跳转到list.jsp页面
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

}
