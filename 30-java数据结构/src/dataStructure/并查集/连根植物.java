package dataStructure.并查集;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/4/6 21:05
 */
import java.io.BufferedInputStream;
import java.util.*;

@SuppressWarnings("all")
public class 连根植物 {
    static int[] a;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        a=new int[100000];
        for (int i = 1; i <= n * m; i++) {
            a[i]=i;
        }
        while (k-->0){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            if(find(x)!=find(y)){
                union(x,y);
            }
        }
        int sum=0;
        for (int i = 1; i <= n * m; i++) {
            if (i==a[i]){
                sum++;
            }
        }
        System.out.println(sum);
    }

    private static void union(int x, int y) {
        //注意点： 直接找x,y对应的数组值
        x=find(a[x]);
        y=find(a[y]);
        if (x!=y){
            a[x]=y;
        }
    }

    private static int find(int x) {
        if (x==a[x]){
            return x;
        }
        find(a[x]);
        return a[x];
    }
}
