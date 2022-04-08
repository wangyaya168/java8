package com.king.java8.chapter2;

public class AppleGreenColorPredicate implements ApplePredicate<Apple>{

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}
}
