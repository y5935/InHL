package innerclass;
/**
 * �ֲ��ڲ����ͬ�ھֲ�����
 * �ֲ��ڲ��಻���÷��ʿ���Ȩ�޷�����
 * �ֲ��ڲ��಻���о�̬����
 * �ص㣺�ֲ��ڲ����ڷ��ʾֲ�������ʱ�򣬾ֲ���������ʹ��final����
 *     �ֲ��ڲ����ڷ��ʳ�Ա������ʱ����Ҫ������ֱ�ӷ���
 * @author Lens
 *
 */

public class PartInnerClassTest {
	int a = 1;
	public void m1(){
		//�ֲ�����
		final int i= 10;
		//�ֲ��ڲ���
		class InnerClass{
			//��̬����
			//public static void m2(){}
			public void m3(){
				System.out.println(i);
				System.out.println(a);
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		PartInnerClassTest pct = new PartInnerClassTest();
		System.out.println(pct.a);
		//System.out.println(pct.i);����
		pct.m1();
	}

}
