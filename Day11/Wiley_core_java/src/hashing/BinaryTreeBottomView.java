package hashing;

import java.util.*;
//import java.util.*;




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
        /*
                    1
                   / \
                  2   3
                 / \   \
                4   5   6
                     \
                      7
        */
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




/*
 * we define a TreeNodeTwo class representing a node in the binary tree. Each
 * TreeNodeTwo object has a value (val) and left and right child pointers.
 * 
 * The printBottomView method takes the root of the binary tree as input and
 * prints the bottom view of the tree. It uses a map (TreeMap) to store the last
 * encountered node at each horizontal distance (hd) from the root. It also uses
 * a queue to perform a level-order traversal of the tree.
 * 
 * During the traversal, for each node, we update the value in the map with the
 * current node's value at the corresponding horizontal distance. We then
 * enqueue the left and right child nodes (if they exist) along with their
 * updated horizontal distances.
 * 
 * Finally, we iterate over the map values and print them, which will give us
 * the bottom view of the binary tree.
 * 
 * In the main method, we create a binary tree with the values shown in the
 * comment above the tree. We then call the printBottomView method to print the
 * bottom view of the binary tree.
 */
