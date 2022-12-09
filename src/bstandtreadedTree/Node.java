package bstandtreadedTree;

public class Node {
	private int data;
	public Node left, right;
	
	/** constructor */
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

