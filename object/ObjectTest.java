package object;
/**
 * java�е�Object
 * 1.toString��equals��������Object�У�
 * 2.Object����java�еĸ��ࣻ
 * 3.һ�������û����ʽ�ļ̳������࣬������Ĭ�ϼ̳���Object�ࡣ
 * 
 * @author Lens
 *
 */
public class ObjectTest {

	public static void main(String[] args) {
		/*toString ���������Ҫ�Ķ���
		Person p = new Person();
		p.name="����";
		p.age=18;
		System.out.println(p);
		System.out.println(p.toString());
		*/
		
		
		Person p1 = new Person("����",25);
		Person p2 = new Person("����",25);
		System.out.println(p1==p2);//�����false
		//���ϴ���֮�������false����Ϊ��==���Ƚϵ����ڴ��ַ
		
		//equals�����������Ƚ����ݵ�(���Ը��������Զ���д�ж� equals)��
		System.out.println(p1.equals(p2));// �����false
		System.out.println(p1.equals(p1));//�����true
		
	}

}
