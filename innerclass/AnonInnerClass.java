package innerclass;

/**
 * �����ڲ��ָࣺ�����ڲ���û������
 *  �ô��� �ٶ���һ���� 
 *  ȱ�㣺 �����ظ�ʹ�ã�ֻ����һ��
 * 
 * @author Lens
 * 
 */
public class AnonInnerClass {

	public static void main(String[] args) {
		// ʵ�ֽӿ�Jian���ࣨ�����ڲ��ࣩ
		m1(new Jian() {

			@Override
			public void eat() {
				System.out.println("����һ������ʵ��eat����");
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
