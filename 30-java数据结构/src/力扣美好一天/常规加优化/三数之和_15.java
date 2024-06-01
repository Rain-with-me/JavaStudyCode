package 力扣美好一天.常规加优化;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 雨同我
 * @Description:        思路：对3个for循环进行优化
 *  a=b+c ,a从左边开始，c从右边开始，然后进行比较
 * @DateTime: 2022/6/29 21:26
 **/
public class 三数之和_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        lists.forEach(o-> System.out.println(o));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int len=nums.length;
        for (int first = 0; first < len; first++) {
            if (first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int third=len-1;
            int target=-nums[first];
            for (int second = first+1; second < len; second++) {
                if (second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while (second<third&&nums[second]+nums[third]>target){
                    third--;
                }
                if (third==second){
                    break;
                }
                if (nums[third]+nums[second]==target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
