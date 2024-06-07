package com.cx.mall.common;

/**
 * 异常处理类
 *
 * @author
 * @date
 */
public class MallException extends RuntimeException {

    public MallException() {
    }

    public MallException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     *
     * @param message
     */
    public static void fail(String message) {
        throw new MallException(message);
    }
}
