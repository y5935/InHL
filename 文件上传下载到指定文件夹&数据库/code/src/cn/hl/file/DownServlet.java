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
	 * ʵ���ļ�����
	 * ʵ���ļ��ϴ����ع��ܡ�����ҳ��ͨ�����ݿ��ȡ���п������ļ��б�
	 * �����ļ��ϴ���ͨ��ˢ�£�����ҳ����Լ��ص����¿������ļ��б�
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ�������ļ�
		String name = req.getParameter("name");
		
		//1������SmartUpload����
		SmartUpload su = new SmartUpload();
		
		//2����ʼ��SmartUpload����
		su.initialize(this.getServletConfig(), req,resp);
		
		try {
			//�������װ�˲���󣬲����ļ�����ʱ��ֱ����������д�
			//ͨ������setContent��Disposition()���Ա���ֱ�Ӵ�
			su.setContentDisposition(null);
			
			//3��ִ�����ز���
			su.downloadFile(name);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
