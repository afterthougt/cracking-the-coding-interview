package ch1arraysandstrings;

/**
 
 * 1.3 URLify: Write a method to replace all spaces in a string with
 * '%20'. You may assume that the string has sufficient at the end
 * to hold the additional characters, and that you are given the
 * 'true' length of the string. (Note: if implementing in Java, use
 * a character array so that you can perform this operation
 * in place.) */
public class URLify {
    void replaceSpaces(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0,
                                         trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        /* If there are excess spaces, add a null character.
         * This indicates that the spaces after that point have not
         * been replaced with %20. */
        if (newIndex + 1 < str.length) {
            str[newIndex + 1] = '\0';
        }
        for (int oldIndex = trueLength - 1; oldIndex > -1; oldIndex--) {
            if (str[oldIndex] == ' ') { /* Insert %20 */
                str[newIndex] = '0';
                str[newIndex-1] = '2';
                str[newIndex-2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                --newIndex;
            }
        }
    }

    /* Count occurences of target between start (inclusive) and 
     * end (exclusive). */
    int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        URLify u = new URLify();
        char[] chars = "Mr John Smith              ".toCharArray();
        u.replaceSpaces(chars, 16);
        System.out.println(chars);
    }
}
