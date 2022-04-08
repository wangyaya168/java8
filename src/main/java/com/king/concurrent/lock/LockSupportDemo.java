package com.king.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			LockSupport.park();
			System.out.println(Thread.currentThread()+ "被唤醒");
		});
		thread.start();
		Thread.sleep(3000);
		LockSupport.unpark(thread);
	}

}
