package java知识点.gather;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Map转换set {
    @Test
    @SuppressWarnings("all")
    public void testMap2Set() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "ABC");
        map.put("K", "KK");
        map.put("L", "LV");

        Set<String> set=new HashSet<>(map.values());
        System.out.println(set);


    }
}
