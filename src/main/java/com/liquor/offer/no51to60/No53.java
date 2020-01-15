package com.liquor.offer.no51to60;

/**
 * 构建乘积数组：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * 如果可以使用除法，那这个题应该很简单，就是先计算出A[0]乘到A[n-1]的乘积
 * 然后对于每个B[i],都除以A[i],需要注意除数不能为0
 *
 * 但是这个题不让用除法，于是只能仔细观察 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1] 这个式子。一开始我还看不懂，还在想这不是跟 A[0]乘到A[n-1] 一样吗
 * 后来我看到它没有A[i],比较显然，可以把 B[i]的值分成两部分，分别是 A[0]*A[1]*...*A[i-1] 和    A[i+1]*...*A[n-1]
 * 对于第一部分，我们可以保存每次乘积之后的值，对于第二部分，只要倒着遍历，然后保存每次乘积之后的值即可
 *
 *
 * @author T480
 */
public class No53 {
    public int[] multiply(int[] A) {
        if (A==null || A.length==0){
            return new int[0];
        }
        int n = A.length;
        int[] B = new int[n];
        int[] BRight = new int[n];
        B[0] = A[0];
        //先把左半部分乘进去
        for (int i=1;i<n;i++){
            B[i] = B[i-1] * A[i-1];
        }
        return null;
    }
}
