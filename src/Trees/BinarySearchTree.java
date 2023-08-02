package Trees;

public class BinarySearchTree {

    public class Node {
        private int val;
        private Node left;
        private Node right;
        private int height;

        public Node(int val) {
            this.val = val;
        }

        int getValue() {
            return this.val;
        }

        int getHeight() {
            return this.height;
        }

        void setHeight(int h) {
            this.height += h;
        }
    }


    private Node root;

    BinarySearchTree() {

    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void display() {
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
        System.out.println(node.getValue());

        display(node.left, level + 1);
        return;
    }

    public Node insert(int val) {
        if (this.root == null) {
            this.root = new Node(val);
        } else {
            this.root = insert(this.root, val);
        }
        return this.root;
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            Node newNode = new Node(val);
            return newNode;
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        }

        if (val > node.val) {
            node.right = insert(node.right, val);
        }

        node.setHeight(Math.max(getHeight(node.left), getHeight(node.right)) + 1);

        return node;
    }

    public boolean checkBalanced() {
        return checkBalanced(this.root);
    }

    private boolean checkBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && checkBalanced(node.left) && checkBalanced(node.right);
    }


}
