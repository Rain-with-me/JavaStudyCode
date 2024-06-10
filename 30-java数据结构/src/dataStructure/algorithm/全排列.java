package dataStructure.algorithm;

public class 全排列 {
    private static int n=3;
    static  boolean[] book=new boolean[10000];
    static int[] a=new int[10000];
    public static void main(String[] args) {
        dfs(1);
    }

    static void dfs(int step) {
        int i;

        if (step == n + 1) {
            for (i = 1; i <= n; i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }

        for (i = 1; i <= n; i++) {
            if (book[i] == false) {
                a[step] = i;
                book[i] = true;
                dfs(step + 1);
                book[i] = false;
            }
        }
    }
}
