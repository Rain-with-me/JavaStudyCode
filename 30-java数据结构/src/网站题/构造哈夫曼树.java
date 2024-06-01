package 网站题;


/**
 * @Description: 构造哈夫曼树
 * 题目描述：
 * 根据给定的叶结点字符及其对应的权值创建哈夫曼树。
 * 输入：
 * 第一行为叶子结点的数目n(1<=n<=100)。第二行为一个字符串，包含n个字符，
 * 每个字符对应一个叶子结点，第三行为每个叶子结点的概率（即权值），
 * 要求根据各叶结点构造哈夫曼树。构造哈夫曼树的原则是先两个最小的，构造一个父结点，
 * 其中最小的结点为左孩子，次小的为右孩子，如果两个最小的叶结点相等，
 * 则取排在前一个位置的为左孩子。
 * 输出：
 * 哈夫曼树的权值，左孩子，右孩子及其对应的父亲，相邻数据之间用空格隔开；
 * 输入样例：
 * 5
 * abcde
 * 15 25 15 20 25
 * 输出样例：
 * 15 0 0 6
 * 25 0 0 7
 * 15 0 0 6
 * 20 0 0 7
 * 25 0 0 8
 * 30 1 3 8
 * 45 4 2 9
 * 55 5 6 9
 * 100 7 8 0
 * @Author: 雨同我
 * @Date: 2022/5/18
*/


/**
 * @description:  思路：
 *                  1.len是构建的长度，从n开始，因为下标是从0开始，
 *                  需要先确定他的左和右孩子，然后在len++
 *                  2.查找2个最小的，第二次记得判断不能和第一次相同
 *                  3.构建时是2n-1,for循环只需要在构建n到2n-1即可
 * @author: 鲁子哥的每一天
 * @time: 2022/5/6 11:32
 */

import java.util.Scanner;
public class 构造哈夫曼树 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        String s=scanner.next();
        int sum=2*n-1;
        HaFuMaTree[] tree=new HaFuMaTree[sum];
        for (int i = 0; i < n; i++) {
            tree[i]=new HaFuMaTree();
            tree[i].value=scanner.nextInt();
            tree[i].left=0;
            tree[i].right=0;
            tree[i].father=0;
        }

        int len=n;
        for (int i = n; i < sum; i++) {
            int lMin=Integer.MAX_VALUE,rMin=Integer.MAX_VALUE;
            int lChild=0,rChild=0;
            for (int j = 0; j < len; j++) {
                if (tree[j].value<lMin&&tree[j].father==0){
                    lMin=tree[j].value;
                    lChild=j;
                }
            }
            for (int j = 0; j < len; j++) {
                if (tree[j].value<rMin&&tree[j].father==0&&j!=lChild){
                    rMin=tree[j].value;
                    rChild=j;
                }
            }
            tree[len]=new HaFuMaTree();
            tree[len].value=tree[lChild].value+tree[rChild].value;
            tree[len].left=lChild+1;
            tree[len].right=rChild+1;
            tree[lChild].father=len+1;
            tree[rChild].father=len+1;
            len++;
        }

        for (int i = 0; i < sum; i++) {
            System.out.println(tree[i].value+" "+tree[i].left+" "+tree[i].right+" "+tree[i].father);
        }
    }
    public static class HaFuMaTree{
        int value;
        int left;
        int right;
        int father;
    }
}
