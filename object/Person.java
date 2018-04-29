package object;

public class Person {
	String name;
	int age;
	public Person(){};
	
	public Person(String name,int age){
		this.name = name;
		this.age  = age;
	}
	
	
	
	@Override
	public String toString(){
		return "[我的名字 "+name+",我今年"+age+"]";
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		//判断是不是属于Person类
		if(obj instanceof Person){
			Person p = (Person)obj;
			
			//this.name.equals(p.name)  因为name是Strng类型，String类型已经重写了equals方法。
			if(this.name.equals(p.name) && this.age==p.age){
				return true;
			}
		}
		return false;
	}
}
