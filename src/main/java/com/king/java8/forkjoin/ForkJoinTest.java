package com.king.java8.forkjoin;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {

	public static void test1() {
		long start = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);
		long sum = pool.invoke(task);
		System.out.println(sum);

		long end = System.currentTimeMillis();

		System.out.println("耗费的时间为: " + (end - start));
	}

	public static void main(String[] args) {
		test2();
	}

	public static void test2() {
		long start = System.currentTimeMillis();
		long sum = 0L;
		for (long i = 0L; i <= 10000000000L; i++) {
			sum += i;
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println("耗费的时间为: " + (end - start)); // 34-3174-3132-4227-4223-31583 }
	}

	public void test3() {
		long start = System.currentTimeMillis();
		Long sum = LongStream.rangeClosed(0L, 10000000000L).parallel().sum();
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println("耗费的时间为: " + (end - start)); // 2061-2053-2086-18926 }
	}

}
