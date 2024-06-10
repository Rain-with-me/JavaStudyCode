package 力扣美好一天.动态规划;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/4/4 17:23
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("all")
public class 不同路径_62 {
    /**
     * @description:    优化map，
     *                   String key = i + "*" + j;
                     *   if (map.containsKey(key))
                     *   return map.get(key)
     *
     *                   map.put(key, totla);
     *  * @param null
     * @return:
     * @author: 鲁子哥的每一天
     * @time: 2022/4/4 17:36
     */
    public static void main(String[] args) throws ParseException {
        System.out.println(uniquePaths(59, 5));
        System.out.println(uniquePath(59, 5));
        System.out.println(uniquePath(1,1,59, 5));
    }

//    dp  dp[i][j]=i-1加j-1转移过来
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePath(int m, int n) {
        if(m<=0||n<=0){
            return 0;
        }
        if(m==1&&n==1){
            return 1;
        }
        int x=uniquePath(m-1,n);
        int y=uniquePath(m,n-1);
        return x+y;
    }

    public static int uniquePath(int i,int j,int m, int n) {
        if(i>m||j>n){
            return 0;
        }
        if(m==i&&n==j){
            return 1;
        }
        int x=uniquePath(i+1,j,m,n);
        int y=uniquePath(i,j+1,m,n);
        return x+y;
    }
}
