package com.king.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock {

	private Lock lock = new ReentrantLock();


	public void insert(Thread thread) throws InterruptedException {
		lock.lock();
		try {
			System.out.println(thread.getName() + "得到了锁");
			long startTime = System.currentTimeMillis();
			for (;;) {
				if (System.currentTimeMillis() - startTime >= 3000)
					break;
				// 插入数据
			}
		} finally {
			System.out.println(Thread.currentThread().getName() + "执行finally");
			lock.unlock();
			System.out.println(thread.getName() + "释放了锁");
		}

	}

	public static void main(String[] args) {
		TestLock testLock = new TestLock();
		MyThread thread1 = new MyThread(testLock);
		MyThread thread2 = new MyThread(testLock);
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.interrupt();
	}

}

class MyThread extends Thread {
	private TestLock testLock = null;

	public MyThread(TestLock testLock) {
		super();
		this.testLock = testLock;
	}

	@Override
	public void run() {
		try {
			testLock.insert(Thread.currentThread());
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + "被中断");
		}
	}
}
