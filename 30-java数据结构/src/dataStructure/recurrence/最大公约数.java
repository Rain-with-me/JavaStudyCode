package dataStructure.recurrence;

import java.util.Scanner;

public class 最大公约数 {
  /*
  最大公约数使用辗转相除法，k=m%n    x=n%k  k%x  直到为0
   */

  public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
      int n=scanner.nextInt();
      int m=scanner.nextInt();
      System.out.println(dfs(n,m));
  }

    private static int dfs(int n, int m) {
      int k=n%m;
      if(k==0){
          return m;
      }
      return dfs(m, k);
    }
}
