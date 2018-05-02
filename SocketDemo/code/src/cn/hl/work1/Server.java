package cn.hl.work1;

import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		System.out.println("��������������......");
		ServerSocket server = null;
		Socket socket = null;
		InputStream inStream = null;
		OutputStream outStream = null;
		
		try {
			//1������ServerSocket����
			server = new ServerSocket(9001);
			//2����������
			socket = server.accept();
			//3�����տͻ��˵�����������
			inStream = socket.getInputStream();
			
			//4����ȡ���ݲ��������
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
			//5���ͷ���Դ
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
			System.out.println("���������ѹر�......");
		}
	}

}
