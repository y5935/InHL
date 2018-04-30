package innerclass;
/**
 * 局部内部类等同于局部变量
 * 局部内部类不能用访问控制权限符修饰
 * 局部内部类不能有静态声明
 * 重点：局部内部类在访问局部变量的时候，局部变量必须使用final修饰
 *     局部内部类在访问成员变量的时候不需要，可以直接访问
 * @author Lens
 *
 */

public class PartInnerClassTest {
	int a = 1;
	public void m1(){
		//局部变量
		final int i= 10;
		//局部内部类
		class InnerClass{
			//静态方法
			//public static void m2(){}
			public void m3(){
				System.out.println(i);
				System.out.println(a);
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		PartInnerClassTest pct = new PartInnerClassTest();
		System.out.println(pct.a);
		//System.out.println(pct.i);不能
		pct.m1();
	}

}
