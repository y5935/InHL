package cn.work.w1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Work01 {

	/**
	 * ��� ���� n������ ������ ͳ�� ÿ�� ������ �Ĵ��� �����ÿ�������ֵĴ���
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		//�洢��������n����
		List<Integer> numbers = new ArrayList<Integer>();
		
		//�����û��ļ�������
		char isNext = ' ';
		do{
			System.out.print("������һ������");
			numbers.add(input.nextInt());
			
			//ѯ���Ƿ��������
			System.out.print("�Ƿ�������루y/n):");
			isNext = input.next().charAt(0);
			
		}while(isNext=='y' || isNext == 'Y');
		
		//ͳ��ÿ�������ֵĴ���
		//�洢ÿ�������ֵĴ���
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		//�����������ֵļ���
		for(int i : numbers){
			//�ж�Key�������Ƿ������ǰ��ֵ
			if(map.containsKey(i))
				//��������������+1��value��
				map.put(i, map.get(i) + 1);
			else
				//���򽫵�ǰ������Ϊkey������ӵ�map������
				map.put(i, 1);
		}
		
		System.out.println("-----------------------------------");
		//���ͳ�ƽ��
		for(Entry<Integer,Integer> item : map.entrySet()){
			System.out.println(item.getKey() + " = " + item.getValue());
		}
	}

}
