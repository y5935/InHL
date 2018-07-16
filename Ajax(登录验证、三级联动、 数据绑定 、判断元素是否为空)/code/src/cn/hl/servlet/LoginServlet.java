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
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("content-type", "text/html;charset=utf-8");
		
		//��ȡ�������
		String account = req.getParameter("account");
		String pwd = req.getParameter("pwd");
		
		//ִ�е�¼��֤
		//a����дSQL���
		String sql = "select * from users where account=?";
		//b������Dao����
		BaseDao dao = new BaseDao();
		//c��ִ������
		List<User> list = dao.executeQuery(User.class, sql, account);
		
		//���list�����в������κ����ʾaccount��Ч(1��ʾ�˺Ŵ���)
		if(list.size()<1)
			resp.getWriter().print("1");
		else{
			for(User u:list){
				//�������ƥ��ɹ��򷵻�2����ʾ��¼�ɹ���
				if(pwd.equals(u.getPwd())){
					//������ӵ�������
					req.getSession().setAttribute("user", u);
					resp.getWriter().print("2");
					return;
				}
			}
			//��������û������붼ƥ��ʧ�ܣ��򷵻�-1
			resp.getWriter().print("-1");
		}
		
	}

}
