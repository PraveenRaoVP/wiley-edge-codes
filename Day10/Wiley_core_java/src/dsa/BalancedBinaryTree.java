package dsa;

//class Node{
//	int data;
//	Node left,right;
//	
//	public Node(int d) {
//		data = d;
//		left = right = null;
//	}
//}

//public class BalancedBinaryTree {
//	Node root;
//	
//	public BalancedBinaryTree() {
//		root = null;
//	}
//	
//	public int heightCalc(Node node) {
//		if(node == null) {
//			return 0;
//		} else {
//			int leftDepth = heightCalc(node.left);
//			int rightDepth = heightCalc(node.right);
//			//System.out.println(leftDepth-rightDepth);
//			return leftDepth-rightDepth;
//		}
//	}
//	
//	public boolean isBalanced(Node node) {
//		if(node==null) {
//			return true;
//		}
//		if((heightCalc(node)==0 || heightCalc(node)==1 || heightCalc(node)==-1) && (heightCalc(node.left)==0 || heightCalc(node.left)==1 || heightCalc(node.left)==-1) && (heightCalc(node.right)==0 || heightCalc(node.right)==1 || heightCalc(node.right)==-1)) {
//			return true;
//		}
//		return false;
//	}
//	
//	public static void main(String args[]) {
//		BalancedBinaryTree tree = new BalancedBinaryTree();
//		tree.root = new Node(1);
//		tree.root.left = new Node(2);
//		tree.root.right = new Node(3);
//		tree.root.left.left = new Node(4);
//		tree.root.left.left.left = new Node(5);
//		tree.root.left.right = new Node(6);
//		System.out.println(tree.isBalanced(tree.root));
//	}
//	
//}


	// Calculate height
	class Height {
	  int height = 0;
	}

	class BalancedBinaryTree {

	  Node root;

	  // Check height balance
	  boolean checkHeightBalance(Node root, Height height) {

	    // Check for emptiness
	    if (root == null) {
	      height.height = 0;
	      return true;
	    }

	    Height leftHeighteight = new Height(), rightHeighteight = new Height();
	    boolean l = checkHeightBalance(root.left, leftHeighteight);
	    boolean r = checkHeightBalance(root.right, rightHeighteight);
	    int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;

	    height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

	    if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2))
	      return false;

	    else
	      return l && r;
	  }

	  public static void main(String args[]) {
	    Height height = new Height();

	    BalancedBinaryTree tree = new BalancedBinaryTree();
	    tree.root = new Node(1);
	    tree.root.left = new Node(2);
	    tree.root.right = new Node(3);
	    tree.root.left.left = new Node(4);
	    tree.root.right.right = new Node(5);

	    if (tree.checkHeightBalance(tree.root, height))
	      System.out.println("The tree is balanced");
	    else
	      System.out.println("The tree is not balanced");
	  }
	}