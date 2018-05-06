package com.itheima.test;

import java.io.File;

public class Test06_File����������� {
	public static void main(String[] args) {
		/*
		 * String[] list();			//��ȡָ��Ŀ¼�����е��ļ�(��)����������
		 * File[] listFiles();		//��ȡָ��Ŀ¼�����е��ļ�(��)�Ķ�������
		 */
		/*
		 * ��ӡ��C�������еĺ�׺��Ϊ.jpg���ļ�
		 * 1. ��ȡ��C�������е��ļ�(��)����.
		 * 2. ����, ��ȡ��ÿһ���ļ�(��)����.
		 * 3. �жϱ������Ķ����Ƿ����ļ�, ���Һ�׺���Ƿ���.jpg
		 * 	  �������: ʲô��������
		 * 	  ���ʽ: �ʹ�ӡ
		 * 
		 * ��ȡ�����е�, Ȼ��������ж�.
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
		//��������
		for (String string : list) {
			System.out.println(string);
		}
		
		System.out.println("*****************");
		
		File[] listFiles = file.listFiles();
		//��������
		for (File listFile : listFiles) {
			System.out.println(listFile);
		}
	}
}
