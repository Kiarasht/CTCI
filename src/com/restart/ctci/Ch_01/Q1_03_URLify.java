package com.restart.ctci.Ch_01;


public class Q1_03_URLify {
    /*
    Write a method to replace all spaces in a string with '%20: You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)

    Time: O(n^2) - Should be O(n^2) since on worst cases (lots of empty chars), we will be copying and traversing through the array again and again
    Space: O(1) - We are not using any additional memory, O(1) if you don't count the incoming char[], O(n) if you do.
     */
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith    ".toCharArray()));
    }

    private static char[] URLify(char[] url) {
        for (int i = 0; i < url.length; ++i) {
            if (url[i] == ' ') {
                /*
                for (int j = url.length - 3; j > i; --j) {
                    url[j + 2] = url[j];
                }

                The array copy can also be replaced with the above for each loop.
                 */
                System.arraycopy(url, i + 1, url, i + 1 + 2, url.length - 3 - i);
                url[i] = '%';
                url[i + 1] = '2';
                url[i + 2] = '0';
            }
        }

        return url;
    }
}
