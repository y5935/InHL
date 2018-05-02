package cn.hl.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		System.out.println("server已经启动......");
		ServerSocket server = null;
		Socket socket = null;
		InputStream inStream = null;
		
		try {
			//1、创建ServerSocket对象
			server = new ServerSocket(8080);
			//2、对套接字进行监听
			socket = server.accept();
			//3、获取socket对象的输入流对象
			inStream = socket.getInputStream();
			
			//4、读取数据
			byte[] b =new byte[1024];
			int len = 0;
			
			if((len=inStream.read(b))!= -1){
				//将数据转为String
				String str = new String(b,0, len);
				//输出接收到的数据
				System.out.println(str);
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//5、关闭对象
			if(inStream != null){
				try {
					inStream.close();
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
			System.out.println("server已经关闭......");
		}

	}

}
