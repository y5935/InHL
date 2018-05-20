package lianxi;

/*
 * 利用递归 进行快速排序
 * 快速排序的算法是：
1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，使得j=j-1，i=i+1，直至找到为止。
找到符合条件的值，进行交换的时候i， j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。*/
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
			sort(ints,s,index-1);//左边
			sort(ints,index+1,e);//右边
			
		}
	}

	static int sortUnit(int[] ints, int s, int e) {
		int num = ints[s];// 标杆
		int i = s;// 开始位置
		int j = e;// 结束位置
		while (i < j) {
			while (i < j) {
				if (ints[j] < num) {// j负责找比标杆小的
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
		ints[i] = num;// 当i和j相等时
		return i;
	}
}
