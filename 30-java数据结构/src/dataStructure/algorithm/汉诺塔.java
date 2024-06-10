package dataStructure.algorithm;

import java.util.Scanner;

public class 汉诺塔 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        char x='X',y='Y',z='Z';
        move(n,x,y,z);
    }

//    n是盘子的个数，x,y,z是3根柱子
    @SuppressWarnings("all")
    private static void move(int n, char x, char y, char z) {
        if (n==1){
            System.out.println(x+"-->"+z);
        }else {
            move(n-1,x,z,y);     //将n-1个盘子从x移动到y借助y
            System.out.println(x+"-->"+z);     //将第n个盘子从x移动到z
            move(n-1,y,x,z);         //n-1个盘子从y移动到z
        }
    }

}
