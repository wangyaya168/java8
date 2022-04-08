package com.king.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
//		Future<String> future = executorService.submit(new Callable<String>() {
//			@Override
//			public String call() throws Exception {
//				return "通过实现Callable接口";
//			}
//		});
//		System.out.println(future.get());
		Thread sleepThread = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				super.run();
			}
		};
		
		Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true) ;
            }
        };
        
        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while (sleepThread.isInterrupted()) ;
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
        
        
        
	}
}
