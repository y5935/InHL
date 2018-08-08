package cn.hl.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * 使用OGNL表达式读取数据
 * @author Terry
 *
 */
public class Tester {

	public static void main(String[] args) throws OgnlException {
		//1、创建OgnlContext对象
		OgnlContext c1 = new OgnlContext();
		//1)、存储数据简单数据
		//a、存储数据
		c1.put("name", "Mike");
		
		//b、读取数据
		//通过get方法直接进行读取
		String name = (String)c1.get("name");
		System.out.println("name = " + name);
		
		//2)、存储自定义(复杂)数据
		User u = new User("Jack","admin",20);
		//a、存储数据
		c1.put("user", u);
		
		//b、读取数据
		User temp = (User)c1.get("user");
		System.out.println(temp);
		
		//c、读取对象的userName属性
		//读取非根数据
		String userName = (String)c1.get("user.userName");
		//读取失败，值为null
		System.out.println("userName = " + userName);
		
		//d、传统读取方式
		String userName2 = ((User)c1.get("user")).getUserName();
		System.out.println("userNam2 =" + userName2);
		
		//e、Ognl读取
		//非根数据#访问
		Object obj1 = Ognl.getValue("#user.userName", c1, c1.getRoot());
		System.out.println("obj1 = " + obj1);
		
		
		//2、存储根数据
		OgnlContext c2 = new OgnlContext();
		//1)、将u设置为根
		c2.setRoot(u);
		
		//2)、读取根数据
		//根数据直接访问
		Object obj2 = Ognl.getValue("userName", c2,c2.getRoot());
		System.out.println("obj2 = " + obj2);
		
	}
}
