package com.itheima.HashMap���ϵĳ�������;

import java.util.HashMap;
import java.util.Set;

public class Test03_��ǿfor {
	public static void main(String[] args) {
		/*
		 * ����ǿfor��������:
		 * 	
		 * ˫�м��ϵĵ�һ�ֱ�����ʽ: ���ݼ���ȡֵ.
		 * 	1. ��ȡ��˫�м��������� ���ļ���.    HashMap#keySet();
		 *  2. �������ļ���, ��ȡ��ÿһ����.	        ��ǿfor
		 *  3. ���ݼ���ȡ��Ӧ��ֵ.		   HashMap#get();
		 */
		HashMap<String,String> hm = new HashMap<>();
		hm.put("���", "С��Ů");
		hm.put("����", "����");
		hm.put("����", "����");
		
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
		 * ����: ��������
		 * ���Կ���ͨ�� ��ǿforʵ��
		 * 
		 * ��ʽ:
		  	for(�������� ������ : Ҫ�����ļ��ϻ�������) {
		    	//�������߼�����
		    }
		    
		        ����:
		           ������������������߼��ϵ�.
		 */
		for(int num : arr) { //�����num���������е� ĳһ��Ԫ��
			System.out.println(num);
		}
	}
}
