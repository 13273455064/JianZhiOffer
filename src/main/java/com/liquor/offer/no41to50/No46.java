package com.liquor.offer.no41to50;


/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 题目的意思就是翻转单词的顺序
 * 我最先想到的是利用一个栈，先入栈，再出栈，不就自然而然的翻转了，但是空间复杂度为O(n)，但是我特么做完才发现看错了题
 * 人家让翻转的是单词，我给整个字符串全翻转了，审题很重要哇。
 *
 * 后来我想了想，这道题的精髓其实就两步，一是翻转，二是找空格
 * 我上面的操作，只要再找空格，然后对每个单词翻转回来，就能完成
 *
 * 最简单的操作就是使用spilt切成字符串数组，然后从后面向前遍历，顺便加到StringBuffer里面就好了，
 * 但是如果面试时要求空间复杂度，不让使用字符串数组的话，只能使用两个指针，从原字符串左右两边遍历，
 * 然后再对每一个单词进行同样的操作，根据遇到的是不是空格区分是不是单词
 *
 * @author zzc on 2020.1.12
 */
public class No46 {

    public static String ReverseSentence(String str) {
        if(str == null){ return null;}
        if(str.trim().equals("")){
            return str;
        }
        String[] arr = str.split(" ");
        /*int left = 0;
        int right = arr.length-1;
        StringBuilder sb = new StringBuilder();
        while (left<right){
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }*/
        StringBuilder sb = new StringBuilder();
        for (int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
            if (i!=0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am a student."));
    }
}
