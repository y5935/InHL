package sort;

public class Sort01 {
	/**
	 * ѡ������ʵ����������
	 * �Ƚϴ�����Ԫ�ظ���-1�Ρ�
	 * ˼�룺  �̶�λ�õ�Ԫ�غ�����ÿһ��Ԫ�ؽ��бȽϡ�
	 * ʵ�֣�
	 * 		��ָ��Ԫ��������ÿһ��Ԫ�ؽ��бȽϡ����������������н�����
	 */
	public void sort1(){
		//��������
		int[] arr = {20,18,-66,34,109,87,0};
		
		
		//���ƱȽϴ���
		for(int i = 0;i<arr.length-1;i++){
			//����ÿһ�αȽϵ�Ԫ�ص�λ��
			for(int j =i+1;j<arr.length;j++){
				//��ָ��Ԫ��������ÿһ��Ԫ�ؽ��бȽ�
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}

	
	
	/**
	 * ð������ʵ����������
	 * ���ڵ�����Ԫ�ؽ��бȽϡ��ϸ���Ľ������Ҫ�ٴν��бȽϡ�
	 * ʵ��˼·��
	 * 		��������Ԫ�ؽ��бȽϣ����������������н���
	 */

	public void sort2(){
		//��������
		int[] arr = {20,18,-66,34,109,87,0};
				
		//���ƱȽϴ���
		for(int i = 0;i<arr.length-1;i++){
			//���ƱȽϵ�Ԫ��
			for(int j =0;j<arr.length-i-1;j++){
				//��Ԫ�ؽ��бȶ�
				if(arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	
	
	/**
	 * ���� ���ҷ���
	 * ������ǰ�᣺�����е�Ԫ��Ҫ����
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
