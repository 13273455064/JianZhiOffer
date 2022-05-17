package com.liquor.thread.pool.exception;

/**
 * 线程池异常
 *
 * @author zzc
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String massage) {
        super(massage);
    }
}
