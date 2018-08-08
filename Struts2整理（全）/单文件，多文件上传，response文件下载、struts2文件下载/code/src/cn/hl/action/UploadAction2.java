package cn.hl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.omg.CORBA_2_3.portable.OutputStream;

import com.opensymphony.xwork2.ActionContext;

public class UploadAction2 {
	private File[] files;
	private String[] filesFileName;
	private String[] filesContentType;
	
	public String upload() throws IOException{
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		//获取上传路径
		String path = req.getRealPath("/files");
		
		//遍历上传文件的集合
		for(int i = 0;i<files.length;i++){
			String fileName = path + File.separatorChar + filesFileName[i];
			//获取输入流对象
			InputStream is = new FileInputStream(files[i]);
			//获取输出流对象
			FileOutputStream os = new FileOutputStream(fileName);
			
			//将文件写入到服务器
			byte[] b = new byte[1024];
			int len = 0;
			
			//循环读取文件
			while((len = is.read(b))!=-1){
				os.write(b, 0, len);
			}
			
			os.close();
			is.close();
			
		}
		
		return "success";
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String[] getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}	
}
