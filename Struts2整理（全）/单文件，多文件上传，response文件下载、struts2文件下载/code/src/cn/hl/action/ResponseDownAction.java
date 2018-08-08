package cn.hl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ResponseDownAction {
	
	/**
	 * Response实现文件下载
	 * 	1、request	：用于获取文件的所在路径
	 * 	2、response	：用于向客户端进行输出（获取输出流对象）
	 * @return
	 * @throws IOException 
	 */
	public String down() throws IOException{
		//1、获取request对象(为获取上传文件的所在路径)
		HttpServletRequest req = ServletActionContext.getRequest();
		
		//2、获取response对象
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		//3、获取文件路径
		String path = req.getRealPath("/files");
		
		//4、获取下载的文件对象
		File file = new File(path,"1.pdf");
		
		//5、设置response对象
		//1）、设置编码格式
		resp.setCharacterEncoding("utf-8");
		
		//2）、设置下载文件的长度(大小)
		resp.setContentLength((int)file.length());
		
		//3）、设置文件的内容(表示内容可以是任意类型)
		resp.setContentType("application/octet-stream");
		
		//4）、设置应答头(设置内容的方式-附件方式)
		//fileName用于设置附件的名称
		resp.setHeader("content-disposition", "attachment;filename=1.pdf");
		
		//6、获取输出流对象
		//向客户端发送数据需要通过Response完成，所以需要获取Response的输出流对象
		OutputStream os = resp.getOutputStream();
		
		//7、获取输入流对象
		InputStream is = new FileInputStream(file);
		
		//8、定义byte数组存储读取到的文件内容
		byte[] b = new byte[1024];
		int len = 0;
		
		//9、循环读取文件内容并输出到客户端
		while((len = is.read(b))!=-1){
			os.write(b, 0, len);
		}
		
		//10、关闭对象
		os.close();
		is.close();
		
		//11、返回result结果
		//null表示没有返回值
		return null;
	}
}
