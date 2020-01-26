package com.liquor.offer.no41to50;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 题目的意思就是翻转字符串
 * 我最先想到的是利用一个栈，先入栈，再出栈，不就自然而然的翻转了，但是空间复杂度为O(n)，但是我特么做完才发现看错了题
 * 人家让翻转的是单词，我给整个字符串全翻转了，审题很重要哇。
 *
 * 后来我想了想，这道题的精髓其实就两步，一是翻转，二是找空格
 * 我上面的操作，只要再找空格，然后对每个单词翻转回来，就能完成
 *
 */
public class No46 {

    public static String ReverseSentence(String str) {
        if (str==null || str.equals("")){
            return "";
        }
        String[] arr = str.split(" ");

        return null;
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am a student."));
    }
}
