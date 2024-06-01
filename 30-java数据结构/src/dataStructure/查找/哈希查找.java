package dataStructure.查找;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/5/3 21:24
 */
import java.util.*;


/**
   * @description: 实现哈希查找。要求根据给定的哈希函数进行存储，
 * 并查找相应元素的存储位置。本题目使用的哈希函数为除留取余法，
 * 即H(key)=key%m，其中m为存储空间，冲突处理方法采用开放定址法中的线性探测再散列，
 * 即Hi=(H(key)+i)%m，0<=i<=m-1。
 * 输入：
 * 输入包含若干个测试用例，第一行为测试用例个数。每个测试用例占3行，
 * 第一个为元素个数m，第二行为m个元素值，即需要进行散列存储的元素个数，
 * 同时也是存储空间个数（空间位置从0开始存储），第三行为需要查找的元素。
 * 输出：
 * 对每一测试用例，分别用两行输出，第一行输出所有的元素，要求按存储地址从0开始输出，
 * 用空格隔开，第二行输出需要查找的元素在数组中的位置，即对应数组中的下标。
 * 输入样例：
 * 1
 * 5
 * 2 4 1 7 9
 * 7
 * 输出样例：
 * 9 1 2 7 4
 * 3
   * @author: 鲁子哥的每一天 
   * @time: 2022/5/3 21:25
 */



@SuppressWarnings("all")
public class 哈希查找 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, i, j, k, b;
        n = in.nextInt();
        for (i = 0; i < n; i++) {
            k = in.nextInt();   //个数
            int c[] = new int[k];
            for(int y = 0;y<k;y++)
                c[y] = -1;
            //构建哈希数组
            for (j = 0; j < k; j++) {
                int number = in.nextInt();
                hashi(c, number%k, k,number);
            }
            print(c,k);
            b = in.nextInt();
            System.out.println(search(c, k, b));
        }
    }

    public static void hashi(int[] c, int b, int k,int y) {
        if(c[b]==-1) {
            c[b] = y;
        } else{
            b = (b+1)%k;
            hashi(c,b,k,y);
        }
    }

    public static void print(int c[], int length) {
        for (int i = 0; i < length; i++) {
            if (i!=length-1) {
                System.out.print(c[i] + " ");
            }else {
                System.out.println(c[i]);
            }
        }
    }

    public static int search(int c[], int length, int b) {
        for (int i = 0; i < length; i++) {
            if (c[i] == b)
                return i;
        }
        return -1;
    }
}