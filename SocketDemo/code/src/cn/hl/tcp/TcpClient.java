package cn.hl.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * @author X230
 *
 */
public class TcpClient {
	public static void main(String[] args) {
		System.out.println("Client已经启动......");
		//1、创建Socket对象
		Socket client = null;
		//2、创建一个输出流对象
		OutputStream outStream = null;
		
		try {
			//实例化Socket对象
			client = new Socket(InetAddress.getByName("127.0.0.1"),8090);
			//2、获取Socket对象的输出流对象
			outStream = client.getOutputStream();
			//3、向服务器端输出数据
			outStream.write("Hello Mike".getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			//4、关闭对象
			if(outStream != null){
				try {
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Client已经关闭......");	
		}
	}
}
