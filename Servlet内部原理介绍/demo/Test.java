package cn.hl.demo;

public class Test {
	public static void main(String[] args) {
		Parent c = new Child();
		c.service();
	}
}

/**
 * 父类，相当于HttpServlet
 * @author Terry
 *
 */
class Parent{
	public void service(){
		System.out.println("1、Parent.service is do......");
		doGet();
	}
	
	public void doGet(){
		System.out.println("2、Parent.doGet is do......");
		System.err.println("method GET is not supported");
	}
}

/**
 * 子类，相当于自定义Servlet类
 * @author Terry
 *
 */
class Child extends Parent{

	@Override
	public void service() {
		System.out.println("A、Child.service is do......");
		//super.service();
	}

	@Override
	public void doGet() {
		System.out.println("B、Child.doGet is do......");
		//super.doGet();
	}
	
	
	
}
