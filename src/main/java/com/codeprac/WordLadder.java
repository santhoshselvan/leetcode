package com.codeprac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.codeprac.WordLadder.DiffResult.DIFF_MORE_THAN_ONE;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class WordLadder {
    enum DiffCount {
        ONE, MORE_THAN_ONE
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        return 0;
    }

    public List<String> findLadder(String beginWord, String endWord, List<String> wordList) {
        System.out.println(beginWord + " -- " + endWord + " -- " + wordList);
        return findLadderHelper(beginWord, endWord, wordList, new ArrayList<>());
    }

    public List<String> findLadderHelper(String beginWord, String endWord, List<String> wordList, List<String> ladder) {
        ladder.add(beginWord);

        var diff = findDiff(beginWord, endWord);
        if (diff.diffCount.equals(DiffCount.ONE)) {
            ladder.add(endWord);
            System.out.println("Returning ladder : " + ladder);
            return ladder;
        } else {
            var wordsWithOneDiff = findWordsWithOneDiff(beginWord, wordList);
            if (wordsWithOneDiff.isEmpty()) {
                System.out.println("Returning ladder : " + emptyList());
                return emptyList();
            } else {

                Optional<ArrayList<String>> result = wordsWithOneDiff.stream().map(word -> {
                    var updatedWordList = new ArrayList<>(wordList);

                    var updatedLadder = new ArrayList<>(ladder);
                    updatedWordList.remove(word);
//                    System.out.println(beginWord + " -> " + word + ", " + endWord);
                    findLadderHelper(word, endWord, updatedWordList, updatedLadder);
                    System.out.println("Returning ladder : " + updatedLadder);
                    return updatedLadder;
                }).filter(list -> list.get(0).equals(beginWord) &&
                        list.get(list.size() - 1).equals(endWord))
                        .min(Comparator.comparing(List::size));
                ArrayList<String> strings = result.orElse(null);
//                System.out.println(strings);
                System.out.println("Returning ladder : " + strings);
                return strings;
            }
        }
    }

    private List<String> findWordsWithOneDiff(String beginWord, List<String> wordList) {
        return wordList.stream()
                .filter(word -> findDiff(beginWord, word).diffCount.equals(DiffCount.ONE))
                .collect(toList());
    }

    static class DiffResult {
        DiffCount diffCount;
        int diffIndex;

        public static DiffResult DIFF_MORE_THAN_ONE = new DiffResult(DiffCount.MORE_THAN_ONE, -1);

        public DiffResult(DiffCount diffCount, int diffIndex) {
            this.diffCount = diffCount;
            this.diffIndex = diffIndex;
        }

    }

    public DiffResult findDiff(String one, String two) {
        DiffCount diffCount = null;
        int diffIndex = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                if (diffCount == DiffCount.ONE) {
                    return DIFF_MORE_THAN_ONE;
                } else {
                    diffCount = DiffCount.ONE;
                    diffIndex = i;
                }
            }
        }
        return new DiffResult(DiffCount.ONE, diffIndex);
    }
}
