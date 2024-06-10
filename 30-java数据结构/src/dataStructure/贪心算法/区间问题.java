package dataStructure.贪心算法;

import java.util.Arrays;
import java.util.Scanner;

/*
* [1,2]  [1,3]  [2,4]
* 移除多少个才能保留完整区间，没有重复
*/

public class 区间问题 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][] a=new int[3][2];
        for (int i=0;i<3;i++){
            for (int j = 0; j < 2; j++) {
                a[i][j]=scanner.nextInt();
            }
        }
        System.out.println(solution(a));

    }
    protected static int solution(int[][] V){
        int count=0;
        Arrays.sort(V,((o1,o2) -> {
            return o1[0]-o2[0];
        }));
        for (int i=0;i<3;i++){
            for (int j = 0; j < 2; j++) {
                System.out.print(V[i][j]+" ");
            }
            System.out.println();
        }

        int min=V[0][1];
        for (int i=1;i<V.length;i++){
            if (V[i][0]>=min){
                count++;
                min=V[i][1];
            }
        }
        System.out.println(count);
        return V.length-count;
    }
}
