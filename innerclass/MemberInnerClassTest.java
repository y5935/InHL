package innerclass;
/**
 * 成员内部类可以等同看作成员变量
 * 成员内部类可以用控制访问权限修饰符修饰
 * 成员内部类不能有静态声明
 * 成员内部类可以访问外部类的所有数据
 * 
 * @author Lens
 *
 */
public class MemberInnerClassTest {
	//成员变量
	int i  = 1;
	//静态变量
	static int s =10;
	//成员方法
	public void m1(){
		System.out.println(s);
		m2();
	}
	//静态方法
	public static void m2(){}
	
	
	
	
	//成员内部类
	class InnerClass{
		//静态方法
		//public static void m3(){}   静态方法不能有
		//static int  k = 1;          静态属性不能有
		int m = 1;
		public void m4(){
			System.out.println(i);
			System.out.println(s);
			m1();
			m2();
		}	
	}
	

	public static void main(String[] args) {
		//MemberInnerClassTest  mct = new MemberInnerClassTest();
		//System.out.println(mct.i);
		//InnerClass in = mct.new InnerClass();
		InnerClass in = new MemberInnerClassTest().new InnerClass();
	
	}

}
