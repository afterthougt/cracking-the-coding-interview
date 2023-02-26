package ch1arraysandstrings;

/**

 * 1.1 Is Unique: Implement an algorithm to determine if a string
 * has all unique characters. What if you cannot use additional
 * data structures?
 */
public class IsUnique {
    /* You should first ask your interviewer
     * if the string is an ASCII string or a Unicode string.
     */
    boolean isUnique1(String str) {
        // Time complexity: O(N)
        // (or O(1) since the for loop will never iterate
        // through more than 128 characters.)
        // Space complexity: O(1)
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) { // Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    boolean isUnique2(String str) {
        /* Reduce our space usage by a factor of eight
         * by using a bit vector. */
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        IsUnique iu = new IsUnique();
        String s = "abcdb";
        System.out.println(iu.isUnique1(s));
        System.out.println(iu.isUnique2(s));
    }
}