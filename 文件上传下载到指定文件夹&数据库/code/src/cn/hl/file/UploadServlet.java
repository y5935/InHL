package cn.hl.file;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadServlet extends HttpServlet {

	/**
	 * 要点：
	 * 	form表单必须满足：
	 * 		1、提交方式为post方式
	 * 		2、enctype的值必须设置为multipar/form-data
	 * 	上传步骤
	 * 		1、创建smartupload对象
	 * 		2、初始化smartupload对象
	 * 		3、文件上传到内存中
	 * 		4、文件另存到服务器硬盘上
	 * 	常见用法
	 * 		1、设置允许上传列表：setAllowedFilesList()
	 * 		2、设置禁止上传列表：setDeniedFilesList()
	 * 		3、设置允许上传文件的最大尺寸：setMaxFileSize()
	 * 		4、获取文件名：getFileName()
	 * 		5、获取文件扩展名：getFileExt()
	 * 	实际应用
	 * 		1、上传路径一般位于项目目录下
	 * 		2、上传文件的名称会被修改
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、创建SmartUpload对象
		SmartUpload su = new SmartUpload();
		
		//2、初始化SmartUpload对象
		su.initialize(this.getServletConfig(), req, resp);	
		
		//设置允许上传文件的列表
		su.setAllowedFilesList("jpg,png,bmp,rar");
		
		
		try {
			//禁止上传文件的列表
			su.setDeniedFilesList("bat");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//设置上传文件的最大尺寸
		//以字节为单位(示例：允许最大上传文件的大小为5M)
		su.setMaxFileSize(1024  * 1024 * 5);
		
		try {
			

			
			//3、上传文件到服务器（内存）
			su.upload();
			
			//判断上传文件是否存在
			if(su.getFiles().getFile(0).isMissing()){
				return;
			}
			
			
			String path = this.getServletContext().getRealPath("\\Files");
			String name = "File_" + System.currentTimeMillis() + "." + su.getFiles().getFile(0).getFileExt();
			
			
			//4、将文件写入到硬盘
			su.getFiles().getFile(0).saveAs(path + File.separatorChar + name);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
