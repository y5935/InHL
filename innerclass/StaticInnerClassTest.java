package innerclass;
/**
 *
 * 静态内部类可以等同看作静态变量
 * 静态内部类能被控制访问权限符修饰
 * 静态内部类可以直接访问外部类的静态数据，但是不能直接访问成员
 * @author Lens
 *
 */
public class StaticInnerClassTest {
	
	//静态变量
	static int i1 = 10;
	//成员变量
	int i2 = 20;
	//静态方法
	public static void m1(){}
	//成员方法
	public void m2(){}
	//静态内部类
	public static class InnerClass{
		static int i3 = 10;
		static void m3(){}
		int i4 = 10;
		
		void m4(){
			System.out.println(i1);
			//System.out.println(i2);
			m1();
			//m2();
		}
	}
	
	public static void main(String[] args) {
		InnerClass in = new StaticInnerClassTest.InnerClass(); 
	}
	
}
