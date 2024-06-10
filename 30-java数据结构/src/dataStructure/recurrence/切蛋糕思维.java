package dataStructure.recurrence;

public class 切蛋糕思维 {
    public static void main(String[] args) {
//        数组递归
        int x = dfs(new int[]{1, 2, 3, 4, 5}, 0);
        System.out.println(x);
    }
    static int dfs(int[] a,int begin){
        if (begin==a.length-1){
            return a[a.length-1];
        }
        return a[begin]+dfs(a,begin+1);
    }
}
