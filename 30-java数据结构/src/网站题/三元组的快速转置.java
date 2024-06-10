package 网站题;

import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/5/7 9:32
 */
public class 三元组的快速转置 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] a=new int[n][m];
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j]=scanner.nextInt();
                if (a[i][j]>0){
                    count++;
                }
            }
        }

        System.out.println(m+" "+n+" "+count);
//        按照列输出，不用排序
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j][i]>0){
                    System.out.println((i+1)+" "+(j+1)+" "+a[j][i]);
                }
            }
        }
    }
}
