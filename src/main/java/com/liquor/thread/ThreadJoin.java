package com.liquor.thread;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(1,3).mapToObj(ThreadJoin::create).collect(Collectors.toList());
        //启动两个线程
        threads.forEach(Thread::start);

        threads.get(0).join();
        //执行两个线程得join方法
        for (Thread thread : threads) {
            //thread.join();
        }

        //main线程输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"#"+i);
        }

    }

    private static Thread create(int name){
        return new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"#"+i);
                shortSleep();
            }
        },String.valueOf(name));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
