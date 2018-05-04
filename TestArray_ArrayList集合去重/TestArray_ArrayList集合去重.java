package com.itheima.补充知识点;

import java.util.ArrayList;
import java.util.HashSet;

public class TestArray_ArrayList集合去重 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();		//有序(存取一致), 可重复
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("b");
		list.add("d");
		list.add("c");
		list.add("e");
		
		/*
		 * 思路二: 通过Set集合(无序, 唯一)实现.
		 */
		HashSet<String> hs = new HashSet<>();		//创建Set集合
		hs.addAll(list);			//把list集合中的元素添加到Set集合中
		list.clear();				//清空list集合
		list.addAll(hs);			//把set集合中的元素(去重后的元素) 添加到list集合中
		System.out.println(list);	//打印list集合
	}

	public static void method1(ArrayList<String> list) {
		/*
		 * 思路一: 创建新集合, 然后遍历老集合, 看当前遍历到的元素是否在新集合中存在,
		 * 	     存在不添加, 不存在,就添加. 遍历完之后, 新集合中村的就是所有的不重复元素.
		 */
		//创建新集合,
		ArrayList<String> newList = new ArrayList<>();
		//然后遍历老集合, 
		for (String str : list) {
			// 看当前遍历到的元素是否在新集合中存在,存在不添加, 不存在,就添加.
			if (!newList.contains(str)) {
				newList.add(str);
			}
		}
		System.out.println(newList);
	}
}
