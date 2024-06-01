package 网站题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/5/6 10:23
 */
public class 插入排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        int m=scanner.nextInt();
        for (int i = 1; i <= m; i++) {
            if (a[i-1]>a[i]){
                int temp=a[i];
                int j=0;
                for (j = i-1;j>=0&&temp<a[j]; j--) {
                    a[j+1]=a[j];
                }
                a[j+1]=temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (i==a.length-1) {
                System.out.println(a[i]);
            }else {
                System.out.print(a[i]+" ");
            }
        }
    }
}
