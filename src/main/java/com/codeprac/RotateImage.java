package com.codeprac;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                swap(matrix, i, j, matrix.length);
//            }
//        }

        System.out.println(Arrays.deepToString(matrix));
        int m = matrix.length;

        for (int i = 0; i < m; i ++) {
            for (int j = m-1; j >=i ; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        int leftColumn = 0;
        int rightColumn = m -1;
        while (leftColumn < rightColumn) {
            for (int i = 0; i < m; i ++){
                int temp = matrix[i][leftColumn];
                matrix[i][leftColumn] = matrix[i][rightColumn];
                matrix[i][rightColumn] = temp;
            }
            leftColumn++;
            rightColumn--;
        }

        System.out.println(Arrays.deepToString(matrix));

    }

    private void swap(int[][] matrix, int i, int j, int n) {
        var temp = matrix[i][j];
        matrix[i][j] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
    }

}
