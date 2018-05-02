package cn.hl.work1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		System.out.println("�ͻ���������......");
		Scanner input= new Scanner(System.in);
		Socket socket = null;
		OutputStream outStream =null;
		InputStream inStream = null;

		
		//��ȡ�ļ���Ϣ
		System.out.print("��������Ҫ���д�����ļ�����(��������·��)��");
		String name = input.next();
		
		//��֤�ļ��Ƿ����
		File file = new File(name);
		if(!file.exists()){
			System.out.println("������ļ���ַ��������˶�");
			return;
		}
		
		//�������Ӳ�����
		try {
			//1������Socket����
			socket = new Socket(InetAddress.getByName("192.168.14.136"),9001);
			//2�������������������ڶ�ȡ�ļ�����
			inStream = new FileInputStream(file);
			outStream = socket.getOutputStream();
			
			//3����ʼ���д���
			//�洢��ȡ�����ļ�����
			byte[] b = new byte[1024];
			//�洢��ȡ�ĳ���
			int len = 0;
			
			//��ʼ�������
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
			//4���ͷ���Դ
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
		System.out.println("�ͻ������ݷ��ͽ���......");
	}
}
