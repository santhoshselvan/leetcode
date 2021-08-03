package com.codeprac;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numbersAndIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var remaining = target - nums[i];
            if (numbersAndIndices.containsKey(remaining)) {
                return new int[] {numbersAndIndices.get(remaining), i};
            }
            numbersAndIndices.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

}
