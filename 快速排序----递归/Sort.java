package lianxi;

/*
 * ���õݹ� ���п�������
 * ����������㷨�ǣ�
1��������������i��j������ʼ��ʱ��i=0��j=N-1��
2���Ե�һ������Ԫ����Ϊ�ؼ����ݣ���ֵ��key����key=A[0]��
3����j��ʼ��ǰ���������ɺ�ʼ��ǰ����(j--)���ҵ���һ��С��key��ֵA[j]����A[j]��A[i]������
4����i��ʼ�������������ǰ��ʼ�������(i++)���ҵ���һ������key��A[i]����A[i]��A[j]������
5���ظ���3��4����ֱ��i=j�� (3,4���У�û�ҵ�����������ֵ����3��A[j]��С��key,4��A[i]������key��ʱ��ı�j��i��ֵ��ʹ��j=j-1��i=i+1��ֱ���ҵ�Ϊֹ��
�ҵ�����������ֵ�����н�����ʱ��i�� jָ��λ�ò��䡣���⣬i==j��һ����һ��������i+��j-��ɵ�ʱ�򣬴�ʱ��ѭ����������*/
public class Sort {

	public static void main(String[] args) {
		int[] ints = { 5, 3, 7, 8, 2, 9, 4, 6 };
		
		sort(ints,0,ints.length-1);
		
		for (int j2 = 0; j2 < ints.length; j2++) {
			System.out.println(ints[j2]);
		}
	}

	static void sort(int[] ints, int s, int e) {
		if (s < e) {
			int index = sortUnit(ints, s, e);
			sort(ints,s,index-1);//���
			sort(ints,index+1,e);//�ұ�
			
		}
	}

	static int sortUnit(int[] ints, int s, int e) {
		int num = ints[s];// ���
		int i = s;// ��ʼλ��
		int j = e;// ����λ��
		while (i < j) {
			while (i < j) {
				if (ints[j] < num) {// j�����ұȱ��С��
					ints[i] = ints[j];
					break;
				}
				j--;
			}
			while (i < j) {
				if (ints[i] >= num) {
					ints[j] = ints[i];
					break;
				}
				i++;
			}
		}
		ints[i] = num;// ��i��j���ʱ
		return i;
	}
}
