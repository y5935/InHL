package singleleton;
/**
 * ����ģʽ��һ�ֳ��õ�������ģʽ�������ĺ��½ṹ��ֻ����һ������Ϊ������������ 
 * ͨ���������Ա�֤ϵͳ��һ����ֻ��һ��ʵ������֤�˶����Ψһ�ԡ�
 * 
 * ����ģʽ������ʽ��
 * 1.�ȹ���˽�еĹ��캯��
 * 2.�ڶ��⿪��һ�����Եõ���ǰ��Ĺ�������������ֵΪ��ǰ������ͣ�
 * 
 * ȱ��:ռ���ڴ�
 * 
 * @author Lens
 *
 */

public class Human {
	static Human human = new Human();
	private Human(){
		
	}
	
	public static Human getHuman(){
		return human;
	}
}
