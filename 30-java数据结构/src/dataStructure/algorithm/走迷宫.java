package dataStructure.algorithm;

import java.util.Scanner;

public class 走迷宫 {
    final static int N=3;
    static int[][] a=new int[1000][1000];
    static boolean[][] book=new boolean[1000][1000];
    static int q,p,n,m,sx,sy,min= Integer.MAX_VALUE,tx,ty,k;
   static int next[][]={
           /*向右走*/
           {0,1},
//           向下走
            {1,0},
            {0,-1},
            {-1,0}};

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                a[i][j]=scanner.nextInt();
            }
        }
//        输入起点和终点
        sx=scanner.nextInt();
        sy=scanner.nextInt();
        p=scanner.nextInt();
        q=scanner.nextInt();
        book[sx][sy]=true;
        dfs(sx,sy,0);
        System.out.println(min);
    }

   static void dfs(int x, int y, int step) {

        if(x==p&&y==q){
            if(step<min){
                min=step;
            }
            return;
        }

//        枚举4种方法
        for (k=0;k<=N;k++){
            tx=x+next[k][0];
            ty=y+next[k][1];
//            判断是否越界
            if (tx < 1 || tx > n || ty < 1 || ty > m) {
                continue;
            }

            if(a[tx][ty]==0&&book[tx][ty]==false){
                System.out.println(tx+" "+ty);
                book[tx][ty]=true;
                dfs(tx,ty,step+1);
                book[tx][ty]=false;
            }
        }
        return;
    }
}

