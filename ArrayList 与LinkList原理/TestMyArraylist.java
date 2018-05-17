package lianxi;

public class TestMyArraylist {

	public static void main(String[] args) throws Exception {
		//MyArrayList list = new MyArrayList();
		MyLinkList list = new MyLinkList();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(7);
		list.set(1,9);
		list.removeAt(1);
		list.removeAt(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
