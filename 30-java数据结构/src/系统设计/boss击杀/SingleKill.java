package 系统设计.boss击杀;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/10/24 9:40
 **/
public class SingleKill {
    public static void main(String[] args) {

    }
}
enum TestEnum{
    MON(1,"xiaoming"),SIN;
    int id;
    String name;

    TestEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    TestEnum() {

    }
}