package cn.hl.test;

public class TestParam {
	public static void main(String[] args) {
		//参数的传递方式更加多样灵活
		//1、直接传递
		//编译错误
		//print1(20,44,45,60);
		//正常运行
 		//print2(20,44,45,60);
		
		//2、不传递
		//编译错误
		//print1();
		//正常运行
		print2();
		
		//3、传递数组
		//print1(new int[]{20,45});
		//print2(new int[]{20,45});
	}

	/**
	 * 打印参数数组中的所有元素
	 * @param list
	 */
	private static void print2(int...list) {
		for(int i : list){
			System.out.println(i);
		}
		
	}
	
	/**
	 * 打印参数数组中的所有元素
	 * @param list
	 */
	private static void print1(int[] list) {
		for(int i : list){
			System.out.println(i);
		}
		
	}
}
