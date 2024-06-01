package dataStructure.recurrence;

import java.util.HashMap;
import java.util.Map;

public class 斐波那契数列 {
    static Map<Integer, Long> map=new HashMap();
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        map.put(1,1L);
        map.put(2,1L);
        long d = d(100);
        System.out.println(d);
        long end=System.currentTimeMillis();
        System.out.println((end-start)+"ms");
        System.out.println(Long.MAX_VALUE);
    }

    private static long d(int i) {
        if (map.containsKey(i)){
            return map.get(i);
        }else {
            map.put(i,d(i-1)+d(i-2));
        }
        return d(i-1)+d(i-2);
    }
}
