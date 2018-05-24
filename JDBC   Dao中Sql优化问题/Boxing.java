package cn.hl.test;

public class Boxing {
	/*
	1、拆箱与装箱
	1）、装箱（Boxing）
		将值类型转为引用类型的过程称为装箱。装箱一般是自动完成的。
		eg:
			//值类型数据
			int i = 20;
			//将数值类型赋值给引用类型对象(值类型 ---》引用类型)
			String str = String.valueOf(i);
			Object o = i;
	2）、拆箱（UnBoxing）
		将引用类型数据转为值类型数据的过程就称为拆箱。拆箱一般需要强制进行转换。
		eg:
			//值类型数据
			int i = 20;
			//将数值类型赋值给引用类型对象(值类型 ---》引用类型)
			String str = String.valueOf(i);
			Object o = i;
			
			//将引用类型数据转为值类型数据(引用类型 ---》值类型)
			int m = (int)o;
			int n = Integer.parseInt(str);
	3）、缺点
		a、拆箱和装箱会造成代码效率的下降
		b、拆箱过程中存在着代码安全性问题
	4）、建议
		代码中尽量减少拆箱和装箱操作。
	 */

	public static void main(String[] args) {
		//值类型数据
		int i = 20;
		//将数值类型赋值给引用类型对象(值类型 ---》引用类型)
		String str = String.valueOf(i);
		Object o = i;
		
		o = "haha";
		//将引用类型数据转为值类型数据(引用类型 ---》值类型)
		int m = (int)o;
		int n = Integer.parseInt(str);
		
	}
}
