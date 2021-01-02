package com.liquor.jianzhioffer.no61to68;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 我贼纳闷他为什么非得用一个一位数组来表示二维数组，为什么不能直接用二位数组来表示呢？
 * 这个题就是传说中的回溯法，先找到第一个字符，然后向上下左右四个方向继续寻找，
 * 由于不能重复进入，所以需要一个布尔数组来表示走过的路径，
 * 由于参数str是一个字符数组，还需要一个索引变量来表示到了哪个字符
 * @author zzc on 2020.2.3
 *
 */
public class No66 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length==0 || str.length==0){
            return false;
        }
        boolean[] visit = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix,str,rows,cols,i,j,visit,0)){
                    return true;
                }
            }

        }
        return false;
    }

    private boolean judge(char[] matrix, char[] str, int rows, int cols, int row, int col, boolean[] visit, int path) {
        //用一位数组来表示二维数组，当前坐标就得这么表示
        int index = row * cols +col;
        if (row<0 || col<0 || row>=rows || col>=cols || matrix[index]!=str[path] || visit[index] == true){
            return false;
        }
        if (path == str.length-1){
            return true;
        }
        //每走一步，就把布尔矩阵对应的坐标标为true
        visit[index] = true;
        //向上下左右四个方向探索
        if (judge(matrix,str,rows,cols,row-1,col,visit,path+1)
            || judge(matrix,str,rows,cols,row+1,col,visit,path+1)
            || judge(matrix,str,rows,cols,row,col+1,visit,path+1)
            || judge(matrix,str,rows,cols,row,col-1,visit,path+1))
        {
            //只要由一条路走通，就说明存在路径
            return true;
        }

        //上下左右四个方向都走不通，需要回退了
        visit[index] = false;
        return false;
    }
}
