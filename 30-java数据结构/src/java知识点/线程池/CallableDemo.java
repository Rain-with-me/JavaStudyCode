package java知识点.线程池;

import java.util.concurrent.*;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/4/3 10:28
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new ThreadPoolExecutor()
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> submit = executor.submit(new ThreadDemo<Integer>());
        System.out.println(submit.get());

        Future<Integer> submit1 = executor.submit(lambdaCallable());
        System.out.println(submit1.get());

        executor.shutdown();
    }

//    方式2
    public static Callable<Integer> lambdaCallable(){
        final int COUNT=10;
        Callable<Integer> callable=()->{
            int res=0;
            for (int i = 1; i <= COUNT; i++) {
                res+=i;
            }
            return res;
        };
        return callable;
    }
}
class ThreadDemo<T> implements Callable<Integer> {

    private final int COUNT=10;

    @Override
    public Integer call() throws Exception {
        int res=0;
        for (int i = 1; i <= COUNT; i++) {
            res+=i;
        }
        return res;
    }
}
