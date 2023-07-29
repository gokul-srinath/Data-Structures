package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    static void perm(String un, String p) {
        if (un.length() == 0) {
            System.out.println(p);
            return;
        }

        char c = un.charAt(0);

        for (int i = 0; i < p.length() + 1; i++) {
            String temp = p.substring(0, i) + c + p.substring(i);
            perm(un.substring(1), temp);
        }

    }


    static List<String> permWithList(String un, String p) {
        List<String> outer = new ArrayList<>();

        if (un.length() == 0) {
            outer.add(p);
            return outer;
        }

        char c = un.charAt(0);

        for (int i = 0; i < p.length() + 1; i++) {
            String temp = p.substring(0, i) + c + p.substring(i);
            outer.addAll(permWithList(un.substring(1), temp));
        }

        return outer;

    }


    static List<String> combinationOfPhone(String un, String p, String ph) {
        List<String> outer = new LinkedList<>();

        if (un.length() == 0) {
            outer.add(ph);
            return outer;
        }

        char ch = un.charAt(0);
        int n = (ch == '7' || ch == '9') ? 4 : 3;
        int start = (ch - '2') * 3 + 'a';

        if (ch > '7') {
            start = start + 1;
        }

        for (int i = 0; i <= p.length(); i++) {


            String temp = p.substring(0, i) + ch + p.substring(i);
            for (int j = 0; j < n; j++) {

                char c = (char) (start + j);
                outer.addAll(combinationOfPhone(un.substring(1), temp, ph + c));
            }


        }

        return outer;
    }

    public static void main(String[] args) {
//        perm("abc", "");
        List<String> strings = combinationOfPhone("23", "", "");
        System.out.println(strings);
    }
}
