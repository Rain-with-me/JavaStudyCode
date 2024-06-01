package 网站题;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("all")
public class 最短路 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String s=scanner.next();
        int[][] a=new int[s.length()][s.length()];
        int len=s.length();
        int max=Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                a[i][j]=scanner.nextInt();
                if (a[i][j]==0){
                    a[i][j]=max;
                }
            }
        }
        char start=scanner.next().charAt(0);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (a[i][k]<max&&a[j][i]<max){
                        a[j][k]=Math.min(a[j][k],a[i][k]+a[j][i]);
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (s.indexOf(start)!=i)
            System.out.println(a[s.indexOf(start)][i]);
        }
    }
}