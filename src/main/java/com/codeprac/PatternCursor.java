package com.codeprac;

class PatternCursor {
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
