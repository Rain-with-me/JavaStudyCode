package 力扣美好一天.动态规划;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/27 16:25
 */

import java.util.Arrays;
import java.util.Scanner;

public class 最长递增子序列_300 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] nums={1,3,6,7,9,4,10,5,6};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    /**
       * @description:  思路分析:
     *                         本来想直接用dp[n-1]收缩到
     *                         但是他前面就最大值，后面小的就收缩不到，使用直接用一个变量去
     *                         存最大值就好了
       *  * @param nums
       * @return: int
       * @author: 鲁子哥的每一天
       * @time: 2022/3/27 16:26
     */

    public static int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int res=0;
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
