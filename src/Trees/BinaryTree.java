package Trees;

import java.util.Scanner;

public class BinaryTree {

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;

    public Node populate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value for root node :");
        int val = sc.nextInt();
        root = new Node(val);
        populate(root, sc);
        return root;
    }

    private void populate(Node node, Scanner sc) {
        if (node == null) {
            return;
        }

        System.out.println("do you want to enter left child to " + node.val);
        boolean left = sc.nextBoolean();

        if (left) {
            System.out.println("Enter the value for left child to " + node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(node.left, sc);
        }
        System.out.println("do you want to enter right child to " + node.val);
        boolean right = sc.nextBoolean();

        if (right) {
            System.out.println("Enter the value for right child to " + node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(node.right, sc);
        }

    }


    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        display(node.left, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("\t\t");
        }

        System.out.println(node.val);
        display(node.right, level + 1);

    }


}
