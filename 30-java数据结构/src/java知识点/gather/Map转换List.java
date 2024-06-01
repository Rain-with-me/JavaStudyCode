package java知识点.gather;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map转换List {
    @Test
    @SuppressWarnings("all")
    public void testMap2List() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "ABC");
        map.put("K", "KK");
        map.put("L", "LV");

        // 将Map Key 转化为List
        List<String> mapKeyList = new ArrayList<String>(map.keySet());
        System.out.println("mapKeyList:"+mapKeyList);

        // 将Map values 转化为List
        List<String> mapValuesList = new ArrayList<String>(map.values());
        System.out.println("mapValuesList:"+mapValuesList);

    }
}
