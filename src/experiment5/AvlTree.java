package experiment5;

public class AvlTree extends BinarySearchTreeRecursice {
	
	private int height(Node node) {
		return node != null ? node.height : -1;
	}
	
	private void updateHeight(Node node) {
		int leftChildHeight = this.height(node.left);
		int rightChildHeight = this.height(node.right);
		node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
	}
	
	private int balanceFactor(Node node) {
		return this.height(node.right) - this.height(node.left);
	}
	
	private Node rotateRight(Node node) {
		Node leftChild = node.left;
		
		node.left = leftChild.right;
		leftChild.right = node;
		
		updateHeight(node);
		updateHeight(leftChild);
		
		return leftChild; 
	}
	
	private Node rotateLeft(Node node) {
		Node rightChild = node.right;
		
		node.right = rightChild.left;
		rightChild.left = node;
		
		this.updateHeight(node);
		this.updateHeight(rightChild);
		
		return rightChild;
	}
	
	
	private Node rebalance(Node node) {
		int balanceFactor = this.balanceFactor(node);
		
		// left heavy?
		if(balanceFactor < -1) {
			if(this.balanceFactor(node.left) < 0) { // Case 1
				// Rotate right
				node = this.rotateRight(node);
			} else { 								// Case 2
				// Rotate left-right
				node.left = this.rotateLeft(node.left); 
				node = this.rotateRight(node);
			}
		}
		
		// Right heavy ?
		if(balanceFactor > 1) {
			if(this.balanceFactor(node.right) >= 0) { // Case 3
				// Rotate Left
				node = this.rotateLeft(node);
			} else {
				// Rotate right - left
				node.right = this.rotateRight(node.right);
				node = this.rotateLeft(node);
			}
		}
		
		return node;
	}
	
	@Override
	public Node insertNode(int key, Node node) {
		node = super.insertNode(key, node);
		this.updateHeight(node);
		return this.rebalance(node);
	}
	
	
	@Override
	public Node deleteNode(int key, Node node) {
		super.deleteNode(key);
		
		// Node is null if the tree doesn't contain the key.
		if(node == null) {
			return null;	
		}

		updateHeight(node);
		return this.rebalance(node);
	}
	
}
