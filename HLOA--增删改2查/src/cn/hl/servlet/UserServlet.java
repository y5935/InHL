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
		//��ȡ�������ͣ�op��
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
	 * ִ�ж�������ѯ
	 * ֧��ģ����ѯ
	 * ��ȡ������� -->ִ�в�ѯ���� -->���ݴ洢�������� -->��ת��list.jsp
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�������
		String name = req.getParameter("name");
		
		//��ѯ����
		List<User> list = dao.getByName(name);
		System.out.println(list);
		
		//���ݴ洢��������
		req.setAttribute("list", list);
		//��ת��list.jspҳ��
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

	/**
	 * ��Idɾ���û���Ϣ
	 * ��ȡ������� -->ִ��ɾ������ --> ��ת��list.jspҳ��
	 * @param req
	 * @param resp
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		
		//ִ��ɾ������
		dao.delete(id);
	}

	/**
	 * ����Id����ָ��������
	 * ��ȡ������� --> ���ݴ洢�����ݿ� --> ��ת��list.jspҳ��
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡ�������
		User user = new User();
		user.setAccount(req.getParameter("account"));
		user.setPwd(req.getParameter("pwd"));
		user.setUserName(req.getParameter("userName"));
		user.setUserId(Integer.parseInt(req.getParameter("userId")));
		
		//�������ݵ����ݿ�
		dao.update(user);
	}

	/**
	 * ����Id��ȡ�û���Ϣ
	 * ��ȡ�û���Ϣ -->�洢�������� --> ��ת��edit.jsp
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
	 * ����û���Ϣ�����ݱ�
	 * 	��ȡ������� --> �����ݱ��浽���ݿ� -->��ת��list.jspҳ��
	 * @param req
	 * @param resp
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡ�������
		User user = new User();
		user.setAccount(req.getParameter("account"));
		user.setPwd(req.getParameter("pwd"));
		user.setUserName(req.getParameter("userName"));
		
		//�����ݲ��뵽���ݱ���
		dao.add(user);		
	}

	/**
	 * ��ȡ�����û����б�
	 * ��ȡ�����б� --> ���ݴ洢�������� -->��ת��list.jsp
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�û��б�
		List<User> list = dao.getAll();
		
		//��������ӵ���������
		req.setAttribute("list", list);

		//������ת��list.jspҳ��
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

}
