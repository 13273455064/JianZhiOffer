package com.liquor.thread.booleanLock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 测试我的显示锁
 * @author zzc
 */
public class BooleanLockTest {
    /**定义一把锁*/
    private BooleanLock lock = new BooleanLock();


    public void syncMethod() throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 拿到了锁");
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BooleanLockTest blt = new BooleanLockTest();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    blt.syncMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }


    }


}
