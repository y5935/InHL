package cn.work.w1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Work01 {

	/**
	 * 随机 输入 n个数， 个数， 统计 每个 数出现 的次数 并输出每个数出现的次数
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		//存储随机输入的n个数
		List<Integer> numbers = new ArrayList<Integer>();
		
		//接收用户的键盘输入
		char isNext = ' ';
		do{
			System.out.print("请输入一个数：");
			numbers.add(input.nextInt());
			
			//询问是否继续输入
			System.out.print("是否继续输入（y/n):");
			isNext = input.next().charAt(0);
			
		}while(isNext=='y' || isNext == 'Y');
		
		//统计每个数出现的次数
		//存储每个数出现的次数
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		//遍历输入数字的集合
		for(int i : numbers){
			//判断Key集合中是否包含当前数值
			if(map.containsKey(i))
				//如果包含则计数器+1（value）
				map.put(i, map.get(i) + 1);
			else
				//否则将当前数字作为key并且添加到map集合中
				map.put(i, 1);
		}
		
		System.out.println("-----------------------------------");
		//输出统计结果
		for(Entry<Integer,Integer> item : map.entrySet()){
			System.out.println(item.getKey() + " = " + item.getValue());
		}
	}

}
