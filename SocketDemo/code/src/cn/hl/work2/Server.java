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
 * 1������ʹ���ֽ��������ַ�����
 * 		a��ʹ���ַ���
 * 		b��������Ҫ��ӡ������̨
 * @author X230
 *
 */
public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
				
		try {
			//1��ʵ����ServerSocket����
			server = new ServerSocket(9001);
			
			//2����������
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
	//��������ͨ�ŵ�Socket����
	Socket socket = null;
	
	/**
	 * ���캯��
	 * @param socket
	 */
	public ServerThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {	
		try {
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
			System.out.println("��ͻ��˵������Ѿ��Ͽ�");
		}
	
	}
}
