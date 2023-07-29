package linkedlist;

public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {

    }

    public LinkedList(Node node) {
        this.head = node;
//        this.tail = node;
    }


    void add(int val) {
        Node node = new Node(val);

        if (this.head == null) {
            this.head = node;
            return;
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public String toString() {
        Node temp = this.head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.val);
            sb.append("->");
            temp = temp.next;
        }
        sb.append("null");
        return sb.toString();
    }

    void insert(int val, int inx) {
        Node node = new Node(val);
        Node temp = this.head;

        if (inx == 0 || this.head == null) {
            this.head = node;
            this.head.next = temp;
            return;
        }

        while (temp.next != null && inx > 1) {
            inx--;
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;

    }

    void insertRecursively(int val, int inx) {

        Node node = new Node(val);
        Node temp = this.head;
        if (inx == 0) {
            this.head = node;
            this.head.next = temp;
            return;
        } else {
            irhelper(val, inx, this.head);
        }
    }

    Node irhelper(int val, int inx, Node temp) {

        if (inx == 0) {
            Node node = new Node(val);
            node.next = temp;
            return node;
        }

        if(temp==null) {
            Node node = new Node(val);
            return node;
        }

        Node nextNode = irhelper(val, inx - 1, temp.next);
        temp.next = nextNode;
        return temp;
    }


}
