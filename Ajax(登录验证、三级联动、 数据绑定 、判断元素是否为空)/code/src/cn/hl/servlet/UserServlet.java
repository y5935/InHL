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
		//��ȡ�������
		String op = req.getParameter("op");
		String account = req.getParameter("account");
		
		//ͨ�����ݿ���֤�˺��Ƿ����
		if("check".equals(op)){
			BaseDao dao = new BaseDao();
			
			//��дSQL���
			String sql = "select * from users where account=?";
			//ִ��SQL���
			List<User> list = dao.executeQuery(User.class, sql, account);
			result = list.size()>0;
		}
		
		//��ӦAjax������
		resp.getWriter().print(result);
	}

}
