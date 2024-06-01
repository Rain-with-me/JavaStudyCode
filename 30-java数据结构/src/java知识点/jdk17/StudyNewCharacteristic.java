package java知识点.jdk17;

/**
 * @Author: 雨同我
 * @Description:
 * ## 1.record定义类
 * - record用于创建不可变的数据类。在这之前如果你需要创建一个存放数据的类，通常需要先创建一个Class，
 * 然后生成构造方法、getter、setter、hashCode、equals和toString等这些方法，或者使用Lombok来简化这些操作。
 *
 * ## 3. switch
 *
 *
 * @DateTime: 2023/11/2 17:02
 **/
public class  StudyNewCharacteristic {
    public static void main(String[] args) {
        User user = new User("1","小米");
        System.out.println(user.id()+"----------"+user.name());
        String s=switch (user.id()){
            case "1"-> "userId="+user.id();
            default -> "0";
        };
    }
}
record User(String id,String name){

}

