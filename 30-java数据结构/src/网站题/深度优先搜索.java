package 网站题;




/**
 * @Description: 图的深度优先搜索
 * 描述：
 * 图的深度优先搜索类似于树的先根遍历，是树的先根遍历的推广。即从某个结点开始，
 * 先访问该结点，然后深度访问该结点的第一棵子树，依次为第二顶子树。如此进行下去，
 * 直到所有的结点都访问为止。在该题中，假定所有的结点以“A”至“Z”中的若干字符表示，
 * 且要求结点的访问顺序根据“A”至“Z”的字典顺序进行访问。例如有如下图：
 *
 *
 * 如果要求从H开始进行深度优先搜索，则搜索结果为：H->A->K->U->E.
 * 输入：
 * 输入只包含一个测试用例，第一行为一个自然数n，表示顶点的个数，
 * 第二行为n个大写字母构成的字符串，表示顶点，接下来是为一个n*n大小的矩阵，
 * 表示图的邻接关系。数字为0表示不邻接，否则为相应的边的长度。
 * 最后一行为一个字符，表示要求进行深度优先搜索的起始顶点。
 * 输出：
 * 用一行输出深度优先搜索结果，起始点为给定的顶点，各顶点之间用一个空格隔开(注意后面的提示)。
 * 样例输入：
 * 5
 * HUEAK
 * 0 0 2 3 0
 * 0 0 0 7 4
 * 2 0 0 0 0
 * 3 7 0 0 1
 * 0 4 0 1 0
 * H
 * 样例输出：
 * H A K U E
 *
 * 算法提示：首先根据图的邻接矩阵创建邻接表（采用后插法，即每个边结点都插入到最后一个位置）
 * ，然后结合栈结构完成图的深度优先遍历
 * @Author: 雨同我
 * @Date: 2022/5/7
 */

import java.util.Scanner;
public class 深度优先搜索 {
    static int[][] a;
//    map是26个字母的映射表
    static int[] map;
    static boolean[] vis;
    static String str;

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        str = scanner.next();

        a=new int[n][n];
        map=new int[26];
        vis=new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]=scanner.nextInt();
            }
        }
        char start=scanner.next().charAt(0);
        for (int i = 0; i < n; i++) {
            map[str.charAt(i)-'A']=i;
        }
        dfs(str.indexOf(start));
    }

//    a[index][t]==0这个判断的是index这个点到t这个点是否能够到达
    private static void dfs(int index) {
        System.out.print(str.charAt(index));
        vis[index]=true;
        for (int i = 0; i < 26; i++) {
            int t=map[i];
            if (vis[t]==true||a[index][t]==0){
                continue;
            }else {
                dfs(t);
            }
        }
    }
}
//5
//         HUEAK
//         0 0 2 3 0
//         0 0 0 7 4
//         2 0 0 0 0
//         3 7 0 0 1
//         0 4 0 1 0
//         H