package com.itheima.ArrayList集合的常见方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test02_数组和集合的相互转换 {
	public static void main(String[] args) {
		/*
		 * 集合转数组:
		 * 	 ArrayList#toArray();
		 * 
		 * 数组转集合:
		 * 	Arrays#asList();
		 *  注意:
		 *  	1. 数组转成集合之后, 不能进行增加或者删除操作, 但是可以进行修改操作.
		 *  	2. 如果是基本类型的数组转成集合, 那么是把整个数组当做集合的一个对象来转的.
		 */
		Integer[] arr = {1,2,3,4,5};
		//把数组转成集合
		List<Integer> list = Arrays.asList(arr);
		//list.set(2, 30);
		System.out.println(list);
		
		System.out.println("*******************");
		int[] arr2 = {1,2,3,4,5};
		List<int[]> list2 = Arrays.asList(arr2);
		System.out.println(list2);
		
		//上边的代码其实类似于这样的代码
		ArrayList<int[]> list3 = new ArrayList<>();
		list3.add(arr2);
	}
	
	//集合转数组
	public static void method1() {
		//A. ArrayList很棒,里面可以存放不确定长度的数据
		ArrayList<String> list = new ArrayList<>();	//给list集合赋值
		list.add("张三丰");
		list.add("张无忌");
		list.add("欧阳锋");
		list.add("洪七公");
		//转数组
		Object[] arr = list.toArray();
		System.out.println(Arrays.toString(arr));
	}
}
