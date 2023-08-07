package Trees;

import java.util.Arrays;

public class MaxHeap {

    int[] arr;

    public MaxHeap(int[] arr) {
        this.arr = arr;
    }

    public MaxHeap() {
        arr = new int[]{};
    }


    void insert(int val) {
        int n = arr.length;
        int[] newArr = Arrays.copyOf(arr, n + 1);
        newArr[n] = val;
        this.arr = newArr;
        reviseInsert(arr, n);
    }

    void swap(int[] arr, int inx1, int inx2) {
        int temp = arr[inx1];
        arr[inx1] = arr[inx2];
        arr[inx2] = temp;
    }

    void reviseInsert(int[] arr, int inx) {
        int p = (int) Math.floor(inx / 2);
        if (p == inx) {
            return;
        }
        if (arr[p] < arr[inx]) {
            swap(arr, p, inx);
        }
        reviseInsert(arr, p);
    }


    int delete() {
        int n = arr[0];
        int len = arr.length;
        this.arr[0] = this.arr[len - 1];
        reviseDelete(0, len);
        int[] newArr = Arrays.copyOf(arr, len - 1);
        this.arr = newArr;
        return n;
    }

    void reviseDelete(int inx, int len) {
        if (inx >= len) {
            return;
        }
        int p = (int) Math.floor(inx / 2);
        if (p != inx) {
            if (arr[inx] > arr[p]) {
                swap(arr, p, inx);
            }
            if (arr[inx] <= p) {
                return;
            }
        }


        reviseDelete(2 * inx + 1, len);
        reviseDelete(2 * inx + 2, len);
    }

    void display() {
        display(0);
        System.out.println("END");
    }

    private void display(int inx) {
        if (inx > this.arr.length - 1) {
            return;
        }
        System.out.print(arr[inx] + "->");
        display(inx + 1);
    }

    void displayTree() {
        displayTree(0);
        System.out.println("----------------------------------");
    }

    private void displayTree(int inx) {
        if (inx > this.arr.length - 1) {
            return;
        }

        displayTree(2 * inx + 2);
        int spaces = (int) (Math.log(inx + 1) / Math.log(2));

        for (int i = 0; i < spaces; i++) {
            System.out.print("\t\t");
        }
        System.out.println(arr[inx]);
        displayTree(2 * inx + 1);
    }


    int[] heapSort() {
        int n = arr.length;
        int[] newArr = Arrays.copyOf(arr, n);
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = delete();
        }

        this.arr = newArr;
        return sorted;

    }


    void heapify() {
        for (int i = arr.length - 1; i > 0; i--) {
            heapify(arr, i);
        }
    }

    private void heapify(int[] arr, int inx) {
        if (inx >= arr.length) {
            return;
        }
        int p = (int) (Math.floor(inx / 2));
        if (arr[inx] > arr[p]) {
            swap(arr, p, inx);
            heapify(arr, p);
        }

        return;

    }


}
