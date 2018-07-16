package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.bean.User;
import cn.hl.db.BaseDao;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("content-type", "text/html;charset=utf-8");
		
		//获取请求参数
		String account = req.getParameter("account");
		String pwd = req.getParameter("pwd");
		
		//执行登录验证
		//a、编写SQL语句
		String sql = "select * from users where account=?";
		//b、创建Dao对象
		BaseDao dao = new BaseDao();
		//c、执行命令
		List<User> list = dao.executeQuery(User.class, sql, account);
		
		//如果list集合中不包含任何则表示account无效(1表示账号错误)
		if(list.size()<1)
			resp.getWriter().print("1");
		else{
			for(User u:list){
				//如果密码匹配成功则返回2（表示登录成功）
				if(pwd.equals(u.getPwd())){
					//数据添加到缓冲区
					req.getSession().setAttribute("user", u);
					resp.getWriter().print("2");
					return;
				}
			}
			//如果所有用户的密码都匹配失败，则返回-1
			resp.getWriter().print("-1");
		}
		
	}

}
