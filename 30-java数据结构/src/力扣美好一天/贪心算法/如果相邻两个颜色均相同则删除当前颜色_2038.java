package 力扣美好一天.贪心算法;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/22 19:50
 */
public class 如果相邻两个颜色均相同则删除当前颜色_2038 {

    /**
       * @description:  应该是用贪心算法的，用个正则表达式，结果超时了
       *  * @param args
       * @return: void
       * @author: 鲁子哥的每一天
       * @time: 2022/3/22 19:51
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String s="AAAAABBBBBBAAAAA";
        System.out.println(winnerOfGame(s));
    }
    public static boolean winnerOfGame(String colors) {
        String A="AAA";
        String B="BBB";
        for (int i=1;;i++){
            if (i%2!=0){
                if (colors.contains(A)){
                    colors=colors.replaceFirst("A{3}","AA");
                }else {
                    return false;
                }
            }else {
                if (colors.contains(B)){
                    colors=colors.replaceFirst("B{3}","BB");
                }else {
                    System.out.println(colors);
                    return true;
                }
            }
        }
    }
}
