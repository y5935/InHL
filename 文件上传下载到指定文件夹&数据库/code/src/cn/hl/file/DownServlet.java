package cn.hl.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class DownServlet extends HttpServlet {
	/**
	 * 实现文件下载
	 * 实现文件上传下载功能。下载页面通过数据库读取所有可下载文件列表。
	 * 有新文件上传后，通过刷新，下载页面可以加载到最新可下载文件列表
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取待下载文件
		String name = req.getParameter("name");
		
		//1、创建SmartUpload对象
		SmartUpload su = new SmartUpload();
		
		//2、初始化SmartUpload对象
		su.initialize(this.getServletConfig(), req,resp);
		
		try {
			//浏览器安装了插件后，部分文件下载时是直接在浏览器中打开
			//通过设置setContent、Disposition()可以避免直接打开
			su.setContentDisposition(null);
			
			//3、执行下载操作
			su.downloadFile(name);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
