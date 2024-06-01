package 设计模式.行为型模式.模板模式;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/10/30 16:59
 **/
public class TemplateImpl extends Template{
    @Override
    public void exec1() {
        System.out.println("=============执行exec1");
    }

    @Override
    public void exec2() {
        System.out.println("=============执行exec2");
    }

    public static void main(String[] args) {
        TemplateImpl template = new TemplateImpl();
        template.TemplateTest();
    }
}
