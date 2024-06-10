package 力扣美好一天.动态规划;

import java.util.Arrays;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/10/23 13:17
 **/
public class 最长连续序列_128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    public static int longestConsecutive(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        Arrays.sort(nums);
        dp[0]=1;
        int max=-1;
        for (int i = 1; i < len; i++) {
            if (nums[i]==nums[i-1]+1){
                dp[i]=dp[i-1]+1;
            }else if (nums[i]==dp[i-1]){
                dp[i]=dp[i-1];
            }else {
                dp[i]=1;
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
