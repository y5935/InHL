package cn.hl.list;

import java.util.Arrays;

/**
 * 模拟ArrayList实现可扩容的数组对象
 * @author X230
 *
 */
public class MyArray {
	//容器，存储int类型数据
	int[] arr;
	//记录当前的索引位置
	int index =-1;
	
	/**
	 * 无参构造
	 * 对arr数组进行初始化，默认容量为4个长度
	 */
	public MyArray() {
		arr = new int[4];
	}
	
	/**
	 * 带参构造
	 * 允许用户自定义arr数组的初始容量
	 * @param capacity
	 */
	public MyArray(int capacity){
		arr = new int[capacity];
	}
	
	/**
	 * 向数组对象中添加数据
	 * @param val
	 */
	public void add(int val){
		//判断数组是否已满，如果已满则对数组arr进行扩容
		//扩容公式：数组长度/2*3
		if(++index == arr.length)
			arr = Arrays.copyOf(arr,(4>>1) *3);
		
		arr[index]=val;
	}
	
	/**
	 * 获取指定索引位置元素的值
	 * @param i
	 * @return
	 */
	public int get(int i){
		//判断索引位置是否合法。索引位置不合法将产生异常
		if(i <0 || i >=arr.length)
			throw new IndexOutOfBoundsException("索引超出合法范围");
		
		//合法则直接返回元素值
		return arr[i];
	}
	
	/**
	 * 设置指定索引位置的元素值
	 * @param i		：元素值
	 * @param idx	：索引位置
	 */
	public void set(int i,int idx){
		//判断索引位置是否合法，索引位置不合法将产生异常
		if(idx <0 || idx>=arr.length)
			throw new IndexOutOfBoundsException("索引超出合法范围");
		
		//修改指定索引位置元素的值
		arr[idx] = i;
	}
	
	/**
	 * 移除指定索引位置元素的值
	 * @param idx
	 */
	public void remove(int idx){
		//判断待移除元素的索引位置是否合法，如果不合法则抛出异常
		if(idx<0 || idx>=arr.length)
			throw new IndexOutOfBoundsException("索引超出合法范围");
		
		//判断待移除元素是否是最后一个有效元素，如果是则直接将该元素设置为默认值0，同时将索引下标-1
		if(idx==index)
			arr[index--] =0;
		//判断移除元素的索引范围是否在0~index之间，如果是则进行移除操作
		else if(idx>=0 && idx<index){
			for(int i = idx;i<index;i++)
				arr[i] = arr[i+1];
			//将最后一个元素的值设置为默认值，同时index索引下标-1
			arr[index--] =0;
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param idx
	 */
	public void insert(int i,int idx){
		//判断待移除元素的索引位置是否合法，如果不合法则抛出异常
		if(idx<0 || idx>=arr.length)
			throw new IndexOutOfBoundsException("索引超出合法范围");
		
		if(idx>index && idx<arr.length){
			arr[idx]= i;
			index = idx;
		}
		else{
			//通过循环的方式从后向前移动元素
			for(int j = index+1;j>idx;j--){
				arr[j] = arr[j-1];
			}
			//修改指定索引位置元素的值
			arr[idx]=i;
			index++;
		}
	}
	
	/**
	 * 获取数组的长度
	 * @return
	 */
	public int length(){
		return arr.length;
	}
	
	/**
	 * 获取数组中元素的个数
	 * @return
	 */
	public int count(){
		return index+1;
	}
}
