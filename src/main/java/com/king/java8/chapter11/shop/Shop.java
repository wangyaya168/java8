package com.king.java8.chapter11.shop;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Shop {

	private static Random random = new Random();
	
	private String name;
	
	public static List<Shop> shops = Arrays.asList(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"),
			new Shop("BuyItAll"),new Shop("BuyItAll11"),new Shop("BestPrice"), new Shop("LetsSaveBig"));
	
	public Shop(String name) {
		super();
		this.name = name;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static void delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public double getPrice(String product) {
//		return calculatePrice(product);
//	}

	public String getPrice(String product) {
		 double price = calculatePrice(product);
		 Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
		 return String.format("%s:%.2f:%s", name, price, code);
	}
	public Future<Double> getPriceAsync(String product){
//		CompletableFuture<Double> futurePrice = new CompletableFuture<Double>();
//		new Thread(()->{
//			double price = calculatePrice(product);
//			futurePrice.complete(price);
//			
//		}).start();
//		return futurePrice;
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
	private double calculatePrice(String product) {
		delay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}
	
	public List<String> findPrices(String product){
		return shops.parallelStream().map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
	}
}
