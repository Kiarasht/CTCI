package com.restart.ctci;


public class Q1_02_Check_Permutation {

    /*
    Given two strings, write a method to decide if one is a permutation of the other.

    Time: O(n) - Looping twice for each character in the string, therefore the time complexity is O(2n) or just O(n).
    Space: O(1) - Only using a static array of size 128. In that case, space is only constant.
     */
    public static void main(String[] args) {
        for (String[] pair : new String[][]{{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}}) {
            boolean anagram = check_permutation(pair[0], pair[1]);
            System.out.println(pair[0] + ", " + pair[1] + ": " + anagram);
        }
    }

    private static boolean check_permutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length()) {
            return false;
        }

        int[] frequency = new int[128];
        for (String aLetter : one.split("")) {
            frequency[aLetter.charAt(0)] += 1;
        }

        for (String aLetter : two.split("")) {
            frequency[aLetter.charAt(0)] -= 1;

            if (frequency[aLetter.charAt(0)] < 0) {
                return false;
            }
        }

        return true;
    }
}
