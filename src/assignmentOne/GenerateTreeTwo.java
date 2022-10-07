package assignmentOne;

public class GenerateTreeTwo {

	/*
	 * WAP to generate the binary tree from the given inorder and postorder traversal. 
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
	
	
	private TreeNode recursive(int[] postOrder, int[] inOrder) {
		//base case
		if(postOrder==null || inOrder==null || postOrder.length==0 || inOrder.length==0) {
			return null;
		}
		
		if(postOrder.length == 1 && inOrder.length == 1) {
			return new TreeNode(postOrder[0]);
		}
		
		
		// find the mid index in inOrder array.
		int mid=0;
		for(int k=0;k<inOrder.length;k++) {
			if(postOrder[postOrder.length-1] == inOrder[k]) {
				mid = k;
				break;
			}
		}
		
		
		//recursive calls.
		TreeNode root = new TreeNode(postOrder[postOrder.length-1]);
		root.left = recursive(this.slice(postOrder, 0, mid), this.slice(inOrder, 0, mid));
		root.right = recursive(this.slice(postOrder, mid, postOrder.length-1), this.slice(inOrder, mid+1, inOrder.length));
		return root;
		
	}
	
	public static void main(String[] args) {
		GenerateTreeTwo generateTreeTwo = new GenerateTreeTwo();
		int postOrder[] = new int[] {9, 15, 7, 20, 3};
		int inOrder[] = new int[] {9, 3, 15, 20, 7};
		TreeNode ans 	= generateTreeTwo.recursive(postOrder, inOrder);
		System.out.println(ans);
	}

	

	
}
