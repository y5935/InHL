package cn.hl.single;

/**
 * 单例设计模式
 * 	要求：每个类只能实例化出一个对象
 * 
 * 	三要素：
 * 		1、私有静态成员字段（类型与被实例化类型相同）
 * 		2、私有构造函数（为了避免用户直接调用构造函数实例化对象）
 * 		3、公共静态方法（创建实例化对象）
 * 
 * 懒汉与饿汉模式
 * 		懒汉模式：用时才进行对象的创建（懒得创建，谁用谁创建）
 * 		饿汉模式：直接进行对象的创建（非常饥饿）
 * 
 * 优缺点
 * 		懒汉模式：实例化对象时需要进行判断，频繁使用时效率较低。适用于调用不是十分频繁的环境
 * 		饿汉模式：实例化对象不需要进行判断，如果使用不是十分频繁可能会造成资源的浪费。适用于频繁使用的环境
 * @author Terry
 *
 */
public class Servlet {
	//1、私有静态成员
	//懒汉模式（延迟加载）
	private static Servlet instance = null;
	
	//饿汉模式（贪婪加载）
	private static Servlet instance2 = new Servlet();
	
	/**
	 * 2、私有构造函数
	 * 无参构造函数
	 */
	private Servlet() {
		//每次实例化Servlet对象时都会调用init()方法
		init();
	}
	
	/**
	 * 3、公共静态方法，方法的返回值与当前类型相同（适用于懒汉模式）
	 * 创建Servlet类型的对象
	 * 
	 * 双重检查（double check）
	 */
	public static Servlet create(){
		if(instance == null)
			synchronized (Servlet.class) {
				if(instance ==null)
					instance = new Servlet();
			}
		
		return instance;
	}
	
	/**
	 * 3、公共静态方法，方法的返回值与当前类型相同（适用于饿汉模式）
	 * 		对象已经创建，不需要再次判断
	 * @return
	 */
	public static Servlet create2(){
		return instance2;
	}
	
	
	/**
	 * init()方法，初始化Servlet对象
	 */
	private void init(){
		System.out.println("init() is do......");
	}
	
	
	
	/**
	 * service()方法，响应用户的请求
	 */
	public void service(){
		System.out.println("service() is do ......");
	}
}
