package dataStructure.algorithm;

import java.util.Scanner;

public class 最短路径 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] path=new int[1000][1000];
        while (m-->0){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            path[a][b]=path[b][a]=c;
        }

        for (int i=1;i<=n;i++){
            for (int j = 0; j<=n; j++) {
                for (int k = 0; k <=n; k++) {
//  判断如果 ik距离可达且 kj距离可达 且 i和j的距离是否大于 i-> k 与 k->j的距离和
                    if (path[j][i]<Integer.MAX_VALUE&&path[i][k]<Integer.MAX_VALUE&&path[j][k]>(path[j][i]+path[i][k])){
                        path[j][k]=Math.min(path[j][k],path[j][i]+path[i][k]);
                    }
                }
            }
        }
        System.out.println(path[1][n]);
    }
}
