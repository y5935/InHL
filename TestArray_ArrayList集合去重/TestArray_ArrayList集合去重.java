package com.itheima.����֪ʶ��;

import java.util.ArrayList;
import java.util.HashSet;

public class TestArray_ArrayList����ȥ�� {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();		//����(��ȡһ��), ���ظ�
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("b");
		list.add("d");
		list.add("c");
		list.add("e");
		
		/*
		 * ˼·��: ͨ��Set����(����, Ψһ)ʵ��.
		 */
		HashSet<String> hs = new HashSet<>();		//����Set����
		hs.addAll(list);			//��list�����е�Ԫ����ӵ�Set������
		list.clear();				//���list����
		list.addAll(hs);			//��set�����е�Ԫ��(ȥ�غ��Ԫ��) ��ӵ�list������
		System.out.println(list);	//��ӡlist����
	}

	public static void method1(ArrayList<String> list) {
		/*
		 * ˼·һ: �����¼���, Ȼ������ϼ���, ����ǰ��������Ԫ���Ƿ����¼����д���,
		 * 	     ���ڲ����, ������,�����. ������֮��, �¼����д�ľ������еĲ��ظ�Ԫ��.
		 */
		//�����¼���,
		ArrayList<String> newList = new ArrayList<>();
		//Ȼ������ϼ���, 
		for (String str : list) {
			// ����ǰ��������Ԫ���Ƿ����¼����д���,���ڲ����, ������,�����.
			if (!newList.contains(str)) {
				newList.add(str);
			}
		}
		System.out.println(newList);
	}
}
