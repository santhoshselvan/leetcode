package com.codeprac;

import java.util.*;
import java.util.stream.Collectors;


public class LetterCombinationOfAPhoneNumber {
    public List<String> findCombinations(String input) {
        if (input.isBlank()) return Collections.emptyList();

        Map<String, List<String>> keypadText = new HashMap<>();
        keypadText.put("2", List.of("a", "b", "c"));
        keypadText.put("3", List.of("d", "e", "f"));
        keypadText.put("4", List.of("g", "h", "i"));
        keypadText.put("5", List.of("j", "k", "l"));
        keypadText.put("6", List.of("m", "n", "o"));
        keypadText.put("7", List.of("p", "q", "r", "s"));
        keypadText.put("8", List.of("t", "u", "v"));
        keypadText.put("9", List.of("w", "x", "y", "z"));

        var lettersCombinations = input.chars()
                .mapToObj(c -> keypadText.get(String.valueOf((char) c)))
                .collect(Collectors.toList());

        var totalCombinations = lettersCombinations.stream()
                .map(List::size)
                .reduce(1, (a, b) -> a * b);

        var result = new ArrayList<>(lettersCombinations.get(0));

        int index = 1;

        long startTime = System.currentTimeMillis();
        ArrayList<String> tempResult;
        while (index < lettersCombinations.size()) {
            tempResult = new ArrayList<>();
            for (String r : result) {
                for (String c : lettersCombinations.get(index))
                    tempResult.add(r + c);
            }

            result.addAll(tempResult);
            index++;
        }
        long stopTime = System.currentTimeMillis();

        List<String> strings = result.subList(result.size() - totalCombinations, result.size());
        System.out.println(stopTime - startTime);
        return strings;
    }
}
