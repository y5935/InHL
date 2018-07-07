package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import cn.hl.bean.File;
import cn.hl.db.BaseDao;

public class DownServlet extends HttpServlet {
	BaseDao dao = new BaseDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("content-type", "text/html;charset=utf-8");
		*/
		String op = req.getParameter("op");
		
		if("list".equals(op))
			getList(req,resp);
		else
			try {
				downLoad(req,resp);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	private void downLoad(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SmartUploadException {
		//��ȡ�������ļ���URL
		String url = req.getParameter("fileName");
		
		System.out.println(url);
		
		//ִ�����ز���
		SmartUpload su = new SmartUpload();
		//��ʼ��SmartUpload����
		su.initialize(this.getServletConfig(),req, resp);
		//�������ݵĴ򿪷�ʽ
		su.setContentDisposition(null);
		//ִ�����ز���
		su.downloadFile("Files" + java.io.File.separatorChar + url);
		
		//��ת������ҳ��
		req.getRequestDispatcher("dn.jsp").forward(req, resp);
	}

	private void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ѯ�������ļ��б�
		String sql = "select * from Files order by FileId";		
		List<File> list = dao.executeQuery(File.class, sql);
		
		//���ݴ洢��request������
		req.setAttribute("list", list);
		System.out.println(list);
		
		//��ת��up.jspҳ��
		req.getRequestDispatcher("dn.jsp").forward(req, resp);
	}

}
