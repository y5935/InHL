package cn.hl.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		//资源对应的角色列表
		String role1 = "3/4/5/15";
		//用户的角色
		String str = "1";
		
		String str2 = "1/6";
		
		//method1(role1,str);
		
		//method2(role1,str2);
		
		method3(role1,str2);
	}

	private static void method3(String role1, String str2) {
		Set<String> set1 = new HashSet<String>();
		set1.add("a");
		set1.add("b");
		set1.add("d");
		
		Set<String> set2 = new HashSet<String>();
		//set2.add("b");
		set2.add("f");
		
		boolean b = set1.retainAll(set2);
		System.out.println(set1.size()>0);
		
	}

	/**
	 * 将role1按照字符分隔符进行拆分，然后进行比对
	 * @param role1
	 * @param str2
	 */
	private static void method2(String role1, String str2) {
		String[] arr = role1.split("/");
		
		String[] arr2 = str2.split("/");
		
		for(String temp : arr){
			for(String str : arr2){
				if(str.equals(temp)){
					System.out.println("true");
					return;
				}
			}
		}
		System.out.println("false");
	}

	/**
	 * 方式1：通过字符串的包含方式进行判断
	 * @param role1
	 * @param str
	 */
	private static void method1(String role1, String str) {
		boolean b = role1.contains(str);
		System.out.println("b = " + b);		
	}
	
	
	
	
}
