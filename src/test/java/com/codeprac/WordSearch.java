package com.codeprac;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        var index = 0;
        List<Index> indices = getCharFromBoard(board, word.charAt(index));
        while (index < word.length() - 1) {
            boolean foundLetter = false;
            List<Index> nextIndices = new ArrayList<>();
            for (int i = 0; i < indices.size(); i++) {
                List<Index> neighbours = getNeighbours(board, indices.get(i));
                char currentChar = word.charAt(index + 1);
                List<Index> validNeighbours = filterChar(neighbours, board, currentChar);
                if (validNeighbours.isEmpty()) continue;
                nextIndices.addAll(validNeighbours);
                foundLetter = true;
            }
            if (!foundLetter) return false;
            indices = nextIndices;
            index++;
        }
        return index == word.length() - 1;
    }

    @NotNull
    private List<Index> filterChar(List<Index> neighbours, char[][] board, char character) {
        return neighbours.stream()
                .filter(fi -> board[fi.i][fi.j] == character)
                .collect(toList());
    }

    public static List<Index> getNeighbours(char[][] board, Index index) {
        List<Index> result = new ArrayList<>();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == j && j == 0) continue;
                try {
                    var checkValid = board[index.i + i][index.j + j];
                    result.add(Index.of(index.i + i, index.j + j));
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return result;
    }

    private List<Index> getCharFromBoard(char[][] board, char character) {
        List<Index> indices = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == character) {
                    indices.add(new Index(i, j));
                }
            }
        }
        return indices;
    }

    static class Index {
        int i;
        int j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public static Index of(int i, int j) {
            return new Index(i, j);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return i == index.i &&
                    j == index.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "Index{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
