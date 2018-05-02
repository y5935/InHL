package cn.hl.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendClient {

	public static void main(String[] args) {
		System.out.println("数据开始发送......");
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		
		try {
			//1、创建DatagramSocket对象
			socket = new DatagramSocket();
			//2、创建待发送数据的数据包
			byte[] b = "您好".getBytes();
			packet = new DatagramPacket(b,b.length,InetAddress.getLocalHost(),9000);
			//3、发送数据包
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
			//4、释放资源对象
			if(socket != null){
				socket.close();
			}
				
		}
		System.out.println("数据发送结束......");

	}

}
