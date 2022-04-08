package com.king.proxy;

public class RealSubject implements Subject{
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
