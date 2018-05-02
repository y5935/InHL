package cn.hl.addr;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestInetAddress {
	/**
	 * 1、使用域名方式
	 * 		通过域名可以获取到主机Ip地址。
	 * 		但是通过域名方式获取InetAddress对象时网络需要处于联通状态(因为需要通过DNS服务器进行解析)
	 * 2、使用Ip地址方式
	 * 		效率高，可以在网络断开的情况下获取InetAddress对象
	 * 3、对象实例化方式
	 * 		1）、构造函数进行实例化
	 * 		2）、通过反射进行实例化
	 * 		3）、通过静态方法进行实例化
	 * 4、常用方法
	 * 		
	 */
	@Test
	public void test1(){		
		try {
			//1、通过域名获取InetAddress对象			
			InetAddress addr1 = InetAddress.getByName("www.baidu.com");
			//InetAddress addr1 = InetAddress.getByName("www.jd.com");
			System.out.println(addr1);
			
			//2、直接通过Ip地址获取InetAddress对象
			//InetAddress addr2 = InetAddress.getByName("220.181.111.188");
			InetAddress addr2 = InetAddress.getByName("localhost");
			System.out.println(addr2);
			
			//3、常用方法
			//1)、getHostAddress()	：获取当前主机的Ip地址
			System.out.println(addr2.getHostAddress());
			//2)、getHostName()		：获取主机的Ip地址
			System.out.println(addr2.getHostName());
			//3）、getLocalHost()		：获取主机名称及Ip地址
			System.out.println(addr2.getLocalHost());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
