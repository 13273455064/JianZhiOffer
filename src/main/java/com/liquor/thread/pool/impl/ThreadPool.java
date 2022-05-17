package com.liquor.thread.pool.impl;

/**
 * 线程池接口
 *
 * @author zzc
 */
public interface ThreadPool {

    /**
     * 提交任务到线程池
     */
    void execute(Runnable runnable) throws IllegalAccessException;

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取线程池初始大小
     */
    int getInitSize() throws IllegalAccessException;

    /**
     * 获取线程池最大线程数
     */
    int getMaxSize();

    /**
     * 获取线程池核心线程数量
     */
    int getCoreSize();

    /**
     * 获取线程池用于缓存任务队列的大小
     */
    int getQueueSize();

    /**
     * 获取线程池中活跃线程的数量
     */
    int getActiveCount();

    /**
     * 查看线程池是否被关闭
     */
    boolean isShutdown();
}
