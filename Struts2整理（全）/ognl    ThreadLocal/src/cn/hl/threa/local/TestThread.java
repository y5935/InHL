package cn.hl.threa.local;

/**
 * ThreadLocal
 * 	为每条线程管理各自独立的数据
 * @author Terry
 *
 */
public class TestThread {
	//ThreadLocal类型静态对象
	private static ThreadLocal<String> tl = new ThreadLocal<String>();
	//静态变量
	private static String str = "str";
	
	public static void main(String[] args) {
		//设置线程局部变量str的值
		tl.set("def");
		System.out.println("main.Id :" + Thread.currentThread().getId());
		
		//获取线程局部变量str的值。输出结果为：def
		System.out.println("main.str :" + tl.get());
		
		//创建了一个新的线程（第二个线程）
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread.run.id：" + Thread.currentThread().getId());
				//输出结果为：str
				System.out.println("thread.run.str：" + str);
				//数据读取失败，输出结果为：null
				System.out.println("thread.run.get()：" + tl.get());
			}
		}).start();
	}
}
