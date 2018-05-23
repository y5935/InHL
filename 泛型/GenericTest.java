package lianxi;

import java.util.ArrayList;
import java.util.List;
/**
 * 泛型也称泛化，其实就是由具体到一般的过程
 * 泛型其实就是一个模板
 * 泛型其实就是将类型变量化（类型可以向变量一个进行改变）
 */
public class GenericTest {

	public static void main(String[] args) {

		List<Object> list = getList();
		List<Object> list2 = getList2();
		System.out.println(list);
		System.out.println(list2);
	}
	
	public static <T> List<T> getList(){
		List<Integer> list  = new ArrayList<Integer>();
		list.add(20);
		list.add(58);
		return (List<T>) list;
	} 
	
	public static <T> List<T> getList2(){
		List<String> list2  = new ArrayList<String>();
		list2.add("nihao");
		return (List<T>) list2;
	}
	
	
	class Student<T,A,K>{
		//定义了T类型的变量
		T t = (T)"OK";
	}
	
	/**
	 * 定义泛型方法
	 * 格式：修饰符 <类型占位符> 返回值 方法名 （参数列表）
	 * @param v
	 */
	public <V> void show(V v){
		System.out.println(v.getClass()+"|"+v);
	}
	
	
	/**
	 * 定义泛型方法
	 *  方法的返回值也是泛型的
	 * @param v
	 * @return
	 */
	public <V> V show2(V v){
		return v;
		
	}
}
