package com.liquor.thread.pool.impl;

/**
 * 线程池的拒绝策略
 *
 * @author zzc
 */
@FunctionalInterface
public interface DenyPolicy {

    void reject(Runnable runnable, ThreadPool threadPool);


}
