package cn.hl.work2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1、聊天使用字节流还是字符流？
 * 		a、使用字符流
 * 		b、内容需要打印到控制台
 * @author X230
 *
 */
public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
				
		try {
			//1、实例化ServerSocket对象
			server = new ServerSocket(9001);
			
			//2、启动监听
			Socket socket = server.accept();
			
			ServerThread st = new ServerThread(socket);
			st.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class ServerThread extends Thread{
	//定义用于通信的Socket对象
	Socket socket = null;
	
	/**
	 * 构造函数
	 * @param socket
	 */
	public ServerThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {	
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("与客户端的连接已经断开");
		}
	
	}
}
