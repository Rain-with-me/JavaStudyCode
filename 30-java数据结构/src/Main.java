import java.util.*;


class Main {
    static List res=new ArrayList<Integer>();
    public static void main(String[] arge) {
        Scanner scaner = new Scanner(System.in);
        int I = 3;
        int target = 7;
        int[] nums=new int[]{2,3,6,7};
//        int[] nums = new int[I];
//        for (int i = 0; i < I; i++) {
//            nums[i] = i + 1;
//        }
        Queue<Integer> q=new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
//        deque.offer(1);
//        deque.offer(2);
//        System.out.println(deque.poll());
        deque.push(2);
        deque.push(4);
//        System.out.println(deque.pop());

//        dfs(nums, target,0,0,new ArrayList<Integer>());
//        backtrack(nums,target,0,new ArrayList<>());
        System.out.println(dfs());
//        System.out.println(res);
    }

    private static void backtrack(int[] nums, int target, int index, ArrayList list) {
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
            backtrack(nums,target-nums[i],i,list);
            list.remove(list.size()-1);
        }
    }


//    private static void backtrack(int[] nums, int target, int start, List<Integer> path) {
//        if (target == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            if (target < nums[i]) {
//                break;
//            }
//            path.add(nums[i]);
//            backtrack(nums, target - nums[i], i+1, path);
//            path.remove(path.size() - 1);
//        }
//    }


    private static int dfs() {
        int i = 0;
        try {
            i = 99;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            return 9;
        }


    }

}


