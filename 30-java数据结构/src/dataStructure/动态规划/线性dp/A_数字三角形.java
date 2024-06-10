package dataStructure.动态规划.线性dp;

import java.util.Scanner;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/12/12 21:47
 **/
public class A_数字三角形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] dp=new int[n+1][n+1];
        int[][] nums=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
               nums[i][j]=scanner.nextInt();
            }
        }
        for (int i = n-1; i >= 0; i--) {
            dp[n-1][i]=nums[n-1][i];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j]=Math.max(dp[i+1][j]+nums[i][j],dp[i+1][j+1]+nums[i][j]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
