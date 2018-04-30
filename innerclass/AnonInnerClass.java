package innerclass;

/**
 * 匿名内部类：指的是内部类没有名字
 *  好处： 少定义一个类 
 *  缺点： 不能重复使用，只能用一次
 * 
 * @author Lens
 * 
 */
public class AnonInnerClass {

	public static void main(String[] args) {
		// 实现接口Jian的类（匿名内部类）
		m1(new Jian() {

			@Override
			public void eat() {
				System.out.println("定义一个子类实现eat方法");
			}
		});

	}

	public static void m1(Jian jian) {
		jian.eat();
	}
}

interface Jian {
	void eat();
}
