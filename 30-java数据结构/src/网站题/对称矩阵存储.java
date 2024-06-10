package 网站题;

import java.util.Scanner;

public class 对称矩阵存储 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[][] a=new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j]=scanner.nextInt();
                }
            }
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            if (x<y){
                int t=x;
                x=y;
                y=t;
            }
            int[] ch=new int[n*n];
            int in=0,index=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    ch[in++]=a[i][j];
                    if (i==(x-1)&&(y-1)==j){
                        index=in;
                    }
                }
            }
            for (int i = 0; i < in; i++) {
                if (i!=in-1) {
                    System.out.print(ch[i] + " ");
                }else {
                    System.out.println(ch[i]);
                }
            }
            System.out.println(index);
        }
    }
}
