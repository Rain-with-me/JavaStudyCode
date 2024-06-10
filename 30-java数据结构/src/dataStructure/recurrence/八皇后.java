package dataStructure.recurrence;

import java.util.Scanner;


/*
*   LogManager 八皇后问题
*   @author 从网上扒的
*   @version 2022/1/17
*
*/

public class 八皇后 {
    static int count=8,ans=1;
    static int[][] map=new int[count][count];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(0);
    }

    private static void run(int row) {
        for (int i=0;i<count;i++){
            if (check(row,i)){
                map[row][i]=1;
                if (row==7){
                    show(ans);
                    ans++;
                }else {
                    run(row+1);
                }
            }
            map[row][i]=0;
        }
    }


    private static void show(int ans) {
        System.out.println("这是第"+ans+"种");
        for (int i=0;i<count;i++){
            for (int j=0;j<count;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean check(int row, int col) {
        /*
        * 需要判断他上面是否还有，因为他是每列只有一个，有一个直接跳到第二列，所以不需要检查他的右边
        * */

        for (int i=row-1;i>=0;i--){
            if (map[i][col]==1){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (map[i][j]==1){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0&&j<count;i--,j++){
            if (map[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
