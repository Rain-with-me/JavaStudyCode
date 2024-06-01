package 系统设计.异步编排;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/12/18 10:52
 **/


public class AsyncMain {

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
//            return "ok";
            System.out.println("test");
        });
//        f1.join();

    }
}
