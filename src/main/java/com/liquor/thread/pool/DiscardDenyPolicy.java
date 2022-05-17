package com.liquor.thread.pool;

import com.liquor.thread.pool.impl.DenyPolicy;
import com.liquor.thread.pool.impl.ThreadPool;

/**
 * 拒绝策略，抛弃提交的任务
 *
 * @author zzc
 */
public class DiscardDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        System.out.println("抛弃了提交的任务");
    }
}
