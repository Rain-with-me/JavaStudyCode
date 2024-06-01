package 网站题;

import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/5/5 21:47
 */
public class 希尔排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        int m=scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int t=scanner.nextInt();
            a=shellSort(a,t);
            print(a);
        }

    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i!=a.length-1){
                System.out.print(a[i]+" ");
            }else {
                System.out.println(a[i]);
            }
        }
    }


    // 第一次的for的i++
    private static int[] shellSort(int[] a, int step) {
        for (int i = step; i < a.length; i++) {
            if (a[i-step]>a[i]){
                int t=a[i];
                int j=0;
                for (j = i-step; j >=0&&t<a[j]; j=j-step) {
                    a[j+step]=a[j];
                }
                a[j+step]=t;
            }
        }
        return a;
    }
}
