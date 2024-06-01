package 力扣美好一天.动态规划;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/4/4 17:43
 */
public class 不同路径2_63 {
    static int sum=0,n,m;
    public static void main(String[] args) {
        int[][] a={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));
        System.out.println(sum);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n=obstacleGrid.length;
        m=obstacleGrid[0].length;
        dfs(1,1,obstacleGrid);
        return sum;
    }

    private static void dfs(int i, int j, int[][] obstacleGrid) {
        if(i>n||j>m||obstacleGrid[i][j]==1){
            return;
        }
        if(i==n&&j==m){
            sum++;
        }
        obstacleGrid[i][j]=1;
        dfs(i+1,j,obstacleGrid);
        dfs(i,j+1,obstacleGrid);
    }
}

