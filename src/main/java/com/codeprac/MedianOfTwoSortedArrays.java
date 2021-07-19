package com.codeprac;

import java.util.function.Function;

import static java.util.Arrays.stream;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] merge = merge(arr1, arr2);
        return median(merge);
    }

    public double findMedianSortedArrays_alternate(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        double mid = (double)size / 2;
        int[] merged = new int[size];

        int i = 0, j = 0, k = 0;
        while (k <= mid) {
            if (i == m) {
                while(k <=mid ) merged[k++] = nums2[j++];
                break;
            }
            if (j == n) {
                while(k <=mid ) merged[k++] = nums1[i++];
                break;
            }

            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        Function<Double, Integer> getAsIntAndMerge = (num) -> merged[num.intValue()];
        int floor = getAsIntAndMerge.apply(Math.floor(mid));
        int ceil = getAsIntAndMerge.apply(Math.ceil(mid - 1));
        return ((double)ceil + floor) / 2;
    }


    private double median(int[] merged) {
        int length = merged.length;
        double mid = (double)length / 2;
        Function<Double, Integer> getAsIntAndMerge = (m) -> merged[m.intValue()];
        int floor = getAsIntAndMerge.apply(Math.floor(mid));
        int ceil = getAsIntAndMerge.apply(Math.ceil(mid - 1));
        return ((double)ceil + floor) / 2;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        int[] merged = new int[size];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        while(i < m) merged[k++] = nums1[i++];

        while(j < n) merged[k++] = nums2[j++];

        return merged;
    }
}
