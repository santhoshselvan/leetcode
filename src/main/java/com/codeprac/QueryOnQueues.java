package com.codeprac;

import java.util.Arrays;

public class QueryOnQueues {

    public int[] solve(int sizeOfArray, int[] array, int numberOfQueries, int[] queries) {

        return Arrays.stream(queries).map(q -> {
            int numberOfItemsSmallerThanOnLeft = findNumberOfItemsSmallerThanOnLeft(q, array);
            int numberOfItemsSmallerThanOnRight = findNumberOfItemsSmallerThanOnRight(q, array);
            return numberOfItemsSmallerThanOnLeft + numberOfItemsSmallerThanOnRight + 1;
        }).toArray();
    }

    public int findNumberOfItemsSmallerThanOnRight(int query, int[] array) {
        int counter = 0;
        for (int i = query; i < array.length; i++) {
            if (array[i] <= array[query - 1])
                counter++;
            else break;
        }
        return counter;
    }

    public int findNumberOfItemsSmallerThanOnLeft(int query, int[] array) {
        if (query == 1) return 0;
        int counter = 0;
        for (int i = query - 2; i >= 0; i--) {
            if (array[i] <= array[query - 1])
                counter++;
            else break;
        }
        return counter;
    }
}
