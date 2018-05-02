package cn.hl.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		System.out.println("server�Ѿ�����......");
		ServerSocket server = null;
		Socket socket = null;
		InputStream inStream = null;
		
		try {
			//1������ServerSocket����
			server = new ServerSocket(8080);
			//2�����׽��ֽ��м���
			socket = server.accept();
			//3����ȡsocket���������������
			inStream = socket.getInputStream();
			
			//4����ȡ����
			byte[] b =new byte[1024];
			int len = 0;
			
			if((len=inStream.read(b))!= -1){
				//������תΪString
				String str = new String(b,0, len);
				//������յ�������
				System.out.println(str);
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//5���رն���
			if(inStream != null){
				try {
					inStream.close();
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
			System.out.println("server�Ѿ��ر�......");
		}

	}

}
