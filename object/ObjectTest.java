package object;
/**
 * java中的Object
 * 1.toString和equals方法都在Object中；
 * 2.Object类是java中的根类；
 * 3.一个类如果没有显式的继承其他类，都将是默认继承了Object类。
 * 
 * @author Lens
 *
 */
public class ObjectTest {

	public static void main(String[] args) {
		/*toString 输出我们想要的东西
		Person p = new Person();
		p.name="张三";
		p.age=18;
		System.out.println(p);
		System.out.println(p.toString());
		*/
		
		
		Person p1 = new Person("张三",25);
		Person p2 = new Person("张三",25);
		System.out.println(p1==p2);//结果是false
		//以上代码之所以输出false，因为“==”比较的是内存地址
		
		//equals方法是用来比较内容的(可以根据需求自定义写判断 equals)。
		System.out.println(p1.equals(p2));// 结果是false
		System.out.println(p1.equals(p1));//结果是true
		
	}

}
