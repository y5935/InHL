package lianxi;

public class MyLinkList {
	int size = 0;
	Node head = null;
	public int size(){
		return size;
	}
	public void add(Object value){
		Node newNode = new Node(value);
		if(head ==null){
			head = newNode;
		}else{
			Node temp = head;//当前节点
			while(temp.getNext()!=null){
				temp = temp.getNext();//当前节点向后移动
			}
			//循环结束：temp表示最后一个节点
			temp.setNext(newNode);
		}
		size++;
	}
	
	
	public void set(int index,Object value){
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		//temp定位到指定的索引
		temp.setValue(value);
		
	}
	public Object get(int index){
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		//temp定位到指定的索引
		return temp.getValue();
		
	}
	public void clear(){
		head =null;
		size =0;
	}
	public void removeAt(int index){
		if(index==0){
			head = head.getNext();
		}else{
			//找到删除元素的前一个元素
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.getNext();
			}
			//循环结束，temp表示删除元素的前一个元素
			temp.setNext(temp.getNext().getNext());	
		}
		size--;
	}
}
