package various;

public class CommonAncestorBinTree {

	public static TreeNode commonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
		
		if(root == null) {
			return null;
		}
		
		TreeNode node = search(root, n1, n2);
		return node;
	}
	
	private static TreeNode helper(TreeNode root, TreeNode n1, TreeNode n2) {
		System.out.println("helper with root " + (root != null ? root.data : null));
		if(root == null) return null;
		if(n1.data == root.data || n2.data == root.data) {
			return root;
		}
		
		TreeNode left = helper(root.left, n1, n2);
		TreeNode right = helper(root.right, n1, n2);
		
		if(left != null && right != null) {
			return root;
		}
		if(left != null) {
			return left;
		} 
		if(right != null) {
			return right;
		}
		
		return null;
	}
	
	private static TreeNode search(TreeNode root, TreeNode p, TreeNode q) {

		  /*
		    Our base cases.
		    How our recursion stops.
		    When we have an answer.
		    1.) If the node we are holding is null then we can't search...just return null
		    2.) If we find either value return ourselves to the caller
		    Remember, we are "grabbing"/"holding" 'root' in this call.
		  */
		  if (root == null) return null;
		  if (root.data == p.data || root.data == q.data) return root;
		  
		  /*
		    'root' doesn't satisfy any of our base cases.
		    Search left and then search right.
		  */
		  TreeNode leftSearchResult = search(root.left, p, q);
		  TreeNode rightSearchResult = search(root.right, p, q);
		  
		  /*
		    If nothing turned up on the left, return whatever we got
		    back on the right.
		  */
		  if (leftSearchResult == null) return rightSearchResult;

		  /*
		    If nothing turned up on the right, return whatever we got
		    back on the left.
		  */
		  if (rightSearchResult == null) return leftSearchResult;
		  
		  /*
		    If we reach here that means we got something back on the left AND
		    right...that means this node is the LCA...because our recursion returns
		    from bottom to up...so we return what we hold...'root'
		  */
		  return root;
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

		TreeNode lca = commonAncestor(n1, n11, new TreeNode(9));
		System.out.println((lca == null ? null : lca.data));
	}

}
