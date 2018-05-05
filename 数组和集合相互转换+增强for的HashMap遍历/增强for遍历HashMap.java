package com.itheima.HashMap集合的常见方法;

import java.util.HashMap;
import java.util.Set;

public class Test03_增强for {
	public static void main(String[] args) {
		/*
		 * 用增强for遍历集合:
		 * 	
		 * 双列集合的第一种遍历方式: 根据键获取值.
		 * 	1. 获取到双列集合中所有 键的集合.    HashMap#keySet();
		 *  2. 遍历键的集合, 获取到每一个键.	        增强for
		 *  3. 根据键获取对应的值.		   HashMap#get();
		 */
		HashMap<String,String> hm = new HashMap<>();
		hm.put("杨过", "小龙女");
		hm.put("郭靖", "黄蓉");
		hm.put("盖伦", "亚索");
		
		Set<String> keys = hm.keySet();	 //1
		for(String key : keys) {		 //2
			String value = hm.get(key);  //3
			System.out.println(key + "..." + value);
		}
		System.out.println("**********************");
		
		for(String key : hm.keySet()) {
			System.out.println(key + "..." + hm.get(key));
		}
	}

	public static void method1() {
		int[] arr = {11, 22, 33, 44, 55};
		/*
		 * 需求: 遍历数组
		 * 可以考虑通过 增强for实现
		 * 
		 * 格式:
		  	for(数据类型 变量名 : 要遍历的集合或者数组) {
		    	//正常的逻辑代码
		    }
		    
		        作用:
		           就是用来遍历数组或者集合的.
		 */
		for(int num : arr) { //这里的num就是数组中的 某一个元素
			System.out.println(num);
		}
	}
}
