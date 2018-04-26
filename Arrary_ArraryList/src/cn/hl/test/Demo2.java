package cn.hl.test;

import cn.hl.list.MyArray;

public class Demo2 {

	public static void main(String[] args) {
		/*
		//++ 对变量自身执行+1运算。相当于：变量=变量+1；
		int i = 20;
		
		
		//前自加运算：首先执行对变量自身的+1运算，然后在执行其他运算
		System.out.println(++i);
		System.out.println(i);
		
		相当于
		
		i = i+1;
		System.out.println(i);
		System.out.println(i);
		
		//后自加运算：首先执行其他运算，然后在执行对变量自身的+1运算
		System.out.println(i++);
		System.out.println(i);
		
		相当于
		
		System.out.println(i);
		i=i+1;
		System.out.println(i);
		*/
		
		
		
		MyArray arr = new MyArray();
		
		arr.add(1);
		arr.add(-100);
		arr.add(10);
		arr.add(-90);
		arr.add(10);		
		
		arr.insert(0, 2);
	}

}
