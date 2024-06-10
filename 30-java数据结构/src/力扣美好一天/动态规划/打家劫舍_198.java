package 力扣美好一天.动态规划;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/20 10:05
 */
public class 打家劫舍_198 {
    public static void main(String[] args) {
        /**
           * @description:  方法2： 滚动数组，不使用数组
           *  * @param args
           * @return: void
           * @author: 鲁子哥的每一天
           * @time: 2022/3/20 10:21
         */
        int[] nums={1,2,3,9};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
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
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
}
