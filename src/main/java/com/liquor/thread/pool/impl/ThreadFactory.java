package com.liquor.thread.pool.impl;

/**
 * 创建线程的工厂
 * @author zzc
 */
@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
