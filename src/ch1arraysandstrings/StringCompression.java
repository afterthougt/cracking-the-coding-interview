package ch1arraysandstrings;

/**

 * 1.6 String Compression: Implement a method to perform basic string
 * compression using the counts of repeated characters. For example,
 * the string aabcccccaaa would become a2b1c5a3. If the "compressed"
 * string would not become smaller than the original string, your
 * method should return the original string. You can assume the string
 * has only uppercase and lowercase letters (a-z).
 */
public class StringCompression {
    String compressBad(String str) {
        /* time complexity: O(p + k^2)
         * where p is the size of the original string and
         * k is the number of character sequences. */
        String compressdString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            ++countConsecutive;

            /* If next character is different than current
             * append this char to result. */
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressdString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressdString.length() < str.length()
            ? compressedString : str;
    }

    String compress1(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            ++countConsecutive;

            /* If next character is different than current,
             * append this chart to result. */
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length()
            ? compressed.toString() : str;
    }

    String compress2(String str) {
        /* Check final length and return input string if it would
         * be longer. */
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        /* Initial capacity */
        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            ++countConsecutive;

            /* If next character is different than current, append
             * this char to result. */
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            ++countConsecutive;

            /* If next character is different than current, increase
             * the length. */
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedLength += 1 + String.valueOf(countConsecutive)
                                              .length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        String s = "aabbbcccccd";
        System.out.println(sc.compress1(s));
        System.out.println(sc.compress2(s));
    }
}
