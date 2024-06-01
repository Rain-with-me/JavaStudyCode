package 力扣美好一天.搜索;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:  题目号   200
 * @author: HaHa
 * @time: 2022/3/24 9:05
 */

public class 岛屿的数量 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        char[][] grid={{'1','1','1','0'},
                      {'1','0','1','0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int sum=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]=='1'){
                    sum++;
                    dfs(i,j,grid);
                }
            }
        }
        return sum;
    }

    private static void dfs(int i, int j, char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if (i<0||j<0||i>=n||j>=m||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
    }
}

class Solution {

    int n,m;
    boolean[][] flag;
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int sum=0;
        flag=new boolean[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                // 注意点，flag
                if (!flag[i][j]&&grid[i][j]=='1'){
                    sum++;
                    bfs(i, j,grid);
                }
            }
        }
        return sum;
    }
    public void bfs(int i,int j,char[][] grid){
        Queue<int[]> queue=new LinkedList();
        queue.offer(new int[]{i,j});
        flag[i][j]=true;
        int[][] next={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] t=queue.poll();
            for(int k=0;k<4;k++){
                // 注意点
                int tx=t[0]+next[k][0];
                int ty=t[1]+next[k][1];
                if(tx>=0&&ty>=0&&tx<n&&ty<m&&grid[tx][ty]=='1'&&!flag[tx][ty]){
                    queue.offer(new int[]{tx,ty});
                    flag[tx][ty]=true;
                }
            }
        }
    }

}