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
		//��ȡ�������---index��ֵ
		//��ǰҳ������Ĭ��ֵΪ1
		int index = ((req.getParameter("index")) == null) ? 1 : Integer.parseInt(req.getParameter("index"));
		
		System.out.println("index=" + index);
		
		//ÿҳ��¼����Ĭ��ֵΪ2
		int pageSize = 2;
		
		//����BaseDao
		BaseDao dao = new BaseDao();
		
		//��дSQL���
		String sql = "select * from users limit ?,?";
		
		//ִ��SQL���
		List<User> list = dao.executeQuery(User.class, sql,(index-1) * pageSize,pageSize);
		
		//���ݴ洢����������
		req.setAttribute("list", list);
		
		//��ȡ�ܼ�¼��
		int rows = dao.getRows("users");		
		//��ȡÿҳ��¼��(����ÿҳ2����¼)
		//int pageSize = 2;		
		//������ҳ��
		int pages = (int)Math.ceil(rows * 1.0 /pageSize);
		//����ҳ���洢����������
		req.setAttribute("pages", pages);
		
		//����ǰҳ�����洢����������
		req.setAttribute("index", index);
		
		//��ת��list.jspҳ��
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	
	}

}
