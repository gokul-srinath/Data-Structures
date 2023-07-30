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

        if (temp == null) {
            Node node = new Node(val);
            return node;
        }

        Node nextNode = irhelper(val, inx - 1, temp.next);
        temp.next = nextNode;
        return temp;
    }


    void removeDuplicates() {

        rdHelper(this.head);
    }

    Node rdHelper(Node temp) {
        if (temp == null) {
            return null;
        }

        Node nextNode = rdHelper(temp.next);
        if (nextNode != null && temp.val == nextNode.val) {
            return nextNode;
        }
        temp.next = nextNode;
        return temp;
    }

    boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;


    }


    boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {

            slow = findSquares(n);
            fast = findSquares(findSquares(n));

        } while (slow != fast);

        if (slow == 1) {
            return true;
        }


        return false;

    }


    int findSquares(int n) {
        int res = 0;
        while (n > 0) {
            int r = n % 10;
            res += r * r;
            n /= 10;
        }
        return res;
    }


    Node middleNode() {
        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    void reverseList() {

        revHelper(head);
    }

    private Node revHelper(Node head) {
        if (head == null || head.next == null) {
            this.head = head;
            return head;
        }

        Node returnNode = revHelper(head.next);
        returnNode.next = head;
        head.next = null;
        return head;
    }


}
