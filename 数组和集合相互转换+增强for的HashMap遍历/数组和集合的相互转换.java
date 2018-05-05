package com.itheima.ArrayList���ϵĳ�������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test02_����ͼ��ϵ��໥ת�� {
	public static void main(String[] args) {
		/*
		 * ����ת����:
		 * 	 ArrayList#toArray();
		 * 
		 * ����ת����:
		 * 	Arrays#asList();
		 *  ע��:
		 *  	1. ����ת�ɼ���֮��, ���ܽ������ӻ���ɾ������, ���ǿ��Խ����޸Ĳ���.
		 *  	2. ����ǻ������͵�����ת�ɼ���, ��ô�ǰ��������鵱�����ϵ�һ��������ת��.
		 */
		Integer[] arr = {1,2,3,4,5};
		//������ת�ɼ���
		List<Integer> list = Arrays.asList(arr);
		//list.set(2, 30);
		System.out.println(list);
		
		System.out.println("*******************");
		int[] arr2 = {1,2,3,4,5};
		List<int[]> list2 = Arrays.asList(arr2);
		System.out.println(list2);
		
		//�ϱߵĴ�����ʵ�����������Ĵ���
		ArrayList<int[]> list3 = new ArrayList<>();
		list3.add(arr2);
	}
	
	//����ת����
	public static void method1() {
		//A. ArrayList�ܰ�,������Դ�Ų�ȷ�����ȵ�����
		ArrayList<String> list = new ArrayList<>();	//��list���ϸ�ֵ
		list.add("������");
		list.add("���޼�");
		list.add("ŷ����");
		list.add("���߹�");
		//ת����
		Object[] arr = list.toArray();
		System.out.println(Arrays.toString(arr));
	}
}
