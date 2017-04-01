package com.restart.ctci.Ch_01;


public class Q1_05_One_Away {
    /*
    There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away.

    EXAMPLE
    pale, pIe -> true
    pales. pale -> true
    pale. bale -> true
    pale. bake -> false

    Time: O(n) - A simple traversal loop which goes through each character of the char arrays
    Space: O(n) - We are creating two char arrays based on length of the string, therefore O(2n) simplified to O(n)
    */
    public static void main(String[] args) {
        System.out.println(one_away("pale", "pse"));
    }

    private static boolean one_away(String one, String two) {
        if (Math.abs(one.length() - two.length()) > 1) {
            return false;
        }

        if (one.length() == two.length()) {
            return check_replace(one, two);
        } else if (one.length() > two.length()) {
            return check_insert_remove(one, two);
        } else {
            return check_insert_remove(two, one);
        }
    }

    /* Length are the same, so one of the characters has been replaced */
    private static boolean check_replace(String one, String two) {
        char[] oneChar = one.toCharArray();
        char[] twoChar = two.toCharArray();
        boolean oneChance = false;

        for (int i = 0; i < oneChar.length; ++i) {
            if (oneChar[i] != twoChar[i]) {
                if (oneChance) {
                    return false;
                }

                oneChance = true;
            }
        }

        return true;
    }

    /* Length is different by one, so a character was removed or inserted */
    private static boolean check_insert_remove(String one, String two) {
        char[] oneChar = one.toCharArray();
        char[] twoChar = two.toCharArray();
        int indexOne = 0;
        int indexTwo = 0;
        boolean oneChance = false;

        for (char ignored : twoChar) {
            if (oneChar[indexOne] != twoChar[indexTwo]) {
                if (oneChance) {
                    return false;
                }
                oneChance = true;
                ++indexOne;
            } else {
                ++indexOne;
                ++indexTwo;
            }
        }

        return ((indexOne != indexTwo) && oneChance) || ((indexOne == indexTwo) && !oneChance);
    }
}
