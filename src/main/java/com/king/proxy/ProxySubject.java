package com.king.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler {

    private Object target;
    public ProxySubject(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object object = method.invoke(target,args);
        System.out.println("调用后");
        return object;
    }
}
