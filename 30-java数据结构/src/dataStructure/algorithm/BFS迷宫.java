
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@SuppressWarnings("all")
public class BFS迷宫 {
    static char[][] ch;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ch=new char[n][n];
        for (int i=0;i<n;i++){
            ch[i]=scanner.next().toCharArray();
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (ch[i][j]=='S'){
                    int bfs = bfs(i, j);
                    System.out.println(bfs);
                }
            }
        }
    }

    private static int bfs(int x, int y) {
        Queue<Step> queue=new LinkedList<Step>();
        queue.offer(new Step(x,y,0));
        int[][] next={{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] f=new boolean[n][n];
        f[x][y]=true;

        while (!queue.isEmpty()){
            Step now=queue.peek();
            if (ch[now.x][now.y]=='G'){
                return now.step;
            }
            for (int i=0;i<4;i++){
                int sx=next[i][0]+now.x;
                int sy=next[i][1]+now.y;
                if (sx>=0&&sx<n&&sy>=0&&sy<n&&f[sx][sy]==false&&ch[sx][sy]!='*'){
                    System.out.println("sx="+sx+"   sy="+sy);
                    queue.offer(new Step(sx,sy,now.step+1));
                    f[sx][sy]=true;
                }
            }
            queue.poll();
        }
        return -1;
    }
}
class Step{
    int x,y,step;

    public Step(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}


//        .....
//        .*.*.
//        .*S*.
//        .***.
//        ...G*
//
//        答案 11