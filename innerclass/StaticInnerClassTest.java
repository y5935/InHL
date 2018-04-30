package innerclass;
/**
 *
 * ��̬�ڲ�����Ե�ͬ������̬����
 * ��̬�ڲ����ܱ����Ʒ���Ȩ�޷�����
 * ��̬�ڲ������ֱ�ӷ����ⲿ��ľ�̬���ݣ����ǲ���ֱ�ӷ��ʳ�Ա
 * @author Lens
 *
 */
public class StaticInnerClassTest {
	
	//��̬����
	static int i1 = 10;
	//��Ա����
	int i2 = 20;
	//��̬����
	public static void m1(){}
	//��Ա����
	public void m2(){}
	//��̬�ڲ���
	public static class InnerClass{
		static int i3 = 10;
		static void m3(){}
		int i4 = 10;
		
		void m4(){
			System.out.println(i1);
			//System.out.println(i2);
			m1();
			//m2();
		}
	}
	
	public static void main(String[] args) {
		InnerClass in = new StaticInnerClassTest.InnerClass(); 
	}
	
}
