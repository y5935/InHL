package cn.hl.test;

public class ExceptionDemo {
	public static void main(String[] args) {
		/*
		int i;
		//����ʱ�쳣
		//System.out.println(i);
		
		i = 200;
		//����ʱ�쳣
		System.out.println(i/0);
		Exception e;
		*/
		
		int r = testException3();
		System.out.println(r);
	}

	/**
	 * ����try-catch
	 * 	���н��1��3���ֵĴ��뱻������
	 */
	private static void testException1() {
		try{
			System.out.println("try��䱻ִ����");		//1
		}
		catch(Exception e){
			System.out.println("catch��䱻ִ����");	//2
		}
		finally{
			System.out.println("finally��䱻ִ����");	//3
		}		
	}
	
	/**
	 * ����try-catch
	 * 	���н��1��2��3���ֵĴ��뱻������
	 */
	private static void testException2() {
		try{
			System.out.println("try��䱻ִ����");		//1
			System.out.println(20/0);
		}
		catch(Exception e){
			System.out.println("catch��䱻ִ����");	//2
		}
		finally{
			System.out.println("finally��䱻ִ����");	//3
		}		
	}
	
	/**
	 * ����try-catch
	 * 	����2��ֵ
	 */
	private static int testException3() {
		try{
			System.out.println("try��䱻ִ����");		//1
			//System.out.println(20/0);
			return 1;
		}
		catch(Exception e){
			System.out.println("catch��䱻ִ����");	//2
			//return 2;
		}
		finally{
			System.out.println("finally��䱻ִ����");	//3
			return 3;
		}	
		//return 0;
	}
	
	/**
	 * ����try-catch
	 * 	����3��ֵ
	 */
	private static int testException5() {
		try{
			System.out.println("try��䱻ִ����");		//1
			System.out.println(20/0);
			return 1;
		}
		catch(Exception e){
			System.out.println("catch��䱻ִ����");	//2
			return 2;
		}
		finally{
			System.out.println("finally��䱻ִ����");	//3
			return 3;
		}		
	}
}
