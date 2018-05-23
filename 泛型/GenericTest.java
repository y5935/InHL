package lianxi;

import java.util.ArrayList;
import java.util.List;
/**
 * ����Ҳ�Ʒ�������ʵ�����ɾ��嵽һ��Ĺ���
 * ������ʵ����һ��ģ��
 * ������ʵ���ǽ����ͱ����������Ϳ��������һ�����иı䣩
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
		//������T���͵ı���
		T t = (T)"OK";
	}
	
	/**
	 * ���巺�ͷ���
	 * ��ʽ�����η� <����ռλ��> ����ֵ ������ �������б�
	 * @param v
	 */
	public <V> void show(V v){
		System.out.println(v.getClass()+"|"+v);
	}
	
	
	/**
	 * ���巺�ͷ���
	 *  �����ķ���ֵҲ�Ƿ��͵�
	 * @param v
	 * @return
	 */
	public <V> V show2(V v){
		return v;
		
	}
}
