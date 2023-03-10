package ch1arraysandstrings;

import java.util.Arrays;

/**

 * 1.8 Zero Matrix: Write an algorithm such that if an element in an
 * MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
    void setZeros1(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        // Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) nullifyColumn(matrix, j);
        }
    }

    void setZeros2(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // Check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // Check for zeros in the rest of the array
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Nullify rows based on values in frist column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify columns based on values in first row
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        // Nullify first row
        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }

        // Nullify first column
        if (colHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void main(String[] args) {
        ZeroMatrix zm = new ZeroMatrix();
        int[][] matrix1 = {
            {1, 2, 3,},
            {4, 0, 6,},
            {7, 8, 9,},
        };
        int[][] matrix2 = {
            {1, 2, 3,},
            {4, 5, 6,},
            {7, 8, 0,},
        };
        zm.setZeros1(matrix1);
        zm.setZeros2(matrix2);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
    }
}
