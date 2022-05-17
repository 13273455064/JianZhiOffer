package com.liquor.thread.pool;

import com.liquor.thread.pool.exception.RunnableDenyException;
import com.liquor.thread.pool.impl.DenyPolicy;
import com.liquor.thread.pool.impl.ThreadPool;

/**
 * 拒绝策略，向任务提交者抛出异常
 *
 * @author zzc
 */
public class AbortDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        throw new RunnableDenyException("任务 " + runnable + " 将被终止！");
    }
}
