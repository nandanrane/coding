package various;

import java.util.LinkedList;
import java.util.Queue;

public class BinTreeMirror {
	
	public static boolean binTreeMirrorRecur(TreeNode n1, TreeNode n2) {
		if(n1 == null && n2 == null) return true;
		if(n1 == null || n2 == null) return false;
		if(n1.data != n2.data) return false;
		
		return (binTreeMirrorRecur(n1.left, n2.right) && binTreeMirrorRecur(n1.right, n2.left));
	}
	
	public static boolean binTreeMirror(TreeNode n1, TreeNode n2) {
		if(n1 == null && n2 == null) {
			return true;
		}
		if(n1 == null || n2 == null){
			return false;
		}
		// use 2 queues to traverse both trees breadth first
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(n1);
		q2.add(n2);
		// traverse while both queues have elements
		while(!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode curr1 = q1.remove();
			TreeNode curr2 = q2.remove();
			
			if(curr1 == null && curr2 == null) {
				continue;
			}
			
			// if only one is null or if the data is not equal trees are not mirror image
			if((curr1 == null || curr2 == null) || (curr1.data != curr2.data)) {
				return false;
			}
			
			// add left right order for tree 1 and add right left order for tree 2
			q1.add(curr1.left);
			q1.add(curr1.right);
			
			q2.add(curr2.right);
			q2.add(curr2.left);
		}
		
		// if one of the queue is not empty at this time, that means they are not mirror images 
		if(!q1.isEmpty() || !q2.isEmpty()) {
			return false;
		}
		
		return true;
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
		/*
		TreeNode n31 = new TreeNode(6);
		TreeNode n32 = new TreeNode(7);
		n12.left = n31;
		n12.right = n32;
		 */
		TreeNode n2 = new TreeNode(1);
		TreeNode nb1 = new TreeNode(2);
		TreeNode nb2 = new TreeNode(3);
		n2.left = nb2;
		n2.right = nb1;
		TreeNode nb21 = new TreeNode(4);
		TreeNode nb22 = new TreeNode(5);
		nb1.right = n21;
		nb1.left = n22;
		
		System.out.println(binTreeMirror(n1, n2));
		System.out.println(binTreeMirrorRecur(n1, n2));
	}
	
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data) {
		this.data = data;
	}
}
