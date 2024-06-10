package java知识点.jdk17;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: 雨同我
 * @Description: filter是过滤元素，map是元素的映射
 * @DateTime: 2024/4/8 11:25
 **/
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        // 创建测试数据
        list.add(new Person("1", "Alice", 25));
        list.add(new Person("2", "Bob", 10));
        list.add(new Person("3", "Charlie", 99));
        list.add(new Person("4", "David", 8));

        List<Person> res = list.stream()
                .filter(k -> k.getAge() > 18).toList();

        List<String> map = list.stream().map(Person::getName).toList();

    }
}
@Data
@AllArgsConstructor
class Person{
    String id;
    String name;
    int age;
}
