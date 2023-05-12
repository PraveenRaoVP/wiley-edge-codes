package hashing;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class BinaryTreeTopView {
    public static void printTopView(Node root) {
        if (root == null)
            return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Queues> queue = new LinkedList<>();
        queue.add(new Queues(root, 0));

        while (!queue.isEmpty()) {
            Queues current = queue.poll();
            if (!map.containsKey(current.hd)) {
                map.put(current.hd, current.node.val);
            }

            if (current.node.left != null) {
                queue.add(new Queues(current.node.left, current.hd - 1));
            }

            if (current.node.right != null) {
                queue.add(new Queues(current.node.right, current.hd + 1));
            }
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println("Top view of the binary tree:");
        printTopView(root);
    } 
}

class Queues {
    Node node;
    int hd;

    Queues(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}



