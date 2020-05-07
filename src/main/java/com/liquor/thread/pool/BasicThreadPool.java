package com.liquor.thread.pool;

import com.liquor.thread.pool.impl.DenyPolicy;
import com.liquor.thread.pool.impl.RunnableQueue;
import com.liquor.thread.pool.impl.ThreadFactory;
import com.liquor.thread.pool.impl.ThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 * @author zzc
 */
public class BasicThreadPool extends Thread implements ThreadPool {

    /**线程池初始化线程数*/
    private final int initSize;
    /**线程池最大线程数*/
    private final int maxSize;
    /**线程池核心线程数*/
    private final int coreSize;
    /**线程池活跃线程数*/
    private int activeSize;
    /**创建线程的工厂*/
    private final ThreadFactory threadFactory;
    /**任务队列*/
    private final RunnableQueue runnableQueue;
    /**线程池是否被关闭*/
    private boolean isShutdown;
    /**工作线程队列*/
    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();
    /**默认的拒绝策略*/
    private static final DenyPolicy DEFAULT_DENY_POLICY = new DiscardDenyPolicy();
    /**默认的线程创建工厂*/
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();
    private final long keepAliveTime;
    private final TimeUnit timeUnit;

    public BasicThreadPool(int initSize, int maxSize, int coreSize,int queueSize){
        this(initSize,maxSize,coreSize,DEFAULT_THREAD_FACTORY,
                queueSize,DEFAULT_DENY_POLICY,10,TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize,int maxSize, int coreSize,ThreadFactory threadFactory,
                           int queueSize,DenyPolicy denyPolicy,long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize,denyPolicy,this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    private void init(){
        start();
        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    /**提交任务就是把Runnable加入到队列里面*/
    @Override
    public void execute(Runnable runnable) throws IllegalAccessException {
        if (this.isShutdown){
            throw new IllegalAccessException("线程池已经被销毁");
        }
        this.runnableQueue.offer(runnable);
    }

    private void newThread(){
        //创建任务线程，并且启动
        InternalTask internalTask = new InternalTask(this.runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread,internalTask);
        threadQueue.offer(threadTask);
        this.activeSize++;
        thread.start();
    }

    private void removeThread(){
        //从线程池中移除线程，这里是移除的第一个
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeSize--;
    }

    @Override
    public void run(){
        //用于维护线程数量，扩容，回收等
        while (!isShutdown && !isInterrupted()){
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                this.isShutdown = true;
                break;
            }
            synchronized (this){
                if (isShutdown){
                    break;
                }
                //当前队列中没有未处理的任务，并且activeCount < coreSize,继续扩容
                if (runnableQueue.size()>0 && activeSize<coreSize){
                    for (int i = activeSize; i <coreSize ; i++) {
                        newThread();
                    }
                    //continue 的目的在于不想继续往下执行，造成线程的扩容直接达到 maxsize
                    continue;
                }
                //当前队列中没有未处理的任务，并且activeCount < maxSize,继续扩容
                if (runnableQueue.size()>0 && activeSize<maxSize){
                    for (int i = activeSize; i <maxSize ; i++) {
                        newThread();
                    }
                }
                //如果队列中没有任务，则需要回收线程至coreSize
                if (runnableQueue.size()==0 && activeSize>coreSize){
                    for (int i = coreSize; i <activeSize ; i++) {
                        removeThread();
                    }
                }
            }
        }
    }


    @Override
    public void shutdown() {
        synchronized (this){
            if (isShutdown){return;}
            isShutdown = true;
            threadQueue.forEach(threadTask -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown){
            throw new IllegalStateException("线程池已经关闭");
        }
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (isShutdown){
            throw new IllegalStateException("线程池已经关闭");
        }
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (isShutdown){
            throw new IllegalStateException("线程池已经关闭");
        }
        return this.coreSize;
    }

    @Override
    public int getQueueSize() {
        if (isShutdown){
            throw new IllegalStateException("线程池已经关闭");
        }
        return this.runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        if (isShutdown){
            throw new IllegalStateException("线程池已经关闭");
        }
        synchronized (this){
            return this.activeSize;
        }
    }

    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }


    /**
     * ThreadTask是InternalTask和Thread的结合
     */
    private static class ThreadTask{
        private final Thread thread;
        private final InternalTask internalTask;
        private ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }

    /**
     * 默认的创建线程的工厂
     */
    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
        private static final ThreadGroup GROUP = new ThreadGroup("myGroup-"+GROUP_COUNTER.getAndDecrement());
        private static final AtomicInteger COUNTE = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(GROUP,runnable,"线程-"+COUNTE.getAndDecrement());
        }
    }

}
