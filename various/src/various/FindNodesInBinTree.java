package various;

import java.util.ArrayList;
import java.util.List;

public class FindNodesInBinTree {
	
	public static void printPathToNode(TreeNode root, int data) {
		List<TreeNode> results = new ArrayList<TreeNode>();
		if(printPathHelper(root, data, results)) {
			System.out.println();
			for(TreeNode node : results) {
				System.out.print(node.data+ " ");
			}
			System.out.println();
		} else {
		
			System.out.println("Node not found");
		}
		
	}
	
	// find and print path between nodes e.g 3 - 1 - 4 - 8
	public static void printPathBetweenNodes(TreeNode root, int data1, int data2) {
		
		List<TreeNode> path1 = new ArrayList<TreeNode>();
		List<TreeNode> path2 = new ArrayList<TreeNode>();

		printPathHelper(root, data2, path2);

		printPathHelper(root, data1, path1);

		// there may be common paths - e.g. 10 - 1 - 3    and 10 - 1 - 4 - 8 and the path is 3 1 4 8
		// find interesection point which is 1 in this case
		int intersection = 0, i = 0, j = 0;

		for(; i < path1.size() && j < path2.size(); i++, j++) {

			if(path1.get(i).data == path2.get(j).data) {
				intersection = j;
			} else {
				break;
			}
		}
		
		// after finding intersection - print path1 in the reverse and print path2 in normal direction 
		for(i = path1.size()-1; i> intersection; i--) {
			System.out.print(path1.get(i).data + " ");
		}
		
		for(; i < path2.size(); i++) {
			System.out.print(path2.get(i).data + " ");
		}
	}	
	
	public static boolean printPathHelper(TreeNode root, int data, List<TreeNode> results) {
		if(root == null) {
			return false;
		}

		results.add(root);
		
		if(root.data == data) {
			return true;
		}
		
		if(printPathHelper(root.left, data, results) || printPathHelper(root.right, data, results)) {
			return true;
		}
		
		results.remove(results.size()-1);
		
		return false;
	}

	public static void main(String[] args) {
		/*
		        10
		       /  \
		      1     2
		     / \   /  \
            3   4 5    6 
		   /     \ 
		  7       8
		  
		  */
		TreeNode root = new TreeNode(10);
		
	
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		root.left = n1;
		root.right = n2;
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n3;
		n1.right = n4;
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n2.left = n5;
		n2.right = n6;
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		n3.left = n7;
		n4.right = n8;
		
		//printPathToNode(root, 5);
		
		System.out.println();
		printPathBetweenNodes(root, 3, 8);
		
		System.out.println();

		printPathBetweenNodes(root, 3, 7);
		System.out.println();
		printPathBetweenNodes(root, 3, 5);
	}

}
