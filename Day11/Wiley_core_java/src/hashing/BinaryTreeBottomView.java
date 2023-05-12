package hashing;

import java.util.*;

public class BinaryTreeBottomView {
    public static void printBottomView(Node root) {
        if (root == null)
            return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Queues> queue = new LinkedList<>();
        queue.add(new Queues(root, 0));

        while (!queue.isEmpty()) {
            Queues current = queue.poll();
            map.put(current.hd, current.node.val);

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
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.right = new Node(7);

        System.out.println("Bottom view of the binary tree:");
        printBottomView(root);
    }
}


