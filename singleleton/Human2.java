package singleleton;
/**
 * ����ģʽ������ʽ��
 * �ŵ㣺��ʡ�ռ�
 * ȱ�㣺�̵߳�ͬ������
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
