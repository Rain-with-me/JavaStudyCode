package java知识点.gather;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/15 10:18
 */
public class 查找字符串出现的次数 {
        public static void main(String[] args) {
            String s="123000123000123";
            String ss="123";
            int index = 0,count=0;
            while ((index = s.indexOf(ss, index))!=-1){
                System.out.println(index+"---");
                count++;
                index+=ss.length();
            }
            System.out.println(count);
        }
}
