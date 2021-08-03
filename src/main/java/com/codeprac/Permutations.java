package com.codeprac;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        permutationWithHeapAlgorithm(nums, nums.length, result);
        return new ArrayList<>(result);
    }

    private void permutationHelper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            var permutationItem = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(permutationItem);
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permutationHelper(nums, i + 1, result);
            swap(nums, i, j);
        }
    }


    private void permutationWithHeapAlgorithm(int[] nums, int n, Set<List<Integer>> result) {
        if (n == 1) {
            var permutationItem = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(permutationItem);
        } else {
            permutationWithHeapAlgorithm(nums, n - 1, result);
            for (int i = 0; i < n - 1; i++) {
                if (n % 2 == 0) {
                    swap(nums, i, n - 1);
                } else {
                    swap(nums, 0, n - 1);
                }
                permutationWithHeapAlgorithm(nums, n - 1, result);
            }
        }


    }

    private void swap(int[] nums, int i, int j) {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
