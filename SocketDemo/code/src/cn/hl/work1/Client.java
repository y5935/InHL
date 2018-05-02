package cn.hl.work1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		System.out.println("客户端启动中......");
		Scanner input= new Scanner(System.in);
		Socket socket = null;
		OutputStream outStream =null;
		InputStream inStream = null;

		
		//获取文件信息
		System.out.print("请输入需要进行传输的文件名称(包含完整路径)：");
		String name = input.next();
		
		//验证文件是否存在
		File file = new File(name);
		if(!file.exists()){
			System.out.println("错误的文件地址，请认真核对");
			return;
		}
		
		//建立连接并传输
		try {
			//1、创建Socket对象
			socket = new Socket(InetAddress.getByName("192.168.14.136"),9001);
			//2、创建输入流对象用于读取文件内容
			inStream = new FileInputStream(file);
			outStream = socket.getOutputStream();
			
			//3、开始进行传送
			//存储读取到的文件内容
			byte[] b = new byte[1024];
			//存储读取的长度
			int len = 0;
			
			//开始进行输出
			while((len = inStream.read(b)) != -1){
				outStream.write(b, 0, len);
				outStream.flush();
			}			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			//4、释放资源
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
		}
		System.out.println("客户端数据发送结束......");
	}
}
