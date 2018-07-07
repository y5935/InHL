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
		//��ȡ�ܼ�¼��
		int rows = dao.getRows("users");
		//��ȡPageSize
		int pageSize =2;
		
		//��ȡ��ǰҳ����
		int index = (req.getParameter("index")==null) ? 1: Integer.parseInt(req.getParameter("index"));
		
		//������ҳ����
		Pager page = new Pager(rows, pageSize, index);
		
		//��ѯ����
		String sql = "select * from users limit ?,?";
		List<User> list = dao.executeQuery(User.class, sql, page.getOffSet(),page.getPageSize());
		
		//���÷�ҳ����
		page.setList(list);
		
		//������洢��������
		req.setAttribute("page", page);
		
		//ִ��ҳ����ת
		req.getRequestDispatcher("list2.jsp").forward(req, resp);
	}

}
