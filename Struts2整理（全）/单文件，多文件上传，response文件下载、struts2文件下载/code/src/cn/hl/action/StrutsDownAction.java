package cn.hl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * Struts2实现文件下载
 * 	1、定义名为fileName的属性并提供get/set访问器
 * 	2、定义请求处理方法
 * @author Terry
 *
 */
public class StrutsDownAction {
	//用于接收和提供待下载文件的名称
	private String fileName;

	/**
	 * 请求处理方法
	 * @return
	 */
	public String execute(){
		return "success";
	}
	
	/**
	 * 获取下载文件的输入流
	 * @return
	 * @throws FileNotFoundException
	 */
	public InputStream getInputStream() throws FileNotFoundException{
		//获取Request对象（获取文件的物理路径）
		HttpServletRequest req = ServletActionContext.getRequest();
		//获取物理路径
		String path = req.getRealPath("/files");
		
		return new FileInputStream(new File(path,fileName));
	}
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
