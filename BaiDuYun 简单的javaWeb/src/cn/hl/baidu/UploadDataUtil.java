package cn.hl.baidu;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadDataUtil {
	/**
	 * 文件上传核心方法
	 * @param request
	 * @param response
	 * @return HashMap<String,Object> 返回类型
	 */
	public static HashMap<String,Object> uploadFiles(HttpServletRequest request,HttpServletResponse response){
		try {
			//创建一个集合
			HashMap<String,Object> map = new HashMap<String,Object>();
			
			//设置编码集
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//设置文件上传的路径  服务器根目录
			String realPath = request.getSession().getServletContext().getRealPath(File.separator);
			//定义上传的目录
			String dirPath = realPath+"/upload";
			
			//文件
			File dirFile = new File(dirPath);
			//判断这个文件是否存在
			if(!dirFile.exists()){
				dirFile.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}
