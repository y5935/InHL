package cn.hl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hl.bean.User;
import cn.hl.dao.UserDao;

import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User>{
	//定义User类型的成员属性存储用户提交的相关信息
	private User user = new User();
	//定义其他属性存储上传文件的相关信息
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	/**
	 * 添加用户信息到数据库
	 * @return
	 */
	public String add(){
		//1、上传文件
		//1）、获取Request对象
		HttpServletRequest req = ServletActionContext.getRequest();
		
		//2）、获取上传的物理路径
		String path = req.getRealPath("/Files");
		
		//3）、拼接上传文件的名称
		String newFileName =  getFileName(fileFileName);
		String fileName = path + File.separatorChar + newFileName;
		
		//4、声明输入流和输出流对象
		InputStream is = null;
		OutputStream os = null;
		
		try{
			//实例化输入流和输出流对象
			is = new FileInputStream(file);
			os = new FileOutputStream(fileName);
			
			//5、定义byte数组存储读取的文件内容
			byte[] b = new byte[1024];
			int len = 0;
			
			//6、循环读取文件内容
			while((len = is.read(b))!=-1){
				os.write(b, 0, len);
				os.flush();
			}
			
			//2、添加用户信息到数据库
			//设置user对象的photo属性
			user.setPhoto(newFileName);
			UserDao dao = new UserDao();
			dao.add(user);
			
		} catch (FileNotFoundException e) {
			return "error";
		} catch (IOException e) {
			return "error";
		}
		finally{
			close(is,os);
		}
		
		return "success";
	}
	
	private void close(InputStream is, OutputStream os){
		//关闭输出流对象
		if(os != null){
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//关闭输入流对象
		if(is != null){
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 生成新文件名称
	 * @param name	：原文件名称
	 * @return		：新文件名称。格式为：pic_日期值.扩展名
	 */
	private String getFileName(String name){
		//获取文件扩展名
		String ext = name.substring(name.lastIndexOf("."));
		//返回新的文件名称
		return "pic_" + System.currentTimeMillis() + ext;
	}

	@Override
	public User getModel() {
		return user;
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
