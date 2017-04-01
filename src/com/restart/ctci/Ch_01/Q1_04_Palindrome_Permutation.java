package com.restart.ctci.Ch_01;


public class Q1_04_Palindrome_Permutation {
    /*
    Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

    EXAMPLE:
    Input: Tact Coa
    Output: True (permutations: "taco cat". "atco cta". etc.)

    Time: O(n^2) - It will be O(n) since only the first loop goes through every string character. Second one is always constant
    Space: O(1) - No additional memory so, O(1) for space.
    */
    public static void main(String[] args) {
        System.out.println(palindrome_permutation("Zeus was deified saw Suez"));
    }

    private static boolean palindrome_permutation(String input) {
        input = input.toLowerCase();
        int[] frequency = new int[128];
        int spaces = 0;

        for (String aLetter: input.split("")) {
            if (!aLetter.equals(" ")) {
                frequency[aLetter.charAt(0)] += 1;
            } else {
                ++spaces;
            }
        }

        boolean even = (input.length() - spaces) % 2 == 0;
        boolean check = false;

        for (int aFrequency: frequency) {
            boolean extra = aFrequency % 2 == 1;

            if (even && extra) {
                return false;
            } else if (!even && extra) {
                if (check) {
                    return false;
                }
                check = true;
            }
        }

        return true;
    }
}
