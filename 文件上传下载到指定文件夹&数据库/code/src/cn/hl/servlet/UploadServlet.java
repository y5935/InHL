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
	 * 1���ϴ��ļ�
	 * 2���ļ���Ϣ��ӵ����ݿ���
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		
		//��ȡ�ļ��ڷ������ϱ��������·��
		String path = this.getServletContext().getRealPath(folder);
		
		//1������SmartUpload����
		SmartUpload su = new SmartUpload();
	
		//2����ʼ������
		su.initialize(this.getServletConfig(), req, resp);
		
		try {
			//3���ϴ��ļ����ڴ���
			su.upload();
			
			//�ж��ļ��Ƿ����
			File file = su.getFiles().getFile(0);
			if(file.isMissing()) 
				return;
			
			//4�����ļ��洢�����ش���
			String fileName = "File_" + System.currentTimeMillis() + "." + file.getFileExt();
			file.saveAs(path + java.io.File.separatorChar + fileName);
			
			//���ļ���Ϣд�뵽���ݿ���
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
