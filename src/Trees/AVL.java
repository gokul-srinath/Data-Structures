package Trees;

public class AVL {
    public AVL() {

    }

    public static class Node {
        int val;
        int height;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getHeight() {
            return this.height;
        }
    }

    Node root;

    int getHeight() {
        return getHeight(this.root);
    }

    int getHeight(Node node) {

        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }


    void display() {
        display(this.root, 0);
    }

    private void display(Node node, int level) {

        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("\t\t");
        }
        System.out.println(node.val);
        display(node.left, level + 1);
    }


    void insert(int val) {
        if (this.root == null) {
            this.root = new Node(val);
        } else {
            this.root = insert(root, val);
        }
        display();
        System.out.println("--------------------------------");
    }

    Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        }
        if (val > node.val) {
            node.right = insert(node.right, val);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return rotate(node);
    }


    Node rotate(Node node) {
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            // left heavy tree
            if ((getHeight(node.left.left) - getHeight(node.left.right)) > 0) {
                return rotateRight(node);
            }
            if ((getHeight(node.left.left) - getHeight(node.left.right)) < 0) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        if (getHeight(node.left) - getHeight(node.right) < 0) {
            // right heavy tree
            if ((getHeight(node.right.left) - getHeight(node.right.right)) > 0) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

            if ((getHeight(node.right.left) - getHeight(node.right.right)) < 0) {
                return rotateLeft(node);
            }

        }

        return node;
    }

    Node rotateRight(Node parent) {
        Node child = parent.left;
        Node rightT = child.right;

        child.right = parent;
        parent.left = rightT;

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;

        return child;
    }

    Node rotateLeft(Node parent) {
        Node child = parent.right;
        Node leftT = child.left;

        child.left = parent;
        parent.right = leftT;

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;

        return child;
    }


}
