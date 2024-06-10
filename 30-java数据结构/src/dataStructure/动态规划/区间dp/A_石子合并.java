package dataStructure.动态规划.区间dp;

import java.util.Scanner;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/12/15 19:30
 **/
public class A_石子合并 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
//        前缀和
        int[] sum=new int[n+1];
        int[][] f=new int[n+1][n+1];
        int[][] fi=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            sum[i]=scanner.nextInt();
            sum[i]+=sum[i-1];
        }
        for (int len=2;len<=n;len++){ // 区间长度
            for (int i=1;i+len-1<=n;i++){ // 枚举起点
                int j=i+len-1;        // 区间终点
                f[i][j]=Integer.MAX_VALUE;
                fi[i][j]=0;
                for (int k=i;k<j;k++){  // 枚举分割点，构造状态转移方程
                    f[i][j]=Math.min(f[i][j],f[i][k]+f[k+1][j]+sum[j]-sum[i-1]);
                    fi[i][j]=Math.max(fi[i][j],fi[i][k]+fi[k+1][j]+sum[j]-sum[i-1]);
                }
            }
        }
        System.out.println(f[1][n]);
        System.out.println(fi[1][n]);
    }
}
//4
//1 3 5 2