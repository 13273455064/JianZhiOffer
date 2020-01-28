package com.liquor.offer.no51to60;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 看题我还以为是遍历大法就完事，然后看到字符流，没有保存下来，只能一个一个字符地读，因此本题的精髓在于使用一个容器把读出来的字符保存下来，
 * 说实话我看见两个方法也是懵逼的
 * 书上说，要想高效的解决问题，需要往容器里插入字符和更新字符的值的时间复杂度为O(1)
 * 我感觉得用hash表，但是这样空间耗费太大，牛客上面说用数组可以
 * 需要考虑到hash表或者数组的初始长度取多少，为此需要知道一个知识点  所有的字符总数为256
 *
 *
 * @author zzc on 2020.1.27
 */
public class No56 {
    /**
     * 使用LinkedHashMap的解法，借用了LinkedHashMap有序的特性
     */
    Map<Character,Integer> map = new LinkedHashMap<>(256);
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (char ch : map.keySet()){
            if (map.get(ch)==1){
                return ch;
            }
        }
        return '#';
    }


}
