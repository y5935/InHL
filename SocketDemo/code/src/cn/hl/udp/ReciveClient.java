package cn.hl.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReciveClient {

	public static void main(String[] args) {
		System.out.println("׼����ʼ����......");
		DatagramSocket socket = null;
		
		try {
			//1������DatagramSocket����
			socket = new DatagramSocket(9000);
			byte[] b = new byte[1024];
			//2������DatagramPacket����
			DatagramPacket packet = new DatagramPacket(b,1024);
			//3����������
			socket.receive(packet);
			System.out.println(new String(b));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			socket.close();
		}
		System.out.println("���ݽ������......");
	}

}
