package cn.hl.single;

/**
 * Servlet����
 * ͨ�����߳�������ÿһ���û�������
 * ÿһ�ε������൱��һ���������߳�
 * @author Terry
 *
 */
public class Test implements Runnable{

	/**
	 * ��װ��Servlet����
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
		//�����߳�
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}

	/**
	 * ������Ӧ��Servlet��������service()����
	 */
	@Override
	public void run() {
		//������Ӧ��Servlet��
		Servlet s = Servlet.create();
		//ͨ������Servlet�����service()��������Ӧ����		
		s.service();
	}

}
