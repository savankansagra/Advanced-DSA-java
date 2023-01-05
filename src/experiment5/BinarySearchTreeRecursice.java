package experiment5;

public class BinarySearchTreeRecursice extends BaseBinaryTree implements BinarySearchTree {

	@Override
	public Node searchNode(int key) {
		return searchNode(key, root);
	}

	private Node searchNode(int key, Node root) {
		if(root == null) {
			return null;
		}
		
		if(key == root.data) {
			return root;
		} else if(key < root.data) {
			return searchNode(key, root.left);
		} else {
			return searchNode(key, root.right);
		}
		
	}

	@Override
	public void insertNode(int key) {
		root = insertNode(key, root);
	}

	protected Node insertNode(int key, Node root) {
		// if tree is empty --> create root node in tree.
		if(root == null) {
			root = new Node(key);
		}
		
		// otherwise, travrse the tree to the left or right depending on the key.
		else if(key < root.data) {
			root.left = insertNode(key, root.left);
		} else if(key > root.data) {
			root.right = insertNode(key, root.right);
		} else {
			throw new IllegalArgumentException("BST already contain a node with key"+key);
		}
		
		return root;
	}

	@Override
	public void deleteNode(int key) {
		root = deleteNode(key, root);
	}

	protected Node deleteNode(int key, Node root) {
		// No node at current position 
		if(root == null) {
			return null;
		} 
		
		// traverse the tree to the left or right depending on the key.
		if(key < root.data) {
			root.left = deleteNode(key, root.left);
		} else if(key > root.data) {
			root.right = deleteNode(key, root.right);
		}
		
		/** At this point, "node" is the node to be deleted. */
		
		// Node has no children --> delete the node.
		else if(root.left == null &&  root.right == null) {
			root = null;
		}
		
		// node has only one child --> replace node b y
		else if(root.left == null) {
			root = root.right;
		} else if(root.right == null) {
			root = root.left;
		}
		
		// node has two children.
		else {
			deleteNodewithTwoChildren(root);
		}
		
		return root;
		
	}

	private void deleteNodewithTwoChildren(Node root) {
		// find the minumum node of right sub tree.
		Node inorderSuccesser = findMinimum(root.right);
		
		// copy inorder successer data into current node.
		root.data = inorderSuccesser.data;
		
		//delete inorder successer node recursively.
		root.right = deleteNode(inorderSuccesser.data, root.right);
		
	}

	private Node findMinimum(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	

	
}
