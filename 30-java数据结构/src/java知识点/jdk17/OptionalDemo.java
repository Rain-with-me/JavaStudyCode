package java知识点.jdk17;

import java.util.Optional;

/**   https://doc.qzxdp.cn/jdk/17/zh/api/java.base/java/util/Optional.html
 * @Author: 雨同我
 * @Description:   ofNullable  【可能为空】  返回一个 Optional 描述给定值，如果非 null ，否则返回一个空的 Optional 。
 *                  of    【确定不为空】  返回一个 Optional 描述给定的非 null 值。
 *                  orElse  【设置一个返回值】
 *                  ofNullable  【为空时，不会创建里面的对象】
 * @DateTime: 2023/11/16 15:17
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        String s = new String("");
//        String test1 = Optional.ofNullable(s).orElse(createTest());
        String test2 = Optional.of(s).orElseGet(OptionalDemo::createTest);
//        System.out.println(ok);
    }
    public static String createTest(){
        System.out.println("创建了对象");
        return "ok";
    }
}
