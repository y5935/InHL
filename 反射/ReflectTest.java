package cn.hl.reflect;

import java.lang.reflect.Field;

/**
 * ����
 * 		һ�ּ�������������ȥ��̬����һ�����󲢷��ʶ���ĳ�Ա
 *    	��ָ�ڳ������й����У����Զ�̬��ȡ���͵���Ϣ�����󼰳�Ա��һ���ֶΡ�
 */
/**
Class
		1��Class
			��ʵ����������ڶ�����ڲ�������һ��Class���͵Ķ���Class���Ͷ�����ڲ�������
				�汾��
				��Ա����(�����ء��ֶΡ�������....)
			Class���ǿ��԰������Ϊ�����ģ��
		2����ȡClass���͵Ķ���
			1)����ʽһ��ͨ�������ȡClass���͵Ķ������ģ�壩
			Person p = new Person();
			Class c1 = p.getClass();
			2)����ʽ����ͨ�����class���Ի�ȡ���͵Ķ���
			Class c2 = Person.class;
			3)����ʽ����ͨ��������ƽ��л�ȡ����Ҫ�ṩ����·����
			Class c3= Class.forName("cn.hl.clazz.Person");	
*/
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
	
		//��ȡ���͵����ͣ�Class��
		Class c1 = User.class;
		Class c2 = new User().getClass();
		Class c3 = Class.forName("cn.hl.reflect.User");
		
		//���ַ�ʽ��õĶ����ֵʱ��ͬ��
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
		
		
		/*
		User u = new User();
		System.out.println("before =" + u.getName());
		
		getField(c1,u);
		
		System.out.println("after =" + u.getName());
		*/
		
		//��̬����User���͵Ķ��󲢽��и�ֵ
		User u = createObj(c2);
		System.out.println(u);
		
	}

	private static <T> T createObj(Class<T> cls) throws InstantiationException, IllegalAccessException {
		//����һ��T���͵Ķ���
		T t = cls.newInstance();
		
		//��ȡ��������г�Ա�ֶ�
		Field[] fields = cls.getDeclaredFields();
		
		//���������ֶβ���ֵ
		for(Field f : fields){
			f.setAccessible(true);
			if(f.getType() == String.class)
				f.set(t, "�����ַ�����ֵ");
			else if(f.getType() == int.class)
				f.set(t, 100);
		}
		
		return t;
	}

	/**
	 * ��ȡָ�����͵����г�Ա�ֶ�
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void getField(Class<User> cls, User u) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//��ȡcls�����й��г�Ա�ֶ�
		//getFields()	����ȡ���͵����й����ֶ�
		Field[] fields = cls.getFields();
		for(Field f : fields){
			System.out.println(f.getType() + " | " + f.getName() + " | " + f.getModifiers());
		}
		
		System.out.println("-------------------------------------------------------------");
				
		//getDeclaredFields()	����ȡ���͵����г�Ա�ֶ�
		Field[] fields2 = cls.getDeclaredFields();
		for(Field f : fields2){
			System.out.println(f.getType() + " | " + f.getName() + " | " + f.getModifiers());
		}
		
		//Ϊ��Ա�ֶθ�ֵ
		//��ȡ�ֶ�
		Field f = cls.getDeclaredField("name");
		
		f.set(u, "Haha");
	}

}

/**
 * �û���
 * 
 */
class User{
	private int id;
	protected String name;
	public int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
