package dsa;


public class FullBinaryTree {
	Node root;
	
	public FullBinaryTree() {
		root = null;
	}
	boolean isFullBinaryTree(Node node) {
		if(node == null) return true;
		if(node.left == null && node.right == null) {
			return true;
		}
		if(node.left!=null && node.right !=null)
			return (isFullBinaryTree(node.left) && isFullBinaryTree(node.right));
		return false;
	}
	
	
	public static void main(String[] args) {
		FullBinaryTree tree = new FullBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
//		tree.root.right.right = new Node(6);
//		tree.root.right.right.left = new Node(7);
		System.out.println(tree.isFullBinaryTree(tree.root));
	}
}
