package com.liquor.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Sort {


    public static void main(String[] args) {
        String[] arr = new String[]{"a", "ab", "a","abc","frg","f","a","ab","ssj","abc"};
        num(arr);
    }

    private static void num(String[] arr) {

        Map<String, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            final String s = arr[i];
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        final Set<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted((entry1, entry2) -> {
            final int i = entry1.getValue() - entry2.getValue();
            return i > 0 ? -1 : 1;
        }).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect);

    }
}
