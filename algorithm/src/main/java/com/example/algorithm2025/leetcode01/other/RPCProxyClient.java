package com.example.algorithm2025.leetcode01.other;

import java.lang.reflect.Method;

public class RPCProxyClient implements java.lang.reflect.InvocationHandler{

    private Object obj;
    public RPCProxyClient(Object obj){
        this.obj = obj;
    }

    /**
     * 得到被代理对象;
     * @param obj
     * @return
     */
    public static Object getProxy(Object obj){
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new RPCProxyClient(obj));
    }

    /**
     * 调用此方法执行
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //结果参数;
        Object result = new Object();
        // ...执行通信相关逻辑
        // ...
        return result;
    }
}
