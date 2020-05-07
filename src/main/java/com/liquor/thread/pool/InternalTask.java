package com.liquor.thread.pool;

import com.liquor.thread.pool.impl.RunnableQueue;

/**
 * 线程池内部任务，不断从任务队列中取出Runnable，执行Runnable的run方法
 * @author zzc
 */
public class InternalTask implements Runnable {
    /**任务队列*/
    private final RunnableQueue runnableQueue;
    /**可以控制任务运行和停止，需要线程安全*/
    private volatile boolean running = true;

    public  InternalTask(RunnableQueue runnableQueue){
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果当前任务为running并且没有被中断，就不断地从queue中获取Runnable,执行run方法
        while (running && !Thread.currentThread().isInterrupted()){

            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    /**停止当前任务，在shutdown方法中使用*/
    public void stop(){
        this.running = false;
    }
}
