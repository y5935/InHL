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
	 * ��ȡUser���ݲ�תΪJson��ʽ
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��дSQL���
		String sql = "select * from users";
		BaseDao dao = new BaseDao();
		List<User> list = dao.executeQuery(User.class, sql);
		
		//����תΪJson��ʽ
		Gson g = new Gson();
		String str = g.toJson(list);
		
		//���ݷ��ͻ�Ajax
		resp.getWriter().print(str);
	}

}
