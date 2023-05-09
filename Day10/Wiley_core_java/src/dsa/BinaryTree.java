package dsa;

class Node{
	int data;
	Node left, right;
	
	public Node(int d){
		data = d;
		left = right = null;
	}
	
}
//tree traversal
public class BinaryTree {	
	Node root;
	public BinaryTree() {
		root = null;
	}
	
	public void inOrder(Node node) {
		if(node==null) return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	public void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	public void preOrder(Node node) {
		if(node==null) return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		System.out.println("Inorder: ");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("Pre Order: ");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("Post Order: ");
		tree.postOrder(tree.root);
	}
	/*
	 * 				1
	 * 			   / \
	 * 			  2   3
	 * 				   \
	 * 					4
	 */
}
