package cn.hl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

/**
 * file			：实际进行上传的文件对象。命名与表单中file元素的名称相同
 * fileName		：上传文件的名称。命名方式采用file元素名称+ "FileName"
 * contentType	：上传文件的Mime类型。命名方式采用file元素名称+"ContentType"
 * 
 * String contentTypeName = inputName + "ContentType";
   String fileNameName = inputName + "FileName";
 * @author Terry
 *
 */
public class UploadAction {
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	/**
	 * Struts2实现文件上传
	 * @return
	 * @throws IOException
	 */
	public String upload() throws IOException{
		//获取HttpServletRequest对象
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		//通过HttpServletRequest对象获取上传路径
		String path = req.getRealPath("/files");
		
		//拼接文件名
		String fileName = path + File.separatorChar + fileFileName;
		
		//创建输入流对象
		InputStream is = new FileInputStream(file);
		//创建输出流对象
		OutputStream os = new FileOutputStream(fileName);
		
		//读取输出流中的数据并且写入到本地服务器
		byte[] b = new byte[1024];
		int len = 0;
		
		//循环读取输入流中的数据
		while((len=is.read(b))!=-1){
			os.write(b, 0, len);
		}
		
		//关闭流对象
		os.close();
		is.close();
		
		return "success";
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}





	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	
	
}
