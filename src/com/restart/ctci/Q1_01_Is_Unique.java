package com.restart.ctci;

public class Q1_01_Is_Unique {

    /*
    Implement an algorithm to determine if a string has all unique characters.

    Time: O(1) - Strings longer than 128 will return false. The loop can not exceed 128, therefore having a constant time complexity.
    Space: O(1) - Using only a static array, therefore, the space complexity is constant as well.
    */
    public static void main(String[] args) {
        for (String aWord : new String[]{"abcde", "hello", "apple", "kite", "padle", "4Afks2R%", "aA", "asddsa", "#$@3S", "#das#"}) {
            System.out.println(aWord + ": " + Is_Unique(aWord));
        }
    }

    private static boolean Is_Unique(String word) {
        if (word == null || word.length() == 0 || word.length() == 1 || word.length() > 128) {
            return false;
        }

        boolean[] asciiCharacter = new boolean[128];
        for (String aLetter : word.split("")) {
            int index = aLetter.charAt(0);

            if (asciiCharacter[index]) {
                return false;
            } else {
                asciiCharacter[index] = true;
            }
        }

        return true;
    }
}
