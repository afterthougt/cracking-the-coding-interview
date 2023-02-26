package ch1arraysandstrings;

/**

 * 1.4 Palindrome Permutation: Given a string, write a function to
 * check if it is a permutation of a palindrome. A palindrome is a word
 * or phrase that is the same forwards and backwards. A permutation is
 * a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words. */
public class PalindromePermutation {
    boolean isPermutationOfPalindrome1(String phrase) {
        /* time complexity: O(N) */
        int[] table = buildCharFrequencyTable1(phrase);
        return checkMaxOneOdd(table);
    }

    /* Check that no more than one character has an odd count. */
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if ((count & 1) > 0) { /* odd count */
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /* Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
     * This is case incensitive. Non-letter characters map to -1. */
    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    /* Count how many times each character appears. */
    int[] buildCharFrequencyTable1(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - 
                              Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                ++table[x];
            }
        }
        return table;
    }

    boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') -
                              Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                ++table[x];
                if ((table[x] & 1) > 0) { /* Odd table[x] */
                    ++countOdd;
                } else {
                    --countOdd;
                }
            }
        }
        return countOdd <= 1;
    }

    /* Toggle the i-th bit in the integer. */
    int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        bitVector ^= mask;
        return bitVector;
    }

    /* Create bit vector for string. For each letter with value i,
     * toggle the i-th bit. */
    int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /* Check that at most one bit is set by subtracting one from
     * the integer and ANDing it with the original integer. */
    boolean checkAtMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    boolean isPermutationOfPalindrome3(String phrase) {
        /* time complexity: O(N) */
        int bitVector = createBitVector(phrase);
        return checkAtMostOneBitSet(bitVector);
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        String s = "tact coa";
        System.out.println(pp.isPermutationOfPalindrome1(s));
        System.out.println(pp.isPermutationOfPalindrome2(s));
        System.out.println(pp.isPermutationOfPalindrome3(s));
    }
}
