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
		return "[�ҵ����� "+name+",�ҽ���"+age+"]";
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		//�ж��ǲ�������Person��
		if(obj instanceof Person){
			Person p = (Person)obj;
			
			//this.name.equals(p.name)  ��Ϊname��Strng���ͣ�String�����Ѿ���д��equals������
			if(this.name.equals(p.name) && this.age==p.age){
				return true;
			}
		}
		return false;
	}
}
