package bstandtreadedTree.inorderthread;

public class TreeNodeT {
	int val;
	TreeNodeT left;
	TreeNodeT right;
	boolean rightThread;
	
	public TreeNodeT() {
	}
	
	public TreeNodeT(int val){
		this.val = val;
	}

	public TreeNodeT(int val, TreeNodeT left, TreeNodeT right, boolean rightThread) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
		this.rightThread = rightThread;
	}
	
	
	
	
}
