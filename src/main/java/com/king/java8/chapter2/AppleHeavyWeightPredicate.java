package com.king.java8.chapter2;

public class AppleHeavyWeightPredicate implements ApplePredicate<Integer>{

	@Override
	public boolean test(Integer apple) {
		return false;
	}
}
