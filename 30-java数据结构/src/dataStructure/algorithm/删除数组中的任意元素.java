package dataStructure.algorithm;


import java.util.Arrays;
import java.util.Scanner;

public class 删除数组中的任意元素 {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int a[]={1,5,8,4};
            int newScores[];
                    // 复制原数组的前5个元素到newScores数组中
           newScores=Arrays.copyOfRange(a, 0, 5);

            a[0]=0;
    //        数组缩容
            a= Arrays.copyOf(a,a.length-1);
            System.out.println(Arrays.toString(a));

//            数组复制
            int b[]=Arrays.copyOf(a,a.length);
            System.out.println(Arrays.toString(b));
        }

}

