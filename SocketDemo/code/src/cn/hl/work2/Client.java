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
 * 1������ʹ���ֽ��������ַ�����
 * 		a��ʹ���ַ���
 * 		b��������Ҫ��ӡ������̨
 * @author X230
 *
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("�ͻ���������......");
		Socket socket = null;
		
		try {
			//1����ȡSocket����
			socket = new Socket(InetAddress.getByName("127.0.0.1"),9001);
			//1������ȡBufferedReader����
			//���ռ��̵�����
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//����������������
			//BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			PrintWriter print = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//�洢���������
			System.out.print("�ң�");	
			String text = reader.readLine();
			while(!"bye".equals(text.toLowerCase())){
				//���������������
				print.write(text);
				print.flush();
				
				//�����µ�����
				System.out.print("�ң�");				
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
			System.out.println("�ͻ����ѹر�......");
		}
	}
}
