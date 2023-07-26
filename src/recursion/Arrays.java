package recursion;

import java.util.LinkedList;
import java.util.List;

public class Arrays {


    static boolean checkSorted(int[] arr, int inx) {
        if (arr.length - 1 < 0 || arr.length - 1 == inx) {
            return true;
        }

        return (arr[inx] < arr[inx + 1]) && checkSorted(arr, inx + 1);

    }

    static int linearSearch(int[] arr, int target, int inx) {
        if (arr.length == inx) {
            return -1;
        }
        if (arr[inx] == target) {
            return inx;
        }
        return linearSearch(arr, target, inx + 1);
    }

    static List<Integer> findAllIndex(int[] arr, int target, int inx, List<Integer> list) {
        if (arr.length == inx) {
            return list;
        }
        if (arr[inx] == target) {
            list.add(inx);
        }

        return findAllIndex(arr, target, inx + 1, list);
    }

    static List<Integer> findAllIndexWithoutArgs(int[] arr, int target, int inx) {

        List<Integer> list = new LinkedList<>();
        if (arr.length == inx) {
            return list;
        }
        if (arr[inx] == target) {
            list.add(inx);
        }
        list.addAll(findAllIndexWithoutArgs(arr, target, inx + 1));
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 4, 6, 7};
//        boolean ans = checkSorted(arr,0);
//        int ans = linearSearch(arr,15,0);
//        List<Integer> ans = findAllIndex(arr, 5, 0, new LinkedList<>());
        List<Integer> ans = findAllIndexWithoutArgs(arr, 5, 0);
        System.out.println(ans);
    }
}
