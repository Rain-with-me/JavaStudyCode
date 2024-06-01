package 力扣美好一天.常规加优化;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: 雨同我
 * @Description:    这么明显的二分，我没看出了，.............
 *
 * @DateTime: 2022/8/31 17:01
 **/
public class 在排序数组中查找元素的第一个和最后一个位置_34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums={5,7,7,8,8,10};
        int target=8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int j=0;
        int[] a={-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target&&j==0){
                a[0]=a[1]=i;
                j++;
            }else if (nums[i]==target){
                a[1]=i;
            }
        }
        return a;
    }

}

/**  100%代码
 * @Description: class Solution {
 *     //先找>=target的第一个
 *     //再找>target的第一个
 *     //我真是这辈子都不想看见这题
 *     public int[] searchRange(int[] nums, int target) {
 *         int l=search(nums,target);
 *         int r=search(nums,target+1);
 *         if(l==nums.length||nums[l]!=target)
 *             return new int[]{-1,-1};
 *         return new int[]{l,r-1};
 *     }
 *     //找>=target的第一个
 *     public int search(int[] nums,int target){
 *         int l=0,r=nums.length;
 *         while(l<r){
 *             int mid=(r+l)>>1;
 *             if(nums[mid]>=target)
 *                 r=mid;
 *             else
 *                 l=mid+1;
 *         }
 *         return l;
 *     }
 * }
 * @Author: 雨同我
 * @DateTime: 2022/8/31 17:22
*/