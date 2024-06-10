package 力扣美好一天.二分法;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/4/25 10:00
 **/
public class A_入门 {

    public static void main(String[] args) {
//        System.out.println(dich(9, new int[]{2, 7, 11, 15}, 4));
        System.out.println(left_bound(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
    static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            dich(target-nums[i],nums,nums.length);
        }
        return new int[]{0,1};
    }

    static boolean dich(int t,int[] nums,int len){
        int l=0,r=len-1;
        while(l<r){
            int mid=(r-l)/2+l;
            if(nums[mid]<t){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        System.out.println(nums[l]+"   "+nums[r]);
        return nums[l]==t;
    }

}
