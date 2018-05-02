package cn.hl.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * @author X230
 *
 */
public class TcpClient {
	public static void main(String[] args) {
		System.out.println("Client�Ѿ�����......");
		//1������Socket����
		Socket client = null;
		//2������һ�����������
		OutputStream outStream = null;
		
		try {
			//ʵ����Socket����
			client = new Socket(InetAddress.getByName("127.0.0.1"),8090);
			//2����ȡSocket��������������
			outStream = client.getOutputStream();
			//3������������������
			outStream.write("Hello Mike".getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			//4���رն���
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
			System.out.println("Client�Ѿ��ر�......");	
		}
	}
}
