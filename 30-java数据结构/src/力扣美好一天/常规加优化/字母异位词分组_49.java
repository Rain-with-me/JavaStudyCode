package 力扣美好一天.常规加优化;

import java.util.*;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/9/27 9:38
 **/
public class 字母异位词分组_49 {
    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap();
        List<List<String>> list = new ArrayList<>();
        for(String str:strs){
            char[]  arr = str.toCharArray();
            Arrays.sort(arr);
            String t = new String(arr);
            if (map.containsKey(t)){
                List<String> tList = map.get(t);
                tList.add(str);
                map.put(t,tList);
            }else {
                List<String> tList = new ArrayList<>();
                tList.add(str);
                map.put(t,tList);
            }
        }
        map.forEach((k,v)->{
            list.add(v);
        });
        return list;
    }
}
