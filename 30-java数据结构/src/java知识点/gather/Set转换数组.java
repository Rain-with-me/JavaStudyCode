package java知识点.gather;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Set转换数组 {
    @Test
    public void test(){
        Set<String> set = new HashSet();
        set.add("AA");
        set.add("BB");
        set.add("CC");
        String[] str=new String[set.size()];
//        转换数组
        set.toArray(str);
        for (String s : str) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(str));

        System.out.println("----------------------------");
        Arrays.asList(str);
        System.out.println(set);
    }
}
