package com.liquor.thread.pool;

import com.liquor.thread.pool.impl.DenyPolicy;
import com.liquor.thread.pool.impl.RunnableQueue;
import com.liquor.thread.pool.impl.ThreadPool;

import java.util.LinkedList;

/**
 * 线程池阻塞任务队列
 *
 * @author zzc
 */
public class LinkedRunnableQueue implements RunnableQueue {
    /**
     * 任务队列的最大数量
     */
    private final int limit;
    /**
     * 任务队列的拒绝策略
     */
    private final DenyPolicy denyPolicy;
    /**
     * 存放任务的队列
     */
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }


    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            } else {
                //将任务加入到队尾，并且唤醒阻塞的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            //队列为空时，就把当前线程挂起进入等待队列
            while (runnableList.isEmpty()) {
                try {
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
        }
        //返回队列头部的任务
        return runnableList.removeFirst();
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
