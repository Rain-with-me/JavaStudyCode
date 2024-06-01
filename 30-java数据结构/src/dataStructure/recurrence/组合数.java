package dataStructure.recurrence;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 雨同我
 * @Description:   1+2+3=6
 * @DateTime: 2024/4/15 11:31
 **/
public class 组合数 {
    static List res=new ArrayList<Integer>();
    public static void main(String[] args) {

        int I = 3;
        int target = 7;
        int[] nums=new int[]{2,3,6,7};

//        不可重复的
        assemblySum1(nums,target,0,new ArrayList());
        assemblySum2(nums,target,0,new ArrayList());
    }
    private static void assemblySum1(int[] nums, int target, int index, ArrayList list) {
        if (target==0){
            System.out.println(list);
            res.add(new ArrayList<>(list));
            System.out.println(list);
            return;
        }
        for (int i=index;i<nums.length;i++){
            if (nums[i]>target){
                return;
            }
            list.add(nums[i]);
            assemblySum1(nums,target-nums[i],i,list);
            list.remove(list.size()-1);
        }
    }
    private static void assemblySum2(int[] nums, int target, int index, ArrayList list) {
        if (target==0){
            System.out.println(list);
            res.add(new ArrayList<>(list));
            System.out.println(list);
            return;
        }
        for (int i=index;i<nums.length;i++){
            if (nums[i]>target){
                return;
            }
            list.add(nums[i]);
            assemblySum2(nums,target-nums[i],i,list);
            list.remove(list.size()-1);
        }
    }
}
