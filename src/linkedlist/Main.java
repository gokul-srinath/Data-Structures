package linkedlist;

public class Main {


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(5);
        ll.add(4);
        ll.add(1);
        ll.add(7);
        System.out.println(ll);

        ll.insert(3,6);
        System.out.println(ll);
        ll.insertRecursively(8,5);
        System.out.println(ll);
    }
}
