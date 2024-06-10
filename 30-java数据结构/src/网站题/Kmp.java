package 网站题;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/9/25 11:05
 **/
import java.util.Arrays;


/**
 * 详解参考：https://blog.csdn.net/qq_37174526/article/details/90141833
 * 首先，要了解两个概念："前缀"和"后缀"。 "前缀"指除了最后一个字符以外，
 * 一个字符串的全部头部组合；"后缀"指除了第一个字符以外，一个字符串的全部尾部组合。
 *
 * "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度。以"ABCDABD"为例，
 *
 * 　　－　"A"的前缀和后缀都为空集，共有元素的长度为0；
 *
 * 　　－　"AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；
 *
 * 　　－　"ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
 *
 * 　　－　"ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
 *
 * 　　－　"ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；
 *
 * 　　－　"ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；
 *
 * 　　－　"ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
 */



public class Kmp {
    public static void main(String[] args) {
        String s="ababaaababaa";
        char[] array = s.toCharArray();
        int i = s.length();
        System.out.println(Arrays.toString(getNext(s)));
    }
    /**
     * O(m+n)
     * @param s 目标串
     * @param p 模式串
     * @return 如果匹配成功，返回下标，否则返回-1
     */
    private static int kmpSearch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return -1;
        }
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i < sLen && j < pLen) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        System.out.println(i+"-----"+j);
        return j==pLen?i-j:-1;
    }
    /**
     *  k是前缀，i是后缀，如果不等，就k=next[k],前缀往前移
     * @param p 匹配串(字串)
     * @return
     */
    private static int[] getNext(String p) {
        int len = p.length();
        int[] next = new int[len+1];
        next[0] = -1;
        int i=0,k=-1;
        while (i<len){
            if (k==-1||p.charAt(i)==p.charAt(k)){
                k++;
                i++;
                next[i]=k;
            }else {
                k=next[k];
            }
        }
        return next;
    }
}
