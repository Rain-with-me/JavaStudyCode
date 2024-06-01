package dataStructure.排序;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/24 8:21
 */
public class 快排 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int[] arr=new int[]{3,45,78,99};
        System.out.println(s1(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static int s1(int[] arr) {
        int length = arr.length;
        int max = Math.max(arr[0], arr[1]);
        int min = Math.min(arr[0], arr[1]);
        for (int k = 1; k < length; k++) {
            if (arr[k] > Math.max(min, max)) {
                max = arr[k];
            } else if (arr[k] < Math.min(min, max)) {
                // do nothing
            } else {
                min = arr[k];
            }
        }
        return min;
    }

    private static void quickSort(int[] arr,int left, int right) {
        if(left>=right) {
            return;
        }
        int index=arr[left];
        int i=left,j=right;
        while (i<j){
            while (i<j&&arr[j]>=index){
                j--;
            }
            while (i<j&&arr[i]<=index){
                i++;
            }
            if (i<j){
                int t=arr[j];
                arr[j]=arr[i];
                arr[i]=t;
            }
        }
        arr[left]=arr[i];
        arr[i]=index;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }
}
