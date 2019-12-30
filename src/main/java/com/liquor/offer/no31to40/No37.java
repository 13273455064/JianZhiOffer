package com.liquor.offer.no31to40;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 	示例：   输入 1,2,3,4,5,6,7,0    输出： 7
 *
 *  这个题需要对归并排序非常熟悉，顺便复习一波归并排序
 *
 * @author zzc on 19.12.26
 */
public class No37 {

    public static int InversePairs(int [] array) {
        if (array.length == 0){
            return 0;
        }
        return merge(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] arrays = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,
                650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,
                144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,
                936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,
                259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,
                45,848,38,811,267,575};
        //mergeSort(arrays, 0, arrays.length - 1);
        int a =  InversePairs(arrays);
        System.out.println("逆序对个数：" +a);
    }

    /**
     * 归并排序
     * @param arrays 待排序数组
     * @param low 左侧边界
     * @param high 右侧边界
     */
    private static void mergeSort(int[] arrays, int low, int high) {
        int mid = (low + high)>>1;
        if (low < high){
            //不断递归地处理左边
            mergeSort(arrays,low,mid);
            //不断递归地处理右边
            mergeSort(arrays,mid+1,high);
            //合并
            merge(arrays,low,high);
        }
    }

    /**
     * 合并两个有序的数组为一个有序的数组
     * @param arrays 待排序数组
     * @param low 左边界
     * @param high 右边界
     */
    private static int merge(int[] arrays, int low,int high) {

        if (low==high){
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = merge(arrays,low,mid)%1000000007;
        int rightCount = merge(arrays,mid+1,high)%1000000007;

        //逆序对的数量
        int count = 0;
        //临时数组
        int[] temp = new int[high-low+1];
        int i = mid;
        int j = high;
        //临时数组指针
        int k = high-low;
        //当左右指针都没有指向子数组最后一个数字之前
        while (i>=low && j>=mid+1){
            //如果左边指针的数比右边小
            if (arrays[i] < arrays[j]){
                //把左边指针的数放到临时数组，并且左边指针右移
                temp[k--] = arrays[j--];
            }else {
                //!!一定特别注意先计算逆序对个数再挪动指针
                count += j-mid;
                //如果左边指针的数比右边大，把右边指针的数放到临时数组，并且右边指针右移
                temp[k--] = arrays[i--];
                //数值过大求余
                if(count>=1000000007)
                {
                    count%=1000000007;
                }
            }
        }
        //如果右边的遍历完了，左边还没完事
        while (i>=low){
            temp[k--] = arrays[i--];
        }
        //如果左边的遍历完了，右边还没完事
        while (j>=mid+1){
            temp[k--] = arrays[j--];
        }
        //最后把临时数组的数复制回待排序数组
        for (int a = 0;a < temp.length;a++){
            arrays[a+low] = temp[a];
        }
        return (count + leftCount + rightCount)%1000000007;
    }
}
