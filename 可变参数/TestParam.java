package cn.hl.test;

public class TestParam {
	public static void main(String[] args) {
		//�����Ĵ��ݷ�ʽ���Ӷ������
		//1��ֱ�Ӵ���
		//�������
		//print1(20,44,45,60);
		//��������
 		//print2(20,44,45,60);
		
		//2��������
		//�������
		//print1();
		//��������
		print2();
		
		//3����������
		//print1(new int[]{20,45});
		//print2(new int[]{20,45});
	}

	/**
	 * ��ӡ���������е�����Ԫ��
	 * @param list
	 */
	private static void print2(int...list) {
		for(int i : list){
			System.out.println(i);
		}
		
	}
	
	/**
	 * ��ӡ���������е�����Ԫ��
	 * @param list
	 */
	private static void print1(int[] list) {
		for(int i : list){
			System.out.println(i);
		}
		
	}
}
