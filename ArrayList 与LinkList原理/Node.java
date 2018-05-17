package lianxi;

public class Node {
	public Node(Object value){
		this.value= value;
	}
	Object value;//数据
	Node next;//下一个对象节点
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
