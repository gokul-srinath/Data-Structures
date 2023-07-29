package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubsetAndSubsequence {


    static String skipACharacter(String s, StringBuilder sb, char ch) {

        if (s.length() == 0) {
            return sb.toString();
        }

        StringBuilder org = new StringBuilder(s);
        char c = org.charAt(0);
        String s1 = org.substring(1).toString();
        if (c != ch) {
            sb.append(c);
        }

        return skipACharacter(s1, sb, ch);

    }

    static String skipACharacterWithoutArg(String s, char ch) {


        if (s.length() == 0) {
            return s;
        }
        StringBuilder org = new StringBuilder();
        StringBuilder sub = new StringBuilder(s);

        char c = s.charAt(0);
        String s1 = sub.substring(1).toString();

        if (c != ch) {
            org.append(c);

        }
        org.append(skipACharacterWithoutArg(s1, ch));
        return org.toString();

    }

    static void subSeq(String processed, String unprocessed) {

        if (unprocessed.length() == 0) {
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        String sub = unprocessed.substring(1);

        subSeq(processed + ch, sub);
        subSeq(processed, sub);


    }

    static List<String> subSeqArray(String processed, String unprocessed, List<String> arr) {

        if (unprocessed.length() == 0) {
            arr.add(processed);
            return arr;
        }

        char ch = unprocessed.charAt(0);
        String sub = unprocessed.substring(1);

        subSeqArray(processed + ch, sub, arr);
        subSeqArray(processed, sub, arr);

        return arr;

    }


    static List<String> subSeqArrayWithoutArg(String processed, String unprocessed) {

        List<String> arr = new LinkedList<>();

        if (unprocessed.length() == 0) {
            arr.add(processed);
            return arr;
        }

        char ch = unprocessed.charAt(0);
        String sub = unprocessed.substring(1);

        arr.addAll(subSeqArrayWithoutArg(processed + ch, sub));
        arr.addAll(subSeqArrayWithoutArg(processed, sub));

        return arr;

    }


    static List<List<Integer>> subSetIterative(int[] arr) {

        List<List<Integer>> outer = new LinkedList<>();
        outer.add(new LinkedList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internalArray = new LinkedList<>(outer.get(i));
                internalArray.add(num);
                outer.add(internalArray);
            }
        }

        return outer;

    }

    public static void main(String[] args) {
        String s = "abc";
        int[] arr = {1,2,3};

//        char target = 'a';
//        System.out.println(skipACharacter(s, new StringBuilder(), target));
//        System.out.println(skipACharacterWithoutArg(s, target));
//        subSeq("", s);
//        List<String> strings = subSeqArray("", s, new LinkedList<>());
//        List<String> strings1 = subSeqArrayWithoutArg("", s);
//        System.out.println(strings);
//        System.out.println(strings1);
        List<List<Integer>> lists = subSetIterative(arr);
        System.out.println(lists);
    }
}
