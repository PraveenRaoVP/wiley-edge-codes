package dsa;

public class PerfectBinaryTree {
	Node root;
	public PerfectBinaryTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	static int depth(Node node) {
		int d = 0;
		while(node!=null) {
			d++;
			node=node.left;
		}
		return d;
	}
	
	static boolean isPerfect(Node node, int d, int level) {
		if(node==null) {
			return true;
		} 
		if(node.left == null && node.right==null) {
			return (d==level+1);
		}
		if(node.left == null || node.right==null) {
			return false;
		}
		return isPerfect(node.left, d,level+1) && isPerfect(node.right,d,level+1);
	}
	
	public static void main(String[] args) {
		FullBinaryTree tree = new FullBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		int d = depth(tree.root);
		System.out.println(isPerfect(tree.root,d,0));
	}
}
