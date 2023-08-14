package com.liquor.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 打开转盘锁
 * https://leetcode-cn.com/problems/open-the-lock/
 * <p>
 * <p>
 * 使用bfs
 */
public class OpenTheLock {

    public static void main(String[] args) {

        var deadends = new String[]{"0000"};
        var target = "8888";
        System.out.println(openLock(deadends, target));

    }

    static int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dead = Stream.of(deadends).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>(dead);
        int count = 0;

        //初始密码0000
        queue.offer("0000");

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (dead.contains(cur)) {
                    continue;
                }


                if (target.equals(cur)) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(cur, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String minus = minusOne(cur, j);
                    if (!visited.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            count++;
        }


        return -1;
    }


    /**
     * 向上拨动一次
     */
    static String plusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    /**
     * 向下拨动一次
     */
    static String minusOne(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

}
