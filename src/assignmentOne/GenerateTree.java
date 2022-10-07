package assignmentOne;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {
		
	}
	
	public TreeNode(int data){
		this.data=data;
	}
	
	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class GenerateTree {
	/*
	 WAP to generate the binary tree from the given inorder and preorder traversal.
	 */
	
	public int[] slice(int[] data, int start, int end) {
		if(start < end) {
			int temp[] = new int[end-start];
			for (int i = start; i < end; i++) {
				temp[i-start] = data[i];
			}
			return temp;
		}else {
			return null;
		}
	}
	
	public TreeNode recursive(int[] preOrder, int[] inOrder) {
		//// base cases
		if(preOrder==null || inOrder==null || preOrder.length == 0 || inOrder.length == 0) {
			return null;
		}
		
		if(preOrder.length == 1 && inOrder.length == 1) {
			return new TreeNode(preOrder[0]);
		}
		
		
		//// finding the index in inorder array.
		int mid=0;
		for(int k=0;k<inOrder.length;k++) {
			if(preOrder[0] == inOrder[k]) {
				mid = k;
				break;
			}
		}
		
		
		// making recursive calls.
		TreeNode root = new TreeNode(preOrder[0]); //creating root node from preOrder first node.
		root.left = recursive(this.slice(preOrder, 1, mid+1), this.slice(inOrder, 0, mid));
		root.right = recursive(this.slice(preOrder, mid+1, preOrder.length), this.slice(inOrder, mid+1, inOrder.length));
		
		return root;
	}
	
	
	public static void main(String[] args) {
		GenerateTree generateTree = new GenerateTree();
		int preOrder[] = new int[] {3, 9, 30, 20, 15, 7};
		int inOrder[] = new int[] {30, 9, 3, 15, 20, 7};
		TreeNode ans = generateTree.recursive(preOrder, inOrder);
//		System.out.println(ans);
		
	}
}
