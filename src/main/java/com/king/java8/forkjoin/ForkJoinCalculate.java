package com.king.java8.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

	private long start;
	
	private long end;

	private static final long THRESHOLD = 10000L; // 临界值

	private static final long serialVersionUID = 1L;

	public ForkJoinCalculate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		if (length <= THRESHOLD) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middle = (start + end) / 2;
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			left.fork();
			ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
			right.fork();
			return left.join() + right.join();
		}

	}

}
