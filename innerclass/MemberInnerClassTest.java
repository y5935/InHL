package innerclass;
/**
 * ��Ա�ڲ�����Ե�ͬ������Ա����
 * ��Ա�ڲ�������ÿ��Ʒ���Ȩ�����η�����
 * ��Ա�ڲ��಻���о�̬����
 * ��Ա�ڲ�����Է����ⲿ�����������
 * 
 * @author Lens
 *
 */
public class MemberInnerClassTest {
	//��Ա����
	int i  = 1;
	//��̬����
	static int s =10;
	//��Ա����
	public void m1(){
		System.out.println(s);
		m2();
	}
	//��̬����
	public static void m2(){}
	
	
	
	
	//��Ա�ڲ���
	class InnerClass{
		//��̬����
		//public static void m3(){}   ��̬����������
		//static int  k = 1;          ��̬���Բ�����
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
