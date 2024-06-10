package 力扣美好一天.动态规划;

import java.util.Scanner;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/12/20 20:11
 **/
public class 解码问题_91 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(numDecodings("10"));
    }
    public static int numDecodings(String s) {
        s="0"+s;
        int len=s.length();
        int[] dp=new int[len+1];
        dp[0]=1;
        for(int i=1;i<len;i++){
            int x=s.charAt(i)-'0';
            int y=(s.charAt(i-1)-'0')*10+s.charAt(i)-'0';
            if(x>=1&&x<=9)
                dp[i]=dp[i-1];
            if(y>=10&&y<=26)
                dp[i]=dp[i-2];
            if((x>=1&&x<=9)&(y>=10&&y<=26))
                dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[len];
    }
}
