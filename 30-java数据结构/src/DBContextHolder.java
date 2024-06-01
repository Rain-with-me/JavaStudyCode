import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DBContextHolder {

    public static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->null);


    public static void main(String[] args) throws InterruptedException {
//        getUser(1);
//        getUser(2);
        long start = System.currentTimeMillis();
        NoSynchronizedDemo instance = new NoSynchronizedDemo();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(instance.count);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class NoSynchronizedDemo implements Runnable {

    public  final int MAX = 100000;
    public  int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < MAX; i++) {
            increase();
        }
    }

    public  void increase() {
        synchronized (this) {
            count++;
        }
    }

}

