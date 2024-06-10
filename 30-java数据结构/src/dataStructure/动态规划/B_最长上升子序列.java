package dataStructure.动态规划;

public class B_最长上升子序列 {
    public static void main(String[] args) {
        int[] a={1,5,3,4,7};
        System.out.println(dfs(a));
    }

    private static int dfs(int[] a) {
        int n=a.length;
        int[] dp=new int[n];
        for (int i=0;i<n;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (a[i]>a[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
}
