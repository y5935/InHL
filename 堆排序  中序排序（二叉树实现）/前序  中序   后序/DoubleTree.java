package lianxi;

public class DoubleTree {
	Node root;
	public void add(int value){
	
	}
	public void show(){
		showNode(root);
	}
	private void showNode(Node pnode){
		//System.out.println(pnode.getValue());
		if(pnode.getLeft()!=null){
			showNode(pnode.getLeft());
		}
		System.out.println(pnode.getValue());
		if(pnode.getRight()!=null){
			showNode(pnode.getRight());
		}
	
	}
	
}
