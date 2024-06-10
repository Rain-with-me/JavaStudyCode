package 力扣美好一天.常规加优化;

import java.util.*;

public class 全排列_46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> list=new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        dfs(0,n,temp,list);
        return list;
    }

    private static void dfs(int count, int n, ArrayList<Integer> temp, List<List<Integer>> list) {
        if (count==n){
            list.add(new ArrayList<>(temp));
        }
        for (int i = count; i < n; i++) {
            Collections.swap(temp,count,i);
            dfs(count+1,n,temp,list);
            Collections.swap(temp,i,count);
        }
    }

}
