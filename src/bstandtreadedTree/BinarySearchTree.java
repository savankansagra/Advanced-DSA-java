package bstandtreadedTree;


public class BinarySearchTree {
	private Node root;

	
	/** constructor */
	public BinarySearchTree() {
		super();
		this.root = null;
	}
	
	
	/** insert data */
	public void insert(int data) {
		root = insert(root,data);
	}

	private Node insert(Node node, int data) {
		if(node == null) {
			node = new Node(data);
		} else if(data <= node.getData()) {
			node.left = this.insert(node.left, data);
		} else {
			node.right = this.insert(node.right, data);
		}
		return node;
	}

	
	/** delete data */
	// TODO delete node
	void deleteKey(int data) {
		deleteNode(this.root, data);
	}
	
	private Node deleteNode(Node root, int data) {
		// return if the tree is empty
		if(root == null) { 
			return root;
		}
		
		// find the node to be deleted.
		if( data < root.getData() ) {
			root.left = deleteNode(root.left, data);
		} else if( data > root.getData()) {
			root.right = deleteNode(root.right, data);
		} else { // node is found.
			// case 0 both child is null;
			if(root.left == null && root.right == null) {
				root = null;
				return root;
			}
			
			// case 1 only one child.
			else if(root.left == null) {
				root = root.right;
			} else if(root.right == null) {
				root = root.left;
			}
			
			// case 2 both child present.
			root.setData(minValue(root.right));
			root.right = deleteNode(root.right, root.getData());
		
		}
		return root;
	}


	private int minValue(Node right) {
		int minVal = right.getData();
		while(right.left != null) {
			minVal = right.left.getData();
			right = right.left;
		}
		return minVal;
	}


	/** inorder travsal */
	private void inorder() {
		Node root = this.root;
		inorder(root);
	}
	
	private void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.getData()+", ");
			inorder(root.right);
		}
	}

	

	public int minimumValue() {
		return minimumValue(root);
	}


	public int minimumValue(Node root2) {
		if(root2 == null) {
			return -1;
		} else if (root2.left == null){
			return root2.getData();
		} else {
			return minimumValue(root2.left);
		}
	}


	public int find(int i) {
		return findData(this.root, i);
	}


	public int findData(Node root2, int i) {
		if(root2 == null) {
			return -1;
		}
		else if(root2.getData() == i) {
			return i;
		} else if(root2.getData() > i) {
			return findData(root2.left, i);
		} else {
			return findData(root2.right, i);
		}
	}
	
	
	

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		// insert node
		System.out.println("Node insertion.");
	    tree.insert(8);
	    tree.insert(3);
	    tree.insert(1);
	    tree.insert(6);
	    tree.insert(7);
	    tree.insert(10);
	    tree.insert(14);
	    tree.insert(4);

	    System.out.print("Inorder traversal: ");
	    tree.inorder();
	    System.out.println();
	    
	    // delete node.
	    System.out.println("delete the element : 14");
	    tree.deleteKey(14);
	    
	    tree.inorder();
	    System.out.println();
	    
	    // finding element.
	    System.out.print("finding the element 6 = ");
	    System.out.println(tree.find(6));
	    
	    // finding min element.
	    System.out.print("finding minimum element = ");
	    System.out.println(tree.minimumValue());
	    
	    // finding max element.
	    System.out.print("finding maximum element = ");
	    System.out.println(tree.maximumValue());
	    
	    // left child of given node;
	    System.out.print("left child of given node = ");
	    System.out.println(tree.leftChild());
	    
	    // right child of given node;
	    System.out.print("right child of given node = ");
	    System.out.println(tree.rightChild());
	    
	    // number of nodes.
	    System.out.print("number of nodes = ");
	    System.out.println(tree.countNodes());
	    
	    // number of leave nodes.
	    System.out.print("number of leave nodes = ");
	    System.out.println(tree.leaveNodes());
	    
	    // number of full nodes.
	    System.out.print("number of full nodes = ");
	    System.out.println(tree.fullNodes());
	    
	    
	}


	private int fullNodes() {
		return fullNodes(root);
	}


	private int fullNodes(Node root2) {
		if(root2 == null) {
			return 0;
		} else if(root2.left != null && root2.right != null) {
			return 1 + fullNodes(root2.left) + fullNodes(root2.right);
		} else {
			return fullNodes(root2.left) + fullNodes(root2.right);
		}
	}


	private int leaveNodes() {
		return leaveNodes(root);
	}


	private int leaveNodes(Node root2) {
		if(root2 == null) {
			return 0;
		} else if(root2.left == null && root2.right == null) {
			return 1;
		} else {
			return leaveNodes(root2.left) + leaveNodes(root2.right);
		}
	}


	public int countNodes() {
		return countNodes(root);
	}


	private int countNodes(Node root2) {
		if(root2 == null) {
			return 0;
		} else {
			return 1 + countNodes(root2.left) + countNodes(root2.right);
		}
	}


	private int leftChild() {
		return this.leftChild(root);
	}


	private int leftChild(Node root2) {
		if(root2 == null) {
			return -1;
		} else {
			return root2.left.getData();
		}
	}
	
	public int rightChild() {
		return this.rightChild(root);
	}
	
	public int rightChild(Node root2) {
		if(root2 == null) {
			return -1;
		} else {
			return root2.right.getData();
		}
	}


	public int maximumValue() {
		return maximumValue(root);
	}


	public int maximumValue(Node root2) {
		if(root2 == null) {
			return -1;
		} else if(root2.right == null ) {
			return root2.getData();
		} else {
			return maximumValue(root2.right);
		}
	}




	/**
	 * Reference:
	 * https://courses.engr.illinois.edu/cs225/fa2022/resources/bst/ 
	 * https://github.com/mvyas85/Binary-Tree/blob/master/src/BST/BinarySearchTree.java
	 */
	
	
}
