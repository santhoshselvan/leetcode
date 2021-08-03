package com.codeprac;
public class RegExMatcher {

    public boolean isMatch(String input, String pattern) {
        if (!pattern.contains(".") && !pattern.contains("*")) {
            return input.equals(pattern);
        }

        var patternCursor = new PatternCursor(pattern);

        var inputIndex = 0;
        var currentPattern = patternCursor.next();
        while (inputIndex < input.length() && currentPattern != null) {
            char currentCharacter = input.charAt(inputIndex);
            if (currentPattern.endsWith("*")) {
                if (currentCharacter == currentPattern.charAt(0) || currentPattern.charAt(0) == '.') {
                    System.out.println(currentCharacter + " matches " + currentPattern);
                    inputIndex++;
                    if (inputIndex == input.length()) {
                        while((currentPattern = patternCursor.next()) != null) {
                            if (!currentPattern.equals(String.valueOf(currentCharacter)) && !currentPattern.endsWith("*"))
                                return false;
                        }

                    }
                } else {
                    currentPattern = patternCursor.next();
                }
                continue;
            } else if (currentPattern.equals(".")) {
                System.out.println(currentCharacter + " matches " + currentPattern);
                currentPattern = patternCursor.next();
            } else {
                if (currentCharacter != currentPattern.charAt(0)) return false;
                System.out.println(currentCharacter + " matches " + currentPattern);
                currentPattern = patternCursor.next();
            }
            inputIndex++;
        }
        return inputIndex == input.length() && currentPattern == null;
    }

    static class PatternCursor {
        String pattern;
        int index;

        public PatternCursor(String pattern) {
            this.pattern = pattern;
            this.index = 0;
        }

        public String next() {
            if (index == pattern.length()) return null;

            var currentChar = pattern.charAt(index);
            if (index == (pattern.length() - 1)) {
                index++;
                return String.valueOf(currentChar);
            }


            var nextChar = pattern.charAt(index + 1);
            if (nextChar == '*' || nextChar == '+') {
                index += 2;
                return currentChar + String.valueOf(nextChar);
            }

            index++;
            return String.valueOf(currentChar);
        }
    }
}

