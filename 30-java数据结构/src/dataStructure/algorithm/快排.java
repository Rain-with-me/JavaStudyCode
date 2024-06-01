package dataStructure.algorithm;

import java.util.Scanner;

public class 快排 {
    static int[] ch=new int[11];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        for (int i=1;i<=10;i++){
            ch[i]=scanner.nextInt();
        }
        Sort(1,10);

        for (int i=1;i<=10;i++){
            System.out.print(ch[i]+" ");
        }
    }

    private static void Sort(int left, int right) {
        int temp,i,j,t;
        if (left>right){
            return;

        }
        i=left;
        j=right;
        temp=ch[left];

        while (i!=j){
//         顺序很重要，必须从右向左
            while (ch[j]>=temp&&i<j){
                j--;
            }
//            当比temp大时找到
            while (ch[i]<=temp&&i<j){
                i++;
            }

            if (i<j){
                 t=ch[i];
                ch[i]=ch[j];
                ch[j]=t;
            }

        }
//        更改基准数
        ch[left]=ch[i];
        ch[i]=temp;
        System.out.println(i);
        Sort(left, i - 1);
        Sort(i+1,right);
    }
}
