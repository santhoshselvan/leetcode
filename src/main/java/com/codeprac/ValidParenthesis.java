package com.codeprac;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String input) {

        Stack<Character> stack = new Stack<>();
        for (char parenthesis : input.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(parenthesis);
                continue;
            }
            var peeked = stack.peek();
            if (doesMatch(peeked, parenthesis)) {
                stack.pop();
            } else {
                stack.push(parenthesis);
            }
        }

        return stack.isEmpty();
    }

    private boolean doesMatch(Character peeked, char parenthesis) {
        if (peeked == '(' && parenthesis == ')') return true;
        else if (peeked == '{' && parenthesis == '}') return true;
        else if (peeked == '[' && parenthesis == ']') return true;
        return false;
    }
}
