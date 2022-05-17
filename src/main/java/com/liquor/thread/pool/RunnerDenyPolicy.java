package com.liquor.thread.pool;

import com.liquor.thread.pool.impl.DenyPolicy;
import com.liquor.thread.pool.impl.ThreadPool;

/**
 * 拒绝策略，使任务在提交者的线程中执行
 *
 * @author zzc
 */
public class RunnerDenyPolicy implements DenyPolicy {

    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        if (!threadPool.isShutdown()) {
            runnable.run();
        }
    }
}
