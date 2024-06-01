package 力扣美好一天.动态规划;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/21 9:16
 */
public class 背包问题优化 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int[] weight={1,3,1};
        int[] value={15,30,20};
        int n=4;
        dfs(n,weight,value);
    }

    /**
       * @description:   优化的状态转移方程：
     *                      dp[i]=max(新的加上weight，旧的dp[i])
     *                          注意点：
     *                              他的存放必须从后往前，因为，如果从前往后的话，
     *                              前面的值会被后面更新所覆盖，想要用就拿不到了。
     *
       *  * @param n
       * @param weight
       * @param value
       * @return: int
       * @author: 鲁子哥的每一天
       * @time: 2022/3/21 9:19
     */
    private static int dfs(int n, int[] weight, int[] value) {
        int[] dp=new int[n+1];
        int m=weight.length;
        for (int i = 0; i < m; i++) {
            for (int j = n; j>=1; j--) {
                int tempNew=0;
                if (weight[i]<=j){
                    tempNew=dp[j-weight[i]]+value[i];
                }
                int tempOld=dp[j];
                dp[j]=Math.max(tempOld,tempNew);
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }
}
