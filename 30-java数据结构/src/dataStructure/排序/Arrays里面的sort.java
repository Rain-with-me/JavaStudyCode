package dataStructure.排序;

import java.util.Arrays;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/2/1 17:44
 **/
public class Arrays里面的sort {

    public static void main(String[] args) {
        int[] count = new int[100];
        count[0]=99;
        count[1]=2;
        count[3]=10000;
        Integer[] ok = Arrays.stream(count).boxed().toArray(Integer[]::new);
        Arrays.sort(ok,(o1, o2)->{
            return o2 - o1;
        });
        System.out.println(Arrays.toString(ok));
    }
}
