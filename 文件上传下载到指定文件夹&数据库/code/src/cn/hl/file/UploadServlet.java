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
	 * Ҫ�㣺
	 * 	form���������㣺
	 * 		1���ύ��ʽΪpost��ʽ
	 * 		2��enctype��ֵ��������Ϊmultipar/form-data
	 * 	�ϴ�����
	 * 		1������smartupload����
	 * 		2����ʼ��smartupload����
	 * 		3���ļ��ϴ����ڴ���
	 * 		4���ļ���浽������Ӳ����
	 * 	�����÷�
	 * 		1�����������ϴ��б�setAllowedFilesList()
	 * 		2�����ý�ֹ�ϴ��б�setDeniedFilesList()
	 * 		3�����������ϴ��ļ������ߴ磺setMaxFileSize()
	 * 		4����ȡ�ļ�����getFileName()
	 * 		5����ȡ�ļ���չ����getFileExt()
	 * 	ʵ��Ӧ��
	 * 		1���ϴ�·��һ��λ����ĿĿ¼��
	 * 		2���ϴ��ļ������ƻᱻ�޸�
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1������SmartUpload����
		SmartUpload su = new SmartUpload();
		
		//2����ʼ��SmartUpload����
		su.initialize(this.getServletConfig(), req, resp);	
		
		//���������ϴ��ļ����б�
		su.setAllowedFilesList("jpg,png,bmp,rar");
		
		
		try {
			//��ֹ�ϴ��ļ����б�
			su.setDeniedFilesList("bat");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//�����ϴ��ļ������ߴ�
		//���ֽ�Ϊ��λ(ʾ������������ϴ��ļ��Ĵ�СΪ5M)
		su.setMaxFileSize(1024  * 1024 * 5);
		
		try {
			

			
			//3���ϴ��ļ������������ڴ棩
			su.upload();
			
			//�ж��ϴ��ļ��Ƿ����
			if(su.getFiles().getFile(0).isMissing()){
				return;
			}
			
			
			String path = this.getServletContext().getRealPath("\\Files");
			String name = "File_" + System.currentTimeMillis() + "." + su.getFiles().getFile(0).getFileExt();
			
			
			//4�����ļ�д�뵽Ӳ��
			su.getFiles().getFile(0).saveAs(path + File.separatorChar + name);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
