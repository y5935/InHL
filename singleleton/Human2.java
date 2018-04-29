package singleleton;
/**
 * 单例模式（懒汉式）
 * 优点：节省空间
 * 缺点：线程的同步问题
 * @author Lens
 *
 */
public class Human2 {
	static Human2 human2;

	private Human2() {
	}

	public static Human2 getHuman2() {
		if (human2 == null) {
			human2 = new Human2();
		}
		return human2;
	}
}
