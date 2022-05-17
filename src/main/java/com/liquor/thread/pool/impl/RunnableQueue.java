package com.liquor.thread.pool.impl;

/**
 * 任务队列，缓存提交到线程池的任务
 *
 * @author zzc
 */
public interface RunnableQueue {

    /**
     * 将任务提交到任务队列中
     */
    void offer(Runnable runnable);

    /**
     * 从任务队列中获取任务
     */
    Runnable take() throws InterruptedException;

    /**
     * 获取队列中任务的数量
     */
    int size();
}
