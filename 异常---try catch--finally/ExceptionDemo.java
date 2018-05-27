package cn.hl.test;

public class ExceptionDemo {
	public static void main(String[] args) {
		/*
		int i;
		//编译时异常
		//System.out.println(i);
		
		i = 200;
		//运行时异常
		System.out.println(i/0);
		Exception e;
		*/
		
		int r = testException3();
		System.out.println(r);
	}

	/**
	 * 测试try-catch
	 * 	运行结果1、3部分的代码被调用了
	 */
	private static void testException1() {
		try{
			System.out.println("try语句被执行了");		//1
		}
		catch(Exception e){
			System.out.println("catch语句被执行了");	//2
		}
		finally{
			System.out.println("finally语句被执行了");	//3
		}		
	}
	
	/**
	 * 测试try-catch
	 * 	运行结果1、2、3部分的代码被调用了
	 */
	private static void testException2() {
		try{
			System.out.println("try语句被执行了");		//1
			System.out.println(20/0);
		}
		catch(Exception e){
			System.out.println("catch语句被执行了");	//2
		}
		finally{
			System.out.println("finally语句被执行了");	//3
		}		
	}
	
	/**
	 * 测试try-catch
	 * 	返回2的值
	 */
	private static int testException3() {
		try{
			System.out.println("try语句被执行了");		//1
			//System.out.println(20/0);
			return 1;
		}
		catch(Exception e){
			System.out.println("catch语句被执行了");	//2
			//return 2;
		}
		finally{
			System.out.println("finally语句被执行了");	//3
			return 3;
		}	
		//return 0;
	}
	
	/**
	 * 测试try-catch
	 * 	返回3的值
	 */
	private static int testException5() {
		try{
			System.out.println("try语句被执行了");		//1
			System.out.println(20/0);
			return 1;
		}
		catch(Exception e){
			System.out.println("catch语句被执行了");	//2
			return 2;
		}
		finally{
			System.out.println("finally语句被执行了");	//3
			return 3;
		}		
	}
}
