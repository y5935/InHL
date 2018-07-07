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
		//获取待下载文件的URL
		String url = req.getParameter("fileName");
		
		System.out.println(url);
		
		//执行下载操作
		SmartUpload su = new SmartUpload();
		//初始化SmartUpload对象
		su.initialize(this.getServletConfig(),req, resp);
		//设置内容的打开方式
		su.setContentDisposition(null);
		//执行下载操作
		su.downloadFile("Files" + java.io.File.separatorChar + url);
		
		//跳转回下载页面
		req.getRequestDispatcher("dn.jsp").forward(req, resp);
	}

	private void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询可下载文件列表
		String sql = "select * from Files order by FileId";		
		List<File> list = dao.executeQuery(File.class, sql);
		
		//数据存储到request作用域
		req.setAttribute("list", list);
		System.out.println(list);
		
		//跳转到up.jsp页面
		req.getRequestDispatcher("dn.jsp").forward(req, resp);
	}

}
