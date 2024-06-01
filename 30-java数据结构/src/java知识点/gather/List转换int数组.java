package java知识点.gather;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class List转换int数组 {
    public static void main(String[] args) {
        Integer[] a={1,2,3,4};
        List<Integer> list=new ArrayList(Arrays.asList(a));
        list.remove(2);
        Integer[] b=list.toArray(new Integer[3]);
        for (int c:b){
            System.out.println(c);
        }

        /** 
         * @Description: 类名加方法名，也可以使用lamda表达式
         * @Author: 雨同我
         * @DateTime: 2022/8/31 17:41
        */
        
        
//        list转换int
        int[] arr=list.stream().mapToInt(Integer::byteValue).toArray();
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @Description: 包装类型
     * @Author: 雨同我
     * @DateTime: 2023/3/4 11:16
    */
    public static void sort(){

            List<Integer> list=new LinkedList();
            list.add(1);
            list.add(12);
            list.add(13);
            list.add(33);
            Integer[] array = list.toArray(new Integer[0]);
            Integer[] a=new Integer[]{0,9};
            Arrays.sort(a,(Integer o1,Integer o2)->{
                return o1-o2;
            });

    }
}
