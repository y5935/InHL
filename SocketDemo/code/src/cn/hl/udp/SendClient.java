package cn.hl.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendClient {

	public static void main(String[] args) {
		System.out.println("���ݿ�ʼ����......");
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		
		try {
			//1������DatagramSocket����
			socket = new DatagramSocket();
			//2���������������ݵ����ݰ�
			byte[] b = "����".getBytes();
			packet = new DatagramPacket(b,b.length,InetAddress.getLocalHost(),9000);
			//3���������ݰ�
			socket.send(packet);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//4���ͷ���Դ����
			if(socket != null){
				socket.close();
			}
				
		}
		System.out.println("���ݷ��ͽ���......");

	}

}
