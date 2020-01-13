package com.liquor.offer.no41to50;

import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * 记得以前玩过赖子斗地主吗，大小王可以代替当做任何数字。这题一开始我是看不到啥意思的，而且第一行的题干就把人迷惑了，
 * 2个大王,2个小王(一副牌原本是54张^_^)，那特么的这副牌到底是54还是变成了56，我觉得这是出题人故意的，让我们把思考的重点都放在这里，但是LZ不吃这一套
 *
 * 其实就是给你一个数组，数组里面的0可以当做任何数字，然后看这个数组里面的数字是不是连续的，这样是不是就很直观了，还搞什么抽象建模能力
 *
 *
 *
 * @author zzc on 2020.1.13
 */
public class No47 {

    public boolean isContinuous(int [] numbers) {
        if(numbers.length<=0){
            return false;
        }
        //第一步：先排序
        Arrays.sort(numbers);
        //遍历一波，找有几个大小王(0的个数)
        int zero = 0;
        for (int n:numbers){
            if (n==0){
                zero++;
            }
        }
        //再遍历一波，找所有数字之间的差值，如果dif==zero,说明是顺子，如果dif>zero，说明不是顺子，如果dif<zero，那应该也是顺子
        //需要注意的是，得看是否有相等的数字，如果有相等的，那肯定不是顺子
        int dif = 0;
        //从第一个非0处开始遍历
        int small = zero;
        int big = zero+1;
        while (big<numbers.length){
            if (numbers[small]==numbers[big]){
                return false;
            }
            //注意这里要-1,因为相邻数字相差1是正常递增的情况，需要排除掉
            dif+=numbers[big]-numbers[small]-1;
            small++;
            big++;
        }
        return dif <= zero;
    }
}
