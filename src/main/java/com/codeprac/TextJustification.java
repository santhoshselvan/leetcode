package com.codeprac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        return fullJustify(Arrays.asList(words), maxWidth);
    }
    public List<String> fullJustify(List<String> words, int maxWidth) {
        var lines = createLines(words, maxWidth);
        int numberOfLines = lines.size();

        return IntStream.range(0, numberOfLines)
                .mapToObj(i -> {
                    boolean isLastLine = i == numberOfLines - 1;
                    var line = lines.get(i);
                    return line.format(isLastLine);
                })
                .collect(Collectors.toList());
    }

    public List<Line> createLines(List<String> words, int maxWidth) {
        List<Line> lines = new ArrayList<>();
        var currentLine = new Line(maxWidth);

        for (String word : words) {
            if (!currentLine.addWord(word)) {
                lines.add(currentLine);
                currentLine = new Line(maxWidth);
                currentLine.addWord(word);
            }
        }
        lines.add(currentLine);
        return lines;
    }

    static class Line {
        final int maxWidth;
        int currentWordsWidth = 0;

        public Line(int maxWidth) {
            this.maxWidth = maxWidth;
        }

        List<String> words = new ArrayList<>();

        public boolean addWord(String word) {
            if (checkEnoughSpaceForNextWord(word)) {
                return false;
            }
            words.add(word);
            updateCurrentWordsWidth();
            return true;
        }

        private boolean checkEnoughSpaceForNextWord(String nextWord) {
            int spacesBetweenCurrentWords = words.size();
            return currentWordsWidth + spacesBetweenCurrentWords + nextWord.length() > maxWidth;
        }

        public String format() {
            return format(false);
        }

        public String format(boolean leftAlign) {
            StringBuilder sb = new StringBuilder(maxWidth);

            int totalSpaces = totalSpacesInLine();
            if (words.size() == 1) {
                var word = words.get(0);
                sb.append(word);
                sb.append(" ".repeat(totalSpaces));
                return sb.toString();
            }

            if (!leftAlign) {
                int eachWordSpace = getEachWordSpace(totalSpaces);
                int remainingSpaces = getExtraSpaces(totalSpaces, eachWordSpace);
                for (int i = 0; i < words.size() - 1; i++) {
                    sb.append(words.get(i));
                    sb.append(" ".repeat(eachWordSpace));

                    if (remainingSpaces != 0) {
                        sb.append(" ");
                        remainingSpaces--;
                    }
                }

                sb.append(getLastWord());
            } else {
                for (int i = 0; i < words.size() - 1; i++) {
                    sb.append(words.get(i));
                    sb.append(" ");
                    totalSpaces--;
                }
                sb.append(words.get(words.size() - 1));
                if (totalSpaces > 0)
                    sb.append(" ".repeat(totalSpaces));
            }

            return sb.toString();
        }

        private String getLastWord() {
            return words.get(words.size() - 1);
        }

        private int getExtraSpaces(int totalSpaces, int eachWordSpace) {
            return totalSpaces - (eachWordSpace * (words.size() - 1));
        }

        private int getEachWordSpace(int totalSpaces) {
            return totalSpaces / (words.size() - 1);
        }

        private int totalSpacesInLine() {
            return maxWidth - currentWordsWidth;
        }

        private void updateCurrentWordsWidth() {
            this.currentWordsWidth = words.stream().mapToInt(String::length).reduce(Integer::sum).getAsInt();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Objects.equals(words, line.words);
        }

        @Override
        public int hashCode() {
            return Objects.hash(words);
        }

        @Override
        public String toString() {
            return "Line{" +
                    "currentWordsWidth=" + currentWordsWidth +
                    ", words=" + words +
                    '}';
        }
    }
}
