package 力扣美好一天.常规加优化;

/**
 * @Author: 雨同我
 * @Description:    刚开始是使用辅助数组，但是直接旋转，有点智商不在线
 * @DateTime: 2022/9/25 16:37
 **/
import java.util.*;

public class 旋转图像_48 {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        dfs(matrix);
    }

    private static void dfs(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for (int j = 0; j < n; j++) {
                int t=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=t;
            }
        }
        dfs(matrix);
        System.out.println();
        for(int i=0;i<n;i++){
            for (int j = 0; j < i; j++) {
                System.out.println(matrix[i][j]+"---"+matrix[j][n-i-1]);
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }
}
