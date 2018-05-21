package lianxi;

public class Node {
	
	
	public Node(int value) {
		this.value = value;
	}
	
	
	int value;
	 Node left;
	 Node right;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	 
}
