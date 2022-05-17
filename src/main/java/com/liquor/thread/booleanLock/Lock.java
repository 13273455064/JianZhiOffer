package com.liquor.thread.booleanLock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * 自定义一个显式锁接口
 *
 * @author zzc
 */
public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThread();
}
