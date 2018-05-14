package sort;

public class Sort01 {
	/**
	 * 选择排序法实现升序排序
	 * 比较次数：元素个数-1次。
	 * 思想：  固定位置的元素和其后的每一个元素进行比较。
	 * 实现：
	 * 		用指定元素与其后的每一个元素进行比较。如果符合条件则进行交换。
	 */
	public void sort1(){
		//定义数组
		int[] arr = {20,18,-66,34,109,87,0};
		
		
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
		
	}

	
	
	/**
	 * 冒泡排序法实现数组排序
	 * 相邻的两个元素进行比较。上浮后的结果不需要再次进行比较。
	 * 实现思路：
	 * 		相邻两个元素进行比较，如果符合条件则进行交换
	 */

	public void sort2(){
		//定义数组
		int[] arr = {20,18,-66,34,109,87,0};
				
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
	}
	
	
	/**
	 * 二分 查找法：
	 * 必须有前提：数组中的元素要有序
	 * @param arr
	 * @param key
	 * @return
	 */
	public  static int halfSeach_2(int[]arr,int key){
		int min,max,mid;
		min = 0;
		max = arr.length-1;
		mid = (min+max)/2;
		while(arr[mid]!=key){
			if(key>arr[mid]){
				min = mid +1;
			}
			else if(key<arr[mid]){
				max = mid -1;
			}
			if(max<min)
				return - 1;
			mid = (min+max)/2;	
		}
		return mid;
	}

}
