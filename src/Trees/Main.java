package Trees;

public class Main {
    public static void main(String[] args) {

//        BinaryTree bt = new BinaryTree();
//
//        bt.populate();
//        bt.display();

//        BinarySearchTree bst = new BinarySearchTree();
//
//        bst.display();
//
//        bst.insert(15);
//        bst.insert(25);
//        bst.insert(6);
//        bst.insert(9);
//        bst.insert(5);
//        bst.insert(3);
//        bst.insert(1);
//        bst.insert(24);
//        bst.insert(29);
//        bst.insert(4);
//
//        bst.display();
//
//        System.out.println(bst.checkBalanced());
//
//        bst.preOrderTraversal();
//        bst.inOrderTraversal();
//        bst.postOrderTraversal();

        AVL avl = new AVL();

        avl.insert(15);
        avl.insert(6);
        avl.insert(7);
        avl.insert(4);
        avl.insert(3);
        avl.insert(2);


        avl.display();

        System.out.println("height:" + avl.getHeight());


    }
}
