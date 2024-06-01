package dataStructure.动态规划;

import java.io.BufferedInputStream;
import java.util.Scanner;


// 题目：

/**
 * 4 5 (物品数量，背包容量)
 * 1 2 (i件体积[volume]和价值[worth])
 * 2 4
 * 3 4
 * 4 5
 * 8
*/
/**
 * 思路：
 * 1. 选i物品  dp[i][j]=dp[i-1][j-v[i]]
 * 2. 不选i物品  dp[i][j]=dp[i-1][j]
 * max(1,2)
*/

@SuppressWarnings("all")
public class A_01背包问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n=scanner.nextInt();
        int m=scanner.nextInt();
//        防止下面的数组越界
        int[] v=new int[n+1];
        int[] w=new int[n+1];
        int[][] dp=new int[n+1][m+1];
        for (int i = 1; i <=n; i++) {
            v[i]=scanner.nextInt();   //质量
            w[i]=scanner.nextInt();   //价值
        }

        for (int i = 1; i <= n; i++) {
            for (int j=m;j>=1;j--){
                if (j>=v[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}

/**
 * 为什么要逆序：  [参考](https://www.acwing.com/solution/content/116859/)
 当我们从小到大更新是， 因为j - v[i] 是严格小于j 的，
 所以我们可以举个例子 dp[3] = max(dp[3], dp[2] + 1);
 因为我们是从小到大更新的，所以当更新到dp[3]的时候，dp[2]已经更新过了，已经不是上一层的dp[2]。
 而当我们逆序更新时有，举例 dp[8] = max(dp[8], dp[6] + 2)当更新dp[8]时，
 dp[6]还没有被更新，还是上一层的数据，这样才能保证没有读入脏数据。
*/

/**
 *
 *     public int maxValue(int[] weight, int[] value, int W) {
 *         int n = weight.length;
 *         if (n == 0) return 0;
 *         // 辅助空间只需要O(W)即可
 *         int[] dp = new int[W + 1];
 *         for (int i = 0; i < n; i++) {
 *           // 注意这里必须从后向前！！！
 *             for (int k = W; k >= 1; k--) {
 *                 int valueWith_i = (k - weight[i] >= 0) ? (dp[k - weight[i]] + value[i]) : 0;
 *                 int valueWithout_i = dp[k];
 *                 dp[k] = Math.max(valueWith_i, valueWithout_i);
 *             }
 *         }
 *         return dp[W];
 *     }
 *
 *
   * @return:
   * @author: 鲁子哥的每一天
   * @time: 2022/4/2 17:29
 */