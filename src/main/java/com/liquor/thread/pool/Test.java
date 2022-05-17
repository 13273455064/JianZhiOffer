package com.liquor.thread.pool;

import com.liquor.thread.pool.impl.ThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * 测试线程池
 *
 * @author zzc
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        //初始化线程池
        final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 200);
        //提交20个任务
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " is running and done"));
        }
        while (true) {
            System.out.println("getActiveCount :" + threadPool.getActiveCount());
            System.out.println("getQueueSize :" + threadPool.getQueueSize());
            System.out.println("getCoreSize :" + threadPool.getCoreSize());
            System.out.println("getMaxSize:" + threadPool.getMaxSize());
            System.out.println("======================================");
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
