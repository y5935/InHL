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

public class JsonServlet extends HttpServlet {

	/**
	 * Json:javascript object notation�����ΪJavascript�������
	 * Json��һ�������������ݽ�����ʽ��һ�ֶ��������Ե��ı���ʽ
	 * Json��ʽ������Ч���������Ĵ���Ч�ʣ�ͬʱ���Կ�ƽ̨
	 * Json�����ݶ����Լ�ֵ�Ե���ʽ���ڵ�
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ͨ��Dao�����ѯ����
		BaseDao dao = new BaseDao();
		
		//��дSQL���
		String sql = "select * from users";
		List<User> list = dao.executeQuery(User.class, sql);
		
		
		
		//��ӦAjax����
		if(list.size()>0){
			//��ȡ��һ��Ԫ��
			User u = list.get(0);
			//�����࣬�ṩ��Json��ʽת������ط���
			Gson g = new Gson();
			String json = g.toJson(u);
			
			//����һ����
			System.out.println(json);
			resp.getWriter().print(json);
			
			/*
			//�����϶���
			String json2 = g.toJson(list);
			System.out.println(json2);
			*/
		}
		else
			resp.getWriter().print("");
		
	}

}
