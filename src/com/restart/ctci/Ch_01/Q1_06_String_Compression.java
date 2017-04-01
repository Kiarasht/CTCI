package com.restart.ctci.Ch_01;


public class Q1_06_String_Compression {
    /*
    Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).

    Time: O(n) since we will be traversing each character of the input string.
    Space: O(n) since we are creating a new char array of size input.length().
    */
    public static void main(String[] args) {
        System.out.println(string_compression("aaaaabbbbaaaabbddc"));
    }

    private static String string_compression(String input) {
        if (input == null) {
            return null;
        } else if ("".equals(input)) {
            return input;
        }

        char[] inputChar = input.toCharArray();
        StringBuilder compressed = new StringBuilder();
        char current = inputChar[0];
        int frequency = 0;

        for (char aChar : inputChar) {
            if (current == aChar) {
                ++frequency;
            } else {
                compressed.append(current).append(frequency);
                current = aChar;
                frequency = 1;
            }
        }

        compressed.append(current).append(frequency);
        String finalCompressed = compressed.toString();
        return finalCompressed.length() >= input.length() ? input : finalCompressed;
    }
}
