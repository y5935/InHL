package lianxi;

public class DuiSort {
	public static void main(String[] args) {
		int[] ints = {5,7,2,5,8,9,3,4,6};
		int size = ints.length;
		while(size>2){
			//最大堆
			//循环所有的父节点（从后向前循环 ）
			for (int i =(size-1)/2; i>=1; i--) {
				//先找到最大的儿子
				int maxIndex = i*2;//假设最大的儿子为左儿子
				//右儿子存在且比左儿子大
				if((maxIndex+1)<size&&ints[maxIndex+1]>ints[maxIndex]){
					maxIndex++;
				}
				//最大儿子和父亲比较
				if(ints[maxIndex]>ints[i]){
					int temp = ints[maxIndex];
					ints[maxIndex]= ints[i];
					ints[i]=temp;
				}
			}
			//将根节点与最后一个节点进行交换 
			int data = ints[1];
			ints[1]=ints[size-1];
			ints[size-1]=data;
			size--;
			
			
			
		}
		for (int i =1 ; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
}
