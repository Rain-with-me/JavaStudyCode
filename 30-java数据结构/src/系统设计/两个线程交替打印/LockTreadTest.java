package 系统设计.两个线程交替打印;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/3 11:17
 **/
public class LockTreadTest {
    private static volatile int num=1;
    public static void main(String[] args) {
            new Thread(()->{
                while (num<10){

                }
            },"1号lock");
    }
}
