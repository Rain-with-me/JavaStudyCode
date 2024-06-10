package java知识点.jdk17;

/**
 * @Author: 雨同我
 * @Description:  字符串测试
 * @DateTime: 2023/11/8 10:46
 **/
public class StringApiDemo {
    public static void main(String[] args) {

    }

    /**
     * @Description:  需求：比较2个字符串，以数字类型进行比较，例如 12345>12344
     * compareTo是比较2个字符串，从头开始比较，返回ascii码之间的差值  123.compareTo(329) res=-2
    */
    public static void digitString(String max,String str){
        if (max.length()<str.length()){
            max=str;
        }else if (max.length()==str.length()&&max.compareTo(str)<0){
            max=str;
        }
    }

}
