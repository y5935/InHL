package cn.hl.test;

public class Boxing {
	/*
	1��������װ��
	1����װ�䣨Boxing��
		��ֵ����תΪ�������͵Ĺ��̳�Ϊװ�䡣װ��һ�����Զ���ɵġ�
		eg:
			//ֵ��������
			int i = 20;
			//����ֵ���͸�ֵ���������Ͷ���(ֵ���� ---����������)
			String str = String.valueOf(i);
			Object o = i;
	2�������䣨UnBoxing��
		��������������תΪֵ�������ݵĹ��̾ͳ�Ϊ���䡣����һ����Ҫǿ�ƽ���ת����
		eg:
			//ֵ��������
			int i = 20;
			//����ֵ���͸�ֵ���������Ͷ���(ֵ���� ---����������)
			String str = String.valueOf(i);
			Object o = i;
			
			//��������������תΪֵ��������(�������� ---��ֵ����)
			int m = (int)o;
			int n = Integer.parseInt(str);
	3����ȱ��
		a�������װ�����ɴ���Ч�ʵ��½�
		b����������д����Ŵ��밲ȫ������
	4��������
		�����о������ٲ����װ�������
	 */

	public static void main(String[] args) {
		//ֵ��������
		int i = 20;
		//����ֵ���͸�ֵ���������Ͷ���(ֵ���� ---����������)
		String str = String.valueOf(i);
		Object o = i;
		
		o = "haha";
		//��������������תΪֵ��������(�������� ---��ֵ����)
		int m = (int)o;
		int n = Integer.parseInt(str);
		
	}
}
