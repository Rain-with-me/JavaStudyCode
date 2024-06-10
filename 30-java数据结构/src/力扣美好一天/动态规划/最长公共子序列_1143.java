package 力扣美好一天.动态规划;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/28 9:57
 */
import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class 最长公共子序列_1143 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String s="abcde";
        String ss="d";
        System.out.println(longestCommonSubsequence(s, ss));
    }

    /**
       * @description:   本来想通过一个一个的去查找的，但是会存在先后顺序的问题，这样就找不到
     *                      最大的值了，最后想了想，还是不可以，干脆直接使用dp算了，
     *                      但是就是不会啊！不是我不想啊。。。。。。。。。
     *
       *  * @param null
       * @return:
       * @author: 鲁子哥的每一天
       * @time: 2022/3/28 9:58
     */


    public static int longestCommonSubsequence(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=0;
        for (int i = 1; i <= n; i++) {
            char a=s1.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char b=s2.charAt(j-1);
                if (a!=b){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]);
                }else{
                    dp[i][j]=dp[i-1][j-1]+1;
                }
            }
        }
        return dp[n][m];
    }


//    public static int longestCommonSubsequence(String s1, String s2) {
//        int sum=0;
//        if(s1.length()>s2.length()){
//            int n=s2.length();
//            int index=0;
//            for (int i = 0; i < n; i++) {
//                char t=s2.charAt(i);
//                index=s1.indexOf(t,index);
//                if (index!=-1){
//                    sum++;
//                }else {
//                    break;
//                }
//            }
//        }else{
//            int n=s1.length();
//            int index=0;
//            for (int i = 0; i < n; i++) {
//                char t=s1.charAt(i);
//                index=s2.indexOf(t,index);
//                if (index!=-1){
//                    sum++;
//                }else{
//                    break;
//                }
//            }
//        }
//        return sum;
//    }
}