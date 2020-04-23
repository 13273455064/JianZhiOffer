package com.liquor.bishi;

public class FindEnglish {


    public static void main(String[] args) {
        String s = "Today, when I went home after school,\n" +
                "my bike was broken suddenly,\n" +
                "then I found there were no friends around.\n";
        int count = 0;
        //先把英文文章根据换行符分割成字符串数组
        String[] lines = s.split("[\\n\\r]");
        for (String line:lines){
            count+=countByLine(line);
        }
        System.out.println(count);

    }

    public static int countByLine(String ling){
        int count = 0;
        for (char c: ling.toCharArray()){
            if (c==' '){
                count++;
            }
        }
        //空格的数量+1就是单词的数量
        return count+1;
    }


}
