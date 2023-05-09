package dsa;



public class BinarySearchTree {
	Node root;
	public BinarySearchTree() {
		root = null;
	}
	boolean search(Node root, int x) {
		if(root == null) return false;
		if(root.data == x) {
			return true;
		} else if (root.data>x) {
			return search(root.left,x);
		} else if(root.data<x) {
			return search(root.right,x);
		}
		return false;
	}
	
	public Node addToData(Node root, int d) {
		if(root==null) {
			root = new Node(d);
		} 
		else if(root.data>d) {
			root.left = addToData(root.left,d);
		} else if(root.data<d) {
			root.right = addToData(root.right,d);
		}
		return root;
	}
	
	public void inOrder(Node node) {
		if(node==null) return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new Node(8);
		bst.root.left = new Node(3);
		bst.root.right = new Node(10);
		bst.root.left.left = new Node(1);
		bst.root.left.right = new Node(6);
		bst.root.left.right.left = new Node(4);
		bst.root.left.right.right = new Node(7);
		bst.root.right.right = new Node(14);
		bst.addToData(bst.root, 5);
		System.out.println(bst.search(bst.root, 5));
		bst.inOrder(bst.root);
		
	}
}
