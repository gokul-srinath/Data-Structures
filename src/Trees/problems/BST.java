package Trees.problems;

import Trees.BinarySearchTree.*;

public class BST {

    public boolean findTarget(Node root, int k) {
        if(root == null) {
            return false;
        }
        Node node = searchBST(root,Math.abs(root.val-k));
        if(node != null) {
            return true;
        }
        return findTarget(root.left,k) || findTarget(root.right,k);

    }

    Node searchBST(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (node.getValue() == val) {
            return node;
        } else if (node.getValue() > val) {
            return searchBST(node.left, val);
        } else {
            return searchBST(node.right, val);
        }
    }

    public static void main(String[] args) {

    }
}
