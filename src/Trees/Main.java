package Trees;

public class Main {
    public static void main(String[] args) {

//        BinaryTree bt = new BinaryTree();
//
//        bt.populate();
//        bt.display();

        BinarySearchTree bst = new BinarySearchTree();

        bst.display();

        bst.insert(15);
        bst.insert(6);
        bst.insert(9);
        bst.insert(20);
        bst.insert(27);
        bst.insert(28);
        bst.insert(29);
        bst.insert(37);
        bst.insert(5);

        bst.display();

        System.out.println(bst.checkBalanced());
    }
}
