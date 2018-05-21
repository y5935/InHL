package lianxi;
//????:1.˳????????2.?????

public class D_Tree {
	Node root;
	public void add(int value){
		Node newNode = new Node(value);
		if(root==null){
		}else{
			Node temp = root;
			while(true){
				if(value<temp.getValue()){
					if(temp.getLeft()==null){
						temp.setLeft(newNode);
						break;
					}else{
						temp= temp.getLeft();
					}
				}else{
					if(temp.getRight()==null){
						temp.setRight(newNode);
						break;
					}else{
						temp= temp.getRight();
					}
				}
			}
		}
	}
}
