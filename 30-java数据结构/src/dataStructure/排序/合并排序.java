package dataStructure.排序;

import java.util.Scanner;

/**
 * @Author: 谭鲁
 * @Description:
 * @DateTime: 2022/11/2 17:24
 **/
public class 合并排序 {
    static int[] temp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }
        temp=new int[arr.length];
        System.out.println();
        mergeSort(arr);
        System.out.print("合并排序之后的数组:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //sort方法的驱动程序
    private static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        //当分到只剩下一个元素的情况,则退出递归程序
        if (left >= right) {
            return;
        }
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right,temp);
    }
    public static void merge(int[] arr,int left,int middle,int right,int[] temp) {
        int i=left;
        int j=middle+1;
        int k=0;//临时数组指针
        while (i<=middle&&j<=right) {
            if(arr[i]<arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }
        while (i<=middle) {
            temp[k++]=arr[i++];
        }
        while (j<=right) {
            temp[k++]=arr[j++];
        }
        int t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

}
