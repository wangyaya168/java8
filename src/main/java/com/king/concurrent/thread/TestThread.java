package com.king.concurrent.thread;

public class TestThread {

	public static void main(String[] args) {
		ThreadLocal threadLocal = new ThreadLocal();
		threadLocal.set("A thread local value");
		threadLocal.set("A new value");
		String threadLocalValue = (String)threadLocal.get();
		System.out.println(threadLocalValue);
		
	}
	
}
