package ch1arraysandstrings;
/**

 * 1.9 String Rotation: Assume you have a method isSubstring which 
 * checks if one word is a substring of another. Given two strings,
 * s1 and s2, wirte code to check if s2 is a rotation of s1 using
 * only one call to isSubstring (e.g., "waterbottle" is a rotation
 * of "erbottlewat").
 */
public class StringRotation {
    boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* Check that s1 and s2 are equal length and not empty. */
        if (len == s2.length() && len > 0) {
            /* Concatenate s1 and s1 within new buffer. */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        StringRotation sr = new StringRotation();
        System.out.println(sr.isRotation("abcd", "cdab"));
        System.out.println(sr.isRotation("abcd", "cdba"));
    }
}
