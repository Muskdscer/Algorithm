package com.example.algorithm.designPattern.callback;

public interface Callback<T> {
    /**
     * 具体实现
     * @param t
     */
    public void callback(T t);
}
