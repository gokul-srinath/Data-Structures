package Trees;

public class BinarySearchTree {

    public class Node {
        public int val;
        public Node left;
        public Node right;
        private int height;

        public Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return this.val;
        }

        int getHeight() {
            return this.height;
        }

        void setHeight(int h) {
            this.height = h;
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

        return getHeight(node.left) - getHeight(node.right) <= 1 && checkBalanced(node.left) && checkBalanced(node.right);
    }


    void preOrderTraversal() {
        System.out.println("Preorder Traversal:");
        preorder(this.root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inOrderTraversal() {
        System.out.println("Inorder Traversal:");
        inorder(this.root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.getValue() + " ");
        inorder(node.right);
    }

    void postOrderTraversal() {
        System.out.println("postOrder Traversal:");
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getValue() + " ");

    }


}
