package cn.hl.action;

/**
 * Pojo类方式实现Action
 * 
 * 优点：
 * 		没有继承或实现任何类或接口，类不具有侵入性。便于代码的测试和迁移。
 * 缺点：
 * 		没有约束，容易出现错误。
 * 		不适用于新手使用
 * @author Terry
 *
 */
public class PojoAction {
	public String execute(){
		System.out.println("Pojo.execute() is do......");
		
		return "success";
	}
}
