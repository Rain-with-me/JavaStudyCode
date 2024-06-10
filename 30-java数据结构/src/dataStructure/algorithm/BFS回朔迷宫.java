package dataStructure.algorithm;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/4/6 16:57
 */
import java.io.BufferedInputStream;
import java.util.*;

/**
   * @description:    s.step=poll;这个是注意点，因为他是最后然后找前面的
   *  * @param null
   * @return:
   * @author: 鲁子哥的每一天
   * @time: 2022/4/6 16:58
 */

@SuppressWarnings("all")
public class BFS回朔迷宫 {
    public static void main(String[] args) {
        long t1=System.currentTimeMillis();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        char[][] a=new char[5][5];
        boolean[][] vis=new boolean[5][5];
        int n=5;
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextLine().replaceAll(" ","").toCharArray();
        }



        int[][] next={{1,0},{0,1},{-1,0},{0,-1}};
        Queue<S> queue = new LinkedList<>();
        vis[0][0]=true;
        queue.offer(new S(0,0));
        while (!queue.isEmpty()){
            S poll = queue.poll();
            int x=poll.x;
            int y=poll.y;
            if (x==n-1&&y==n-1){
                dfs(poll);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int sx=x+next[i][0];
                int sy=y+next[i][1];
                if (sx>=0&&sx<n&&sy>=0&&sy<n&&vis[sx][sy]==false&&a[sx][sy]=='0'){
                    S s = new S(sx, sy);
                    s.step=poll;
                    queue.offer(s);
                    vis[sx][sy]=true;
                }
            }
        }
    }
    private static void dfs(S step) {
        if (step==null){
            return;
        }
        dfs(step.step);
        System.out.println("("+step.x+", "+step.y+")");
    }
}
class S{
    int x;
    int y;
    S step=null;

    public S(int x, int y) {
        this.x = x;
        this.y = y;
    }
}