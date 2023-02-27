package ch1arraysandstrings;

import java.util.Arrays;

/**

 * 1.7 Rotate Matrix: Given an image represented by an NxN matrix,
 * where each pixel in the image is represented by an integer, write
 * a method to ratate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {
    boolean rotate(int[][] matrix) {
        /* time complexity: O(n^2) */
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return false;
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        if (rm.rotate(matrix))
            System.out.println(Arrays.deepToString(matrix));
        else
            System.out.println("Invalid matrix input");
    }
}
