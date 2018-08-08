package cn.hl.action;

public class ConAction {
	private String name = "";

	public void setName(String name) {
		this.name = name;
	}
	
	public String execute(){
		//System.out.println(20/0);
		System.out.println("name = " + name);
		return "success";
	}
	
	public String add(){
		System.out.println("add is do......");
		//return "success";
		return "login";
	}
	
	public String update(){
		System.out.println("update is do......");
		//return "success";
		return "login";
	}
	
}
