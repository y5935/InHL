package cn.hl.single;

/**
 * Servlet容器
 * 通过多线程来处理每一个用户的请求
 * 每一次的请求相当于一条独立的线程
 * @author Terry
 *
 */
public class Test implements Runnable{

	/**
	 * 假装是Servlet容器
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
		//请求线程
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}

	/**
	 * 访问相应的Servlet并调用其service()方法
	 */
	@Override
	public void run() {
		//加载响应的Servlet类
		Servlet s = Servlet.create();
		//通过调用Servlet对象的service()方法来响应请求		
		s.service();
	}

}
