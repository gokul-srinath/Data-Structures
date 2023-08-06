package Trees;

public class SegmentTree {


    public SegmentTree(int[] arr) {
        this.root = populate(arr, 0, arr.length - 1);
    }

    public class Node {
        int data;
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end) {

            this.start = start;
            this.end = end;
        }

        public int getValue() {
            return this.data;
        }
    }

    Node root;


    Node populate(int[] arr, int start, int end) {

        if (start == end) {
            Node node = new Node(start, end);
            node.data = arr[start];
            node.start = start;
            node.end = end;
            return node;
        }

        Node node = new Node(start, end);
        int mid = start + (end - start) / 2;

        node.start = start;
        node.end = end;

        node.left = populate(arr, start, mid);
        node.right = populate(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;

        return node;
    }


    void display() {
        display(this.root, 0);
    }

    void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("\t\t");
        }
        System.out.println(node.data);
        for (int i = 0; i < level; i++) {
            System.out.print("\t\t");
        }
        System.out.println(node.start + "-" + node.end);


        display(node.left, level + 1);
    }


    int query(int start, int end) {
        if (this.root == null) {
            return 0;
        }
        if (end < this.root.start) {
            return 0;
        }
        if (start > this.root.end) {
            return 0;
        }

        return query(this.root, start, end);
    }

    int query(Node node, int start, int end) {
        int sum=0;

        if(start > node.end) {
            return 0;
        }
        if(end < node.start) {
            return 0;
        }

        if(node.start >= start && node.end <= end) {
            return node.data;
        }

//        if((start == node.start || end == node.start) && node.start == node.end) {
//            return node.data;
//        }


        sum+=query(node.left,start,end) + query(node.right,start,end);
        return sum;
    }

}
