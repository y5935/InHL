package cn.hl.test;

public class Tester {

	public static void main(String[] args) {
		//每页记录数为4条
		//1、假如现有10条记录，应该分3页（实际得到2页）
		System.out.println((int)Math.ceil(10 * 1.0/4));
		
		//2、假如现有11条记录，应该分3页（实际得到2页）
		System.out.println((int)Math.ceil(11 * 1.0/4));
		
		//3、假如现有12条记录，应该分3页（实际得到3页）
		System.out.println((int)Math.ceil(12 * 1.0/4));

		
		System.out.println("==========================================");
		System.out.println(10*1.0/4);
		System.out.println(11*1.0/4);
		System.out.println(12*1.0/4);
	}

}
