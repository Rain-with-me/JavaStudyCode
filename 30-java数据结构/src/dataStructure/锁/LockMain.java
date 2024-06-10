package dataStructure.锁;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: 雨同我
 * @Description:
 *
 *
 *
 * @DateTime: 2023/12/14 16:25
 **/

public class LockMain {

//    在实现数据迁移模块时，里面需要执行多个任务步骤，这里使用CompletableFuture来实现多任务的编排。具体业务是
//    对crm获取到最新的路由，将oracle里面的老表数据搬迁到新表，然后删除老表数据是串行操作,同时mysql数据更新和最新路由的更新是并行操作.
    public static void main(String[] args) {
        LockMain main = new LockMain();
        main.init();
    }

    /**
     * @Description: synchronized的测试
     *
     * synchronized 是可重入的排它锁，和 ReentrantLock 锁功能相似，任何使用 synchronized 的地方，几乎都可以使用 ReentrantLock 来代替，两者最大的相似点就是：可重入 + 排它锁，两者的区别主要有这些：
     *
     * ReentrantLock 的功能更加丰富，比如提供了 Condition，可以打断的加锁 API、能满足锁 + 队列的复杂场景等等；
     * ReentrantLock 有公平锁和非公平锁之分，而 synchronized 都是非公平锁；
     * 两者的使用姿势也不同，ReentrantLock 需要申明，有加锁和释放锁的 API，而 synchronized 会自动对代码块进行加锁释放锁的操作，synchronized 使用起来更加方便。
     *
     *
     * @Description: CountDownLatch
     * 他是一个原子操作类
     * CountDownLatch 中文有的叫做计数器，也有翻译为计数锁，其最大的作用不是为了加锁，而是通过计数达到等待的功能，主要有两种形式的等待：
     *
     *
     * @Author: 雨同我
     * @DateTime: 2023/12/14 16:33
     * @param: null:
     * @return:
    */

    private static boolean flag=false;

    public void init(){
        if (flag){
            return;
        }
        synchronized (this){
            if (flag){
                return;
            }
            System.out.println(this);
            flag=true;
        }
    }
}

/** 
 * @Description: CountDownLatch锁的使用
 * @Author: 雨同我
 * @DateTime: 2023/12/14 16:38
 * @param: null: 
 * @return: 
*/



class CountDownLatch{
    
    public boolean refundByItem(Long itemId) {
        try {
            // 线程沉睡 30 毫秒，模拟单个商品退款过程
            Thread.sleep(30);
            System.out.println("refund success,itemId is {}"+ itemId);
            return true;
        } catch (Exception e) {
            System.err.println("refundByItemError,itemId is {}"+itemId);
            return false;
        }
    }
    
}


/**

 @RestController
 @RequestMapping("/lock")
 @Slf4j
 public class LockController {

 // 定义线程池

 public static final ExecutorService EXECUTOR_SERVICE =
 new ThreadPoolExecutor(10, 10, 0L,
 TimeUnit.MILLISECONDS,
 new LinkedBlockingQueue<>(20));

 @GetMapping
 public void batchRefund() throws InterruptedException {
 // state 初始化为 30
 CountDownLatch countDownLatch = new CountDownLatch(30);
 //        RefundDemo refundDemo = new RefundDemo();

 // 准备 30 个商品

 List<Long> items = new LinkedList<>();
 for (int i = 0; i < 30; i++) {
 items.add(Long.valueOf(i+""));
 }

 // 准备开始批量退款
 List<Future> futures = new LinkedList<>();
 for (Long item : items) {

 // 使用 Callable，因为我们需要等到返回值
 Future<Boolean> submit = EXECUTOR_SERVICE.submit(() -> {
 boolean b = refundByItem(item);
 // 每个子线程都会执行 countDown，使 state -1 ，但只有最后一个才能真的唤醒主线程
 countDownLatch.countDown();
 return b;
 });

 // 收集批量退款的结果
 futures.add(submit);
 }

 log.info("30 个商品已经在退款中");
 // 使主线程阻塞，一直等待 30 个商品都退款完成，才能继续执行
 countDownLatch.await();
 log.info("30 个商品已经退款完成");
 // 拿到所有结果进行分析
 List<Boolean> result = futures.stream().map(fu-> {
 try {
 // get 的超时时间设置的是 1 毫秒，是为了说明此时所有的子线程都已经执行完成了
 return (Boolean) fu.get(1,TimeUnit.MILLISECONDS);
 } catch (InterruptedException e) {
 e.printStackTrace();
 } catch (ExecutionException e) {
 e.printStackTrace();
 } catch (TimeoutException e) {
 e.printStackTrace();
 }
 return false;
 }).collect(Collectors.toList());
 // 打印结果统计
 long success = result.stream().filter(r->r.equals(true)).count();
 log.info("执行结果成功{},失败{}",success,result.size()-success);
 }

 public boolean refundByItem(Long itemId) {
 try {
 // 线程沉睡 30 毫秒，模拟单个商品退款过程
 Thread.sleep(30);
 log.info("refund success,itemId is {}", itemId);
 return true;
 } catch (Exception e) {
 log.error("refundByItemError,itemId is {}", itemId);
 return false;
 }
 }

 }

*/