package com.codeprac;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.util.stream.IntStream.range;

public class NearestZeroMatrix {
    public int[][] updateMatrix(int[][] mat) {
        List<Pair> zeros = new ArrayList<>();
        List<Pair> nonZeros = new ArrayList<>();
        var result = new int[mat.length][mat[0].length];
        range(0, mat.length).forEach(i -> {
            range(0, mat[0].length).forEach(j -> {
                if (mat[i][j] == 0) {
                    zeros.add(new Pair(i, j));
                    result[i][j] = 0;
                } else {
                    nonZeros.add(new Pair(i, j));
                }
            });
        });

        nonZeros.forEach(nonZero -> {
            var min = zeros.stream()
                    .mapToInt(zero -> abs(nonZero.i - zero.i) + abs(nonZero.j - zero.j))
                    .min();
            if (min.isPresent()) {
                result[nonZero.i][nonZero.j] = min.getAsInt();
            }
        });

        return result;
    }

    static class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
