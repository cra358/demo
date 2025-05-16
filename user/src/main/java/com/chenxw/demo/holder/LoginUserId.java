package com.chenxw.demo.holder;

import java.util.Objects;

public class LoginUserId {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    /**
     * 设置用户 ID
     *
     * @param value
     */
    public static void setUserId(String value) {
        threadLocal.set(value);
    }

    /**
     * 获取用户 ID
     *
     * @return
     */
    public static Long getUserId() {
        String value = threadLocal.get();
        if (Objects.isNull(value)) {
            return null;
        }
        return Long.valueOf(value.toString());
    }

    /**
     * 删除 ThreadLocal
     */
    public static void remove() {
        threadLocal.remove();
    }

}
