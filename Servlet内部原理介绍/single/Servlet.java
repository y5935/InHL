package cn.hl.single;

/**
 * �������ģʽ
 * 	Ҫ��ÿ����ֻ��ʵ������һ������
 * 
 * 	��Ҫ�أ�
 * 		1��˽�о�̬��Ա�ֶΣ������뱻ʵ����������ͬ��
 * 		2��˽�й��캯����Ϊ�˱����û�ֱ�ӵ��ù��캯��ʵ��������
 * 		3��������̬����������ʵ��������
 * 
 * ���������ģʽ
 * 		����ģʽ����ʱ�Ž��ж���Ĵ��������ô�����˭��˭������
 * 		����ģʽ��ֱ�ӽ��ж���Ĵ������ǳ�������
 * 
 * ��ȱ��
 * 		����ģʽ��ʵ��������ʱ��Ҫ�����жϣ�Ƶ��ʹ��ʱЧ�ʽϵ͡������ڵ��ò���ʮ��Ƶ���Ļ���
 * 		����ģʽ��ʵ����������Ҫ�����жϣ����ʹ�ò���ʮ��Ƶ�����ܻ������Դ���˷ѡ�������Ƶ��ʹ�õĻ���
 * @author Terry
 *
 */
public class Servlet {
	//1��˽�о�̬��Ա
	//����ģʽ���ӳټ��أ�
	private static Servlet instance = null;
	
	//����ģʽ��̰�����أ�
	private static Servlet instance2 = new Servlet();
	
	/**
	 * 2��˽�й��캯��
	 * �޲ι��캯��
	 */
	private Servlet() {
		//ÿ��ʵ����Servlet����ʱ�������init()����
		init();
	}
	
	/**
	 * 3��������̬�����������ķ���ֵ�뵱ǰ������ͬ������������ģʽ��
	 * ����Servlet���͵Ķ���
	 * 
	 * ˫�ؼ�飨double check��
	 */
	public static Servlet create(){
		if(instance == null)
			synchronized (Servlet.class) {
				if(instance ==null)
					instance = new Servlet();
			}
		
		return instance;
	}
	
	/**
	 * 3��������̬�����������ķ���ֵ�뵱ǰ������ͬ�������ڶ���ģʽ��
	 * 		�����Ѿ�����������Ҫ�ٴ��ж�
	 * @return
	 */
	public static Servlet create2(){
		return instance2;
	}
	
	
	/**
	 * init()��������ʼ��Servlet����
	 */
	private void init(){
		System.out.println("init() is do......");
	}
	
	
	
	/**
	 * service()��������Ӧ�û�������
	 */
	public void service(){
		System.out.println("service() is do ......");
	}
}
