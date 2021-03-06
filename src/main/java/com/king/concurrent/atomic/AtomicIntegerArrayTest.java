package com.king.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

	private final static AtomicIntegerArray ATOMIC_INTEGER_ARRAY = new AtomicIntegerArray(10);
	public static void main(String[] args) throws Exception {

		Thread[] threads = new Thread[100];
		for (int i = 0; i < 100; i++) {
			final int index = i % 10;
			System.out.println("你好：index + 1:" + (index + 1));
			final int threadNum = i;
			threads[i] = new Thread() {
				public void run() {
					int result = ATOMIC_INTEGER_ARRAY.addAndGet(index, index + 1);
					System.out.println("线程编号：" + threadNum + "；对应的原始值为：" + 
					(index + 1) + ",增加后的结果为：" + result);
				}
			};
			threads[i].start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println("=====执行完成");
		for(int i = 0; i < ATOMIC_INTEGER_ARRAY.length(); i++) {
			System.out.println(ATOMIC_INTEGER_ARRAY.get(i));
		}
	}

}
