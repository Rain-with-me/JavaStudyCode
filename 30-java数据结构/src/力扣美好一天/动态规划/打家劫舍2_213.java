package 力扣美好一天.动态规划;

import java.util.Arrays;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/20 10:35
 */
public class 打家劫舍2_213 {
    public static void main(String[] args) {
        /**
           * @description: 太难了啊，兄弟们，就差一点点了！！！！
         *                 正确答案就不在这里写了
           *  * @param args
           * @return: void
           * @author: 鲁子哥的每一天
           * @time: 2022/3/20 10:39
         */

        int[] nums={1,2,3,1};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int n=nums.length;
        if (n==0){
            return 0;
        }
        if (n==1){
            return nums[0];
        }
        if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] a=new int[n-1];
        if (nums[0]>=nums[n-1]) {
            a=Arrays.copyOfRange(nums, 0, n - 1);
        }else {
            a= Arrays.copyOfRange(nums, 1, n);
        }
        int[] dp=new int[n];
        dp[0]=a[0];
        dp[1]=Math.max(a[0],a[1]);
        for (int i = 2; i < n-1; i++) {
            dp[i]=Math.max(dp[i-2]+a[i],dp[i-1]);
        }
        return dp[n-2];
    }
}
