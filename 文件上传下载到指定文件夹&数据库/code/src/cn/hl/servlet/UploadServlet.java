package cn.hl.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.db.BaseDao;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadServlet extends HttpServlet {
	private String folder ="Files";
	

	/**
	 * 1、上传文件
	 * 2、文件信息添加到数据库中
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		
		//获取文件在服务器上保存的物理路径
		String path = this.getServletContext().getRealPath(folder);
		
		//1、创建SmartUpload对象
		SmartUpload su = new SmartUpload();
	
		//2、初始化对象
		su.initialize(this.getServletConfig(), req, resp);
		
		try {
			//3、上传文件到内存中
			su.upload();
			
			//判断文件是否存在
			File file = su.getFiles().getFile(0);
			if(file.isMissing()) 
				return;
			
			//4、将文件存储到本地磁盘
			String fileName = "File_" + System.currentTimeMillis() + "." + file.getFileExt();
			file.saveAs(path + java.io.File.separatorChar + fileName);
			
			//将文件信息写入到数据库中
			String sql = "insert into Files values(default,?,?)";
			BaseDao dao = new BaseDao();
			dao.executeUpdate(sql, file.getFileName(),fileName);
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
