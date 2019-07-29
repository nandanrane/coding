package various;

import java.util.Stack;

public class InOrderTraversalBinTree {
	
	public static void inorderIterative(TreeNode root) {
		
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = root;
		
		while(!s.isEmpty() || curr != null) {
			
			if(curr != null) { // keep adding left nodes to stack as long as it's not null
				curr = s.push(curr);
				curr = curr.left;
				continue;
			}
			
			
			if(!s.isEmpty()) {
				curr = s.pop();
				// visit node
				System.out.print(curr.data + " ");
				
				curr = curr.right;
			}
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n11 = new TreeNode(2);
		TreeNode n12 = new TreeNode(3);
		n1.left = n11;
		n1.right = n12;
		TreeNode n21 = new TreeNode(4);
		TreeNode n22 = new TreeNode(5);
		n11.left = n21;
		n11.right = n22;

		inorderIterative(n1);
	}

}
