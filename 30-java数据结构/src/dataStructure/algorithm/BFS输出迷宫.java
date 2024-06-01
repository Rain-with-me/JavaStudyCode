package dataStructure.algorithm;

import java.util.Scanner;

public class BFS输出迷宫 {
    static int n,m;
    static char[][] ch;
    static boolean[][] vis;
    static int[][] next={{1,0},{-1,0},{0,1},{0,-1}};
    static No[] qu;
    static int head=0,tail=1;
    static String[] str={"D","U","R","L"};

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();

        ch=new char[n][m];
        vis=new boolean[n][m];
        qu=new No[25];
        for (int i=0;i<n;i++){
            ch[i]=scanner.next().toCharArray();
        }
        bfs(0,0);
        System.out.println(qu[n].step);
    }

    @SuppressWarnings("all")
    private static void bfs(int xx, int yy) {
        qu[head]=new No(xx,yy,-1,0,"");
        while (tail>head){
            for (int i=0;i<4;i++){
                int sx=qu[head].x+next[i][0];
                int sy=qu[head].y+next[i][1];

                if (sx>=0&&sx<n&&sy>=0&&sy<m&&vis[sx][sy]==false&&ch[sx][sy]=='0'){
                    vis[sx][sy]=true;
                    qu[tail]=new No(sx,sy,head,qu[head].step+1,str[i]);
                    tail++;
                }
                if (sx==n-1&&sy==m-1){
                    print(head);
                    return ;
                }
            }
            head++;
        }
    }

    private static void print(int h) {
        if (qu[h].f!=-1){
            print(qu[h].f);
        }
        System.out.println(h+"----("+qu[h].x+","+qu[h].y+")--"+qu[h].s);
    }
}
class No{
     int x;
     int y;
     int f;
     int step;
     String s;

    public No(int x, int y, int f, int step, String s) {
        this.x = x;
        this.y = y;
        this.f = f;
        this.step = step;
        this.s = s;
    }
}



