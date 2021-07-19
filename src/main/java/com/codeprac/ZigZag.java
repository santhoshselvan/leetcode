package com.codeprac;

import java.util.stream.IntStream;

public class ZigZag {

    public String convert(String input, int numRows) {
        if (numRows == 1) return input;

        var stringBuffers = IntStream.range(0, numRows)
                .mapToObj(i -> new StringBuffer())
                .toArray(StringBuffer[]::new);
        var inputBuffer = new StringBuilder(input);

        boolean down = true;
        int index = 0;
        while(inputBuffer.length() != 0) {
            stringBuffers[index].append(inputBuffer.charAt(0));
            inputBuffer.deleteCharAt(0);

            if (index >= (numRows - 2) && down) {
                index++;
                down = false;
            } else if (index == 1 && !down) {
                index--;
                down = true;
            } else if (down) {
                index++;
            } else {
                index--;
            }
        }

        var result = new StringBuilder();
        for (StringBuffer stringBuffer : stringBuffers) {
            result.append(stringBuffer.toString());
        }
        return result.toString();
    }

}
