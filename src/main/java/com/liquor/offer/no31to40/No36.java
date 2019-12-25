package com.liquor.offer.no31to40;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 搞懂完题目，我的脑海中涌现出一个笨方法，先从头到尾遍历字符，然后对每一个字符寻找字符串中还有没有相同的字符，时间复杂度O(n2),空间复杂度O(1)
 *
 * 后面想到可以优化时间复杂度，即遍历一次字符，使用一个hasnmap保存每个字符出现的次数，然后遍历hashmap，找第一个次数为1的，但是这样不行，因为hashmap是无序的
 * 那么我们遍历出来的不一定就是原字符串中的位置，因此必须用一个能保证读取顺序和插入顺序相同的容器
 *
 * 那么可以使用List,在遍历字符数组的过程中，把每一个字符的ascll作为下标对应的数字 +1 ,这样，再次遍历字符数组，每一个字符都看看ascll码对应数字是不是1，
 * 知道找到一个是1的
 *
 * @author zzc on 19.12.25
 */
public class No36 {

    public static int FirstNotRepeatingChar(String str) {
        if (str==null || str.length()==0){return -1;}
        if (str.length() == 1){return 0;}
        //这里用int[]代替List,需要考虑数组的大小
        //这里的58是因为在ASCll码中，A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122
        //题目说了只有字母，那数组最小是不是  26+26=52个就可以了呢，还应该注意到大小写字母之间不是相连的，
        //没有办法，只能把数组的大小定为  26+26+6 = 58,
        int[] arr = new int[58];

        for (int i = 0;i<str.length();i++){
            int index = str.charAt(i)-65;
            arr[index]++;
        }
        for (int i = 0;i<str.length();i++){
            int index = str.charAt(i)-65;
            if (arr[index]==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }

    /**
     * 两层循环的笨方法，只是有一点点优化
     * ac牛客
     */
    public static int FirstNotRepeatingChar1(String str) {
        int result = -1;
        if (str==null || str.length()==0){return -1;}
        if (str.length() == 1){return 0;}
        char[] chars = str.toCharArray();
        for (int i = 0;i<chars.length;i++){
            for (int j = 0;j<chars.length;j++){
                //跳过自己
                if (j == i){continue;}
                if (chars[j] == chars[i]) {
                    //如果出现了一样的，说明i这个位置的字符肯定不是只出现一次（好像废话一样）
                    break;
                }
                //当遍历到了最后一个了还是没有找到相同的字符，说明找到了第一个只出现一次的字符（好像也是废话）
                if (j == chars.length-1){
                    result = i;
                    return result;
                }
            }
        }
        return result;
    }
}
