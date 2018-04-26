package cn.hl.test;

import java.util.Arrays;

import org.junit.Test;

public class Demo1 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		arr[0]=22;
		arr[1]=30;
		arr[2]=18;
	
		intsert(arr);
		
		
		//扩容使用
		int[] arr2 = Arrays.copyOf(arr, 20);
		
		for(int t : arr2)
			System.out.println(t);
		
		/*
		for(int t : arr)
			System.out.println(t);
		
		
		int result = find(-28,arr);
		if(result==-1)
			System.out.println("数组中不包含该元素");
		else
			System.out.println(result);
		
		
		delete(1,arr);
		
		for(int t : arr)
			System.out.println(t);
			*/
	}

	/**
	 * 删除数组arr中索引位置为i的元素
	 * @param i
	 * @param arr
	 */
	private static void delete(int index, int[] arr) {
		for(int i=index;i<arr.length-1;i++ ){
			arr[i] =arr[i+1];
		}
		
	}

	/**
	 * 查找数组中是否包含指定值得元素
	 * @param i
	 */
	private static int find(int val,int[] arr) {
		//遍历所有元素
		for(int i = 0;i<arr.length;i++){
			//将每一个元素与待查找值进行比对，如果值相等则返回索引
			if(arr[i] == val)
				return i;
		}
		//否则返回-1
		return -1;
	}

	/**
	 * 向给定的数组对象中的第2个位置插入一个-28
	 * @param arr
	 * @param index
	 * @param value
	 */
	private static void intsert(int[] arr) {
		//1)、对元素从后向前进行移动
		for(int i = arr.length-1;i>1;i--){
			arr[i] = arr[i-1];
		}
		//2)、插入-28
		arr[1] = -28;
	}
	
	
	
	/**
	 * 选择排序法实现升序排序
	 * 实现：
	 * 		用指定元素与其后的每一个元素进行比较。如果符合条件则进行交换。
	 */
	@Test
	public void sort1(){
		//定义数组
		int[] arr = {20,18,-66,34,109,87,0};
		
		for(int t : arr)
			System.out.print(t + "\t");
		
		
		//控制比较次数
		for(int i = 0;i<arr.length-1;i++){
			//控制每一次比较的元素的位置
			for(int j =i+1;j<arr.length;j++){
				//将指定元素与其后的每一个元素进行比较
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("\n-------------------------------------------------------\n");
		for(int t : arr)
			System.out.print(t + "\t");
	}
	
	/**
	 * 冒泡排序法实现数组排序
	 * 实现思路：
	 * 		相邻两个元素进行比较，如果符合条件则进行交换
	 */
	@Test
	public void sort2(){
		//定义数组
		int[] arr = {20,18,-66,34,109,87,0};
				
		for(int t : arr)
			System.out.print(t + "\t");
		
		//控制比较次数
		for(int i = 0;i<arr.length-1;i++){
			//控制比较的元素
			for(int j =0;j<arr.length-i-1;j++){
				//对元素进行比对
				if(arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
		
		System.out.println("\n-------------------------------------------------------\n");
		for(int t : arr)
			System.out.print(t + "\t");
	}
	
	/**
	 * copyOf()
	 */
	@Test
	public void arrays1(){
		//定义数组
		int[] arr = {20,18,-66,34,109};
		//创建一个指定长度的新数组对象
		//然后复制源数组的所有元素到新数组对象。复制的元素的个数与新数组的容量相关
		int[] newArray = Arrays.copyOf(arr, 3);
	}
	
	/**
	 * equals()
	 */
	@Test
	public void arrays2(){
		//定义数组
		int[] arr1 = {20,18,-66,34,109};
		int[] arr2 = {20,18,-66,34,108};
		
		//比较两个数组对象的元素内容是否相同
		boolean b = Arrays.equals(arr1, arr2);
		System.out.println("b= " + b);
	}
	
	/**
	 * fill()
	 */
	@Test
	public void arrays3(){
		//定义数组
		int[] arr1 = new int[10];
		//用指定的值填充数组对象
		Arrays.fill(arr1,20);
	}
	
	/**
	 * sort()
	 */
	@Test
	public void arrays4(){
		//定义数组
		int[] arr1 = {20,18,-66,34,109};
		//对指定数组对象进行升序排序
		Arrays.sort(arr1);
		
		
	}
}

