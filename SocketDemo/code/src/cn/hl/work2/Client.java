package cn.hl.work2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1、聊天使用字节流还是字符流？
 * 		a、使用字符流
 * 		b、内容需要打印到控制台
 * @author X230
 *
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("客户端启动中......");
		Socket socket = null;
		
		try {
			//1、获取Socket对象
			socket = new Socket(InetAddress.getByName("127.0.0.1"),9001);
			//1）、获取BufferedReader对象
			//接收键盘的输入
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//向服务器端输出数据
			//BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			PrintWriter print = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//存储输入的内容
			System.out.print("我：");	
			String text = reader.readLine();
			while(!"bye".equals(text.toLowerCase())){
				//向服务器发送数据
				print.write(text);
				print.flush();
				
				//接收新的数据
				System.out.print("我：");				
				text = reader.readLine();
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("客户端已关闭......");
		}
	}
}
