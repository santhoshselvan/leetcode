package com.codeprac;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        var prefix = new StringBuilder();
        var index = 0;
        char prefixCharacter = 0;
        while(true) {
            for (int i = 0; i < strs.length; i++) {
                if (index == strs[i].length()) return prefix.toString();

                String str = strs[i];
                char current = str.charAt(index);
                if (i == 0) {
                    prefixCharacter = current;
                } else if (current != prefixCharacter) {
                    return prefix.toString();
                }

                if (i == strs.length - 1) {
                    prefix.append(prefixCharacter);
                }
            }
            index++;
        }
    }
}
