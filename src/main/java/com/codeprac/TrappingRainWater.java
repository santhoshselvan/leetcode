package com.codeprac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrappingRainWater {
    public int trap(int[] heights) {
        var collectedRainWater = 0;

        List<Integer> afterPreviousHigh = new ArrayList<>();
        var previousHigh = 0;

        for (int height : heights) {
            if (height >= previousHigh) {
                for (Integer item : afterPreviousHigh) {
                    collectedRainWater += previousHigh - item;
                }
                previousHigh = height;
                afterPreviousHigh = new ArrayList<>();
            }
            afterPreviousHigh.add(height);
        }

        if (afterPreviousHigh.size() > 2)
            collectedRainWater += trap(reverseToArray(afterPreviousHigh));
        return collectedRainWater;
    }

    private int[] reverseToArray(List<Integer> list) {
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
