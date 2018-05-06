package com.itheima.test;

import java.io.File;

public class Test06_File类的其他功能 {
	public static void main(String[] args) {
		/*
		 * String[] list();			//获取指定目录下所有的文件(夹)的名称数组
		 * File[] listFiles();		//获取指定目录下所有的文件(夹)的对象数组
		 */
		/*
		 * 打印出C盘下所有的后缀名为.jpg的文件
		 * 1. 获取到C盘下所有的文件(夹)对象.
		 * 2. 遍历, 获取到每一个文件(夹)对象.
		 * 3. 判断遍历到的对象是否是文件, 并且后缀名是否是.jpg
		 * 	  如果不是: 什么都不操作
		 * 	  如果式: 就打印
		 * 
		 * 获取到所有的, 然后逐个做判断.
		 */
		
		File file = new File("C:\\");			//1
		File[] listFiles = file.listFiles();	
		for (File listFile : listFiles) {		//2
			if (listFile.isFile() && listFile.getName().endsWith(".jpg")) {  //3
				System.out.println(listFile);
			}
		}
		
	}

	public static void method() {
		File file = new File("c:\\");
		String[] list = file.list();
		//遍历数组
		for (String string : list) {
			System.out.println(string);
		}
		
		System.out.println("*****************");
		
		File[] listFiles = file.listFiles();
		//遍历数组
		for (File listFile : listFiles) {
			System.out.println(listFile);
		}
	}
}
