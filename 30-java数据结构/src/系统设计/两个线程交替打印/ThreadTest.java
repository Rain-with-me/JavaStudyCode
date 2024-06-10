package 系统设计.两个线程交替打印;

/**
 * @Author: 雨同我
 * @Description:  使用valateile变量来实现
 * @DateTime: 2023/11/3 11:02
 **/
public class ThreadTest {
    private static volatile boolean flag=true;
    private static volatile int num=1;
    public static void main(String[] args) {
        new Thread(()->{
            while (num < 10) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + "---->" + num);
                    num++;
                    flag = false;
                }
            }
        },"1号").start();

        new Thread(()->{
            while (num < 10) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + "---->" + num);
                    num++;
                    flag = true;
                }
            }
        },"2号").start();
    }
}
