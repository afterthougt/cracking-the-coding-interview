package ch1arraysandstrings;

import java.util.Arrays;

/**
 
 * 1.2 Check Permutation: Given two strings, write a method to decide
 * if one is a permutation of the other. */
public class CheckPermutation {
    String sort1(String s) {
        /* Time complexity: O(N log N) */
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    boolean permutation1(String s, String t) {
        if (s.length() != t.length()) return false;

        return sort1(s).equals(sort1(t));
    }

    boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Permutations must be same length.
        }

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }
        // Letters has no neg values, and therefore
        // no pos values either.
        return true;
    }

    public static void main(String[] args) {
        CheckPermutation cp = new CheckPermutation();
        String s1 = "check";
        String s2 = "ckech";
        System.out.println(cp.permutation1(s1, s2));
        System.out.println(cp.permutation2(s1, s2));
    }
}
