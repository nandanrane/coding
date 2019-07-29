package various;
import java.util.LinkedList;
import java.util.Queue;


public class PrintBinTreeLevelByLevel {
	
	public static void printBinTreeByLevel(TreeNode root) {
		
		if(root == null) {
			System.out.println("root is null");
		}
		
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		Queue<TreeNode> temp;
		
		q1.add(root);

		while(!q1.isEmpty()) {
			TreeNode curr = q1.remove();
			
			System.out.print(curr.data + " ");
			
			// add children to other queue
			if(curr.left != null) 
				q2.add(curr.left);
			if(curr.right != null) 
				q2.add(curr.right);
			
			if(q1.isEmpty() && !q2.isEmpty()) {
				System.out.println("\n--------");
				temp = q2;
				q2 = q1;
				q1 = temp;
			}
			
		}
		
		
		
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n11 = new TreeNode(2);
		TreeNode n12 = new TreeNode(3);
		n1.left = n11;
		n1.right = n12;
		TreeNode n21 = new TreeNode(4);
		TreeNode n22 = new TreeNode(5);
		n11.left = n21;
		n11.right = n22;
		printBinTreeByLevel(n1);
	}

}

