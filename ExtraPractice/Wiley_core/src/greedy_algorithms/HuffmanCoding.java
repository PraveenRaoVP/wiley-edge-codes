package greedy_algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

class Node{
	int data;
	char c;
	Node left,right;
}

class MyComparator implements Comparator<Node>{
	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return o1.data-o2.data;
	}
	
}

public class HuffmanCoding {
	public static void printCode(Node root, String s) {
		if(root.left==null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c+": "+s);
			return;
		}
		printCode(root.left,s+"0");
		printCode(root.right,s+"1");
	}
	
	public static HashMap<Character, Integer> retOccurence(String s){
		HashMap<Character,Integer> map = new HashMap<>();
		//char[] ca = s.toCharArray();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				int count = map.get(s.charAt(i));
				map.put(s.charAt(i), ++count);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		return map;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		HashMap<Character, Integer> occ = retOccurence(s);
		PriorityQueue<Node> q = new PriorityQueue<>(n, new MyComparator());
		for(Map.Entry<Character, Integer> mp: occ.entrySet()) {
			Node node = new Node();
			node.c = mp.getKey();
			node.data = mp.getValue();
			node.left = null;
			node.right = null;
			q.add(node);
		}
		Node root = null;
		while(q.size()>1) {
			Node x = q.peek();
			q.poll();
			Node y = q.peek();
			q.poll();
			
			Node f = new Node();
			f.data = x.data+y.data;
			f.c= '-';
			f.left = x;
			f.right = y;
			root = f;
			q.add(f);
		}
		printCode(root,"");
	}
}
