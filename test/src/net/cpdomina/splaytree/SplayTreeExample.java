package net.cpdomina.splaytree;

public class SplayTreeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SplayTree<Integer> t = SplayTree.create(1,0,2,4,3);
		
		assert t.findMin() == 0;
		assert t.findMax() == 4;
		assert t.contains(2) == true;
		
		t.insert(5);
		t.remove(1);
		
		for(int i: t) {
			System.out.println(i);
		}
	}

}
