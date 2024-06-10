package java知识点.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/4/9 11:39
 **/
public class  DiyThreadPool {
    public static void main(String[] args) {

    }

//   线程池命名
    public static void diyThreadName(){
//        ThreadFactory threadFactory = new ThreadFactory();
//        new ThreadPoolExecutor(1,1,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<String>());
    }
}

final class NamingThreadFactory implements ThreadFactory{
    private AtomicInteger atomicInteger=new AtomicInteger();
    private String name;

    public NamingThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread();
        thread.setName(name+" [#"+ atomicInteger.incrementAndGet()+"#]");
        return thread;
    }
}
