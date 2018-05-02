package cn.hl.addr;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestInetAddress {
	/**
	 * 1��ʹ��������ʽ
	 * 		ͨ���������Ի�ȡ������Ip��ַ��
	 * 		����ͨ��������ʽ��ȡInetAddress����ʱ������Ҫ������ͨ״̬(��Ϊ��Ҫͨ��DNS���������н���)
	 * 2��ʹ��Ip��ַ��ʽ
	 * 		Ч�ʸߣ�����������Ͽ�������»�ȡInetAddress����
	 * 3������ʵ������ʽ
	 * 		1�������캯������ʵ����
	 * 		2����ͨ���������ʵ����
	 * 		3����ͨ����̬��������ʵ����
	 * 4�����÷���
	 * 		
	 */
	@Test
	public void test1(){		
		try {
			//1��ͨ��������ȡInetAddress����			
			InetAddress addr1 = InetAddress.getByName("www.baidu.com");
			//InetAddress addr1 = InetAddress.getByName("www.jd.com");
			System.out.println(addr1);
			
			//2��ֱ��ͨ��Ip��ַ��ȡInetAddress����
			//InetAddress addr2 = InetAddress.getByName("220.181.111.188");
			InetAddress addr2 = InetAddress.getByName("localhost");
			System.out.println(addr2);
			
			//3�����÷���
			//1)��getHostAddress()	����ȡ��ǰ������Ip��ַ
			System.out.println(addr2.getHostAddress());
			//2)��getHostName()		����ȡ������Ip��ַ
			System.out.println(addr2.getHostName());
			//3����getLocalHost()		����ȡ�������Ƽ�Ip��ַ
			System.out.println(addr2.getLocalHost());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
