package com.king.java8.chapter11.shop;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class ShopTest {
	public static void main(String[] args) {
		final Executor executor = Executors.newFixedThreadPool(Math.min(Shop.shops.size(),100), new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setDaemon(true);
				return thread;
			}
		});
		System.out.println(Runtime.getRuntime().availableProcessors());
		long start = System.nanoTime(); 
//		System.out.println(new Shop("").findPrices("myPhone27S")); 
//		System.out.println("Done in " + duration + " msecs");
		List<CompletableFuture<String>> futurePrice = Shop.shops.stream().map(shop ->CompletableFuture.supplyAsync(()->
			String.format("%s price is %.2f",shop.getName(), shop.getPrice("myPhone27S")),executor
		)).collect(Collectors.toList());
		System.out.println("aaa");
		List<String> listString = futurePrice.stream().map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println(listString);
		long duration = (System.nanoTime() - start) / 1_000_000; 
		System.out.println("Done in " + duration + " msecs");
	}
}
