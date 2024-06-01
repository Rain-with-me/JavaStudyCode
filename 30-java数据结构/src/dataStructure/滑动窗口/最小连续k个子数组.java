package dataStructure.滑动窗口;

/**
 * @Author: 雨同我
 * @Description:
 *
 *
 *
 *
 *
 * @DateTime: 2023/11/17 9:59
 **/
public class 最小连续k个子数组 {
    public static void main(String[] args) {
        int i = minContinuousSubarray(new int[]{100, 200, 300, 400}, 2);
    }
    public static int minContinuousSubarray(int[] nums,int k){
//        思路： 维护一个k大小的窗口，新窗口=旧窗口+nums[i]-nums[i-k]
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        int minSum=sum;
        for (int i = k; i < nums.length; i++) {
            sum=sum+nums[i]-nums[i-k];
            minSum=Math.max(sum,minSum);
        }
        System.out.println(minSum);
        return minSum;
    }
}
