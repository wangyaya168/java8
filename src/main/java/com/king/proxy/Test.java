package com.king.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) throws Exception {
        Subject target = new RealSubject();
        int[] a = new int[2];
        InvocationHandler handler = new ProxySubject(target);
        Subject subject = (Subject) Proxy.newProxyInstance(target.getClass().getClassLoader(), RealSubject.class.getInterfaces(),handler);
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{target.getClass()});
        FileOutputStream os = new FileOutputStream("E://$proxy0.class");
        os.write(bytes);
        subject.sayHello();
        System.out.println(subject.getClass().getName());
    }
}
