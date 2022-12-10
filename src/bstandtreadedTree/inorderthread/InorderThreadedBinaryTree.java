package bstandtreadedTree.inorderthread;

public class InorderThreadedBinaryTree {
	public static void main(String[] args) {
		// create nodes
		TreeNodeT dummy = new TreeNodeT(-1);
		TreeNodeT ten = new TreeNodeT(10);
		TreeNodeT eight = new TreeNodeT(8);
		TreeNodeT twelve = new TreeNodeT(12);
		TreeNodeT fifteen = new TreeNodeT(15);
		TreeNodeT two = new TreeNodeT(2);
		TreeNodeT seven = new TreeNodeT(7);
		
		// Adding left and right child nodes.
		ten.left = eight;
		ten.right = twelve;
		eight.left = fifteen;
		eight.right = two;
		two.left = seven;
		dummy.left = ten;
		dummy.right = dummy;
		dummy.rightThread = true;
		
		// Adding threads.
		fifteen.right = eight;
		fifteen.rightThread = true;
		seven.right = two;
		seven.rightThread = true;
		two.right = ten;
		two.rightThread = true;
		twelve.right = dummy;
		twelve.rightThread = true;
		
		inorderTravalser(dummy);
		
	}

	private static void inorderTravalser(TreeNodeT dummy) {
		TreeNodeT curr = leftmost(dummy);
		while(curr != null && curr.val != -1) {
			//process node
			System.out.print(curr.val+" ");
			//update curr node
			if(curr.rightThread == true) {
				curr = curr.right;
			} else {
				curr = leftmost(curr.right);
			}
		}
		
	}
	
	
	private static TreeNodeT leftmost(TreeNodeT node) {
		if(node == null) {
			return null;
		}
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
}
