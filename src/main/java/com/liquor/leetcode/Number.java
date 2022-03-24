package com.liquor.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 6, 3, 5, 5, 4, 7, 8, 9};

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (map.size() == 0) {
                map.put(current, i);
            }
            int target = 10 - current;
            if (map.containsKey(target)) {
                result.add(Arrays.asList(current, target));
                map.remove(target);
            } else {
                map.put(current, i);
            }
        }
        System.out.println(result);
    }

}
