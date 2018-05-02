package cn.hl.work1;

import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		System.out.println("服务器端启动中......");
		ServerSocket server = null;
		Socket socket = null;
		InputStream inStream = null;
		OutputStream outStream = null;
		
		try {
			//1、创建ServerSocket对象
			server = new ServerSocket(9001);
			//2、监听请求
			socket = server.accept();
			//3、接收客户端的输入流对象
			inStream = socket.getInputStream();
			
			//4、读取内容并进行输出
			byte[] b = new byte[1024];
			int len = 0;
			
			
			outStream = new FileOutputStream("1.jpg");
			while((len = inStream.read(b))!=-1){
				outStream.write(b, 0, len);
				outStream.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			//5、释放资源
			if(inStream != null){
				try {
					inStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(outStream != null){
				try {
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("服务器端已关闭......");
		}
	}

}
