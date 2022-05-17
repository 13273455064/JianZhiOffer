package com.liquor.thread.booleanLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * 显式锁实现
 *
 * @author zzc
 */
public class BooleanLock implements Lock {
    //当前持有锁的线程
    private Thread currenThread;

    //锁是否被持有
    private boolean lock = false;

    //线程得阻塞队列
    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        //同步代码块，锁住当前对象
        synchronized (this) {
            //如果锁被某一个线程获得，将该线程加入阻塞队列，同时当前线程释放锁
            while (lock) {
                blockedList.add(currenThread);
                this.wait();
            }
            //如果锁没有被其他线程获得，该线程尝试从阻塞队列删除自己
            blockedList.remove(Thread.currentThread());
            //指定锁被获得了
            this.lock = true;
            //记录获得锁的线程
            this.currenThread = Thread.currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = System.currentTimeMillis() + remainingMills;
                while (lock) {
                    //如果剩余时间小于0，说明超时了，抛出超时异常
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills);
                    }
                    if (!blockedList.contains(Thread.currentThread())) {
                        blockedList.add(Thread.currentThread());
                    }
                    this.wait(remainingMills);
                    remainingMills = endMills - System.currentTimeMillis();
                }
                blockedList.remove(Thread.currentThread());
                this.lock = true;
                this.currenThread = Thread.currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            //判断当前线程是不是获得锁的那个线程，只有获取锁的线程才能释放锁
            if (currenThread == Thread.currentThread()) {
                this.lock = false;
                System.out.println(currenThread.getName() + " 释放了锁");
                //唤醒其他所有线程
                this.notifyAll();
            }
        }

    }

    @Override
    public List<Thread> getBlockedThread() {
        return this.blockedList;
    }
}
