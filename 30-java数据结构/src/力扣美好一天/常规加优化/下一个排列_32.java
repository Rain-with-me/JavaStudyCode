package 力扣美好一天.常规加优化;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: 雨同我
 * @Description:    从后往前找一个降序的(i,j)，然后从后往前找一个比i-1大的数进行交换，(i,j)
 * 序列进行升序即可,记得相同也要往前走
 * @DateTime: 2022/7/20 21:00
 **/
public class 下一个排列_32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums={1,5,1};
        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums) {
       int len=nums.length;
       int i=len-2;
       while (i>=0&&nums[i]>=nums[i+1]){
           i--;
       }
       if (i>=0){
            int j=len-1;
            while (j>=0&&nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
       }
       reverse(nums,i);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start) {
        int left=start+1;
        int right=nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
