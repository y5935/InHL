package singleleton;
/**
 * 单例模式是一种常用的软件设计模式，在他的和新结构中只包含一个被称为单例的特殊类 
 * 通过单例可以保证系统中一个类只有一个实例，保证了对象的唯一性。
 * 
 * 单例模式（饿汉式）
 * 1.先构造私有的构造函数
 * 2.在对外开放一个可以得到当前类的公共方法（返回值为当前类的类型）
 * 
 * 缺点:占用内存
 * 
 * @author Lens
 *
 */

public class Human {
	static Human human = new Human();
	private Human(){
		
	}
	
	public static Human getHuman(){
		return human;
	}
}
