package cn.hl.reflect;

import java.lang.reflect.Field;

/**
 * 反射
 * 		一种技术，允许我们去动态创建一个对象并访问对象的成员
 *    	是指在程序运行过程中，可以动态获取类型的信息、对象及成员的一种手段。
 */
/**
Class
		1、Class
			在实例化对象后，在对象的内部会生成一个Class类型的对象。Class类型对象的内部包含：
				版本号
				成员描述(常量池、字段、方法表....)
			Class我们可以把它理解为：类的模板
		2、获取Class类型的对象
			1)、方式一：通过对象获取Class类型的对象（类的模板）
			Person p = new Person();
			Class c1 = p.getClass();
			2)、方式二：通过类的class属性获取类型的对象
			Class c2 = Person.class;
			3)、方式三：通过类的名称进行获取（需要提供完整路径）
			Class c3= Class.forName("cn.hl.clazz.Person");	
*/
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
	
		//获取类型的类型（Class）
		Class c1 = User.class;
		Class c2 = new User().getClass();
		Class c3 = Class.forName("cn.hl.reflect.User");
		
		//三种方式获得的对象的值时相同的
		System.out.println(c1 == c2);
		System.out.println(c1 == c3);
		
		
		/*
		User u = new User();
		System.out.println("before =" + u.getName());
		
		getField(c1,u);
		
		System.out.println("after =" + u.getName());
		*/
		
		//动态创建User类型的对象并进行赋值
		User u = createObj(c2);
		System.out.println(u);
		
	}

	private static <T> T createObj(Class<T> cls) throws InstantiationException, IllegalAccessException {
		//创建一个T类型的对象
		T t = cls.newInstance();
		
		//获取对象的所有成员字段
		Field[] fields = cls.getDeclaredFields();
		
		//遍历所有字段并赋值
		for(Field f : fields){
			f.setAccessible(true);
			if(f.getType() == String.class)
				f.set(t, "这是字符串的值");
			else if(f.getType() == int.class)
				f.set(t, 100);
		}
		
		return t;
	}

	/**
	 * 获取指定类型的所有成员字段
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private static void getField(Class<User> cls, User u) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//获取cls的所有公有成员字段
		//getFields()	：获取类型的所有公共字段
		Field[] fields = cls.getFields();
		for(Field f : fields){
			System.out.println(f.getType() + " | " + f.getName() + " | " + f.getModifiers());
		}
		
		System.out.println("-------------------------------------------------------------");
				
		//getDeclaredFields()	：获取类型的所有成员字段
		Field[] fields2 = cls.getDeclaredFields();
		for(Field f : fields2){
			System.out.println(f.getType() + " | " + f.getName() + " | " + f.getModifiers());
		}
		
		//为成员字段赋值
		//获取字段
		Field f = cls.getDeclaredField("name");
		
		f.set(u, "Haha");
	}

}

/**
 * 用户类
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
