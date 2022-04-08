package com.king.hutool;

import java.util.Optional;

public class Test {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Optional<String> wrapped = Optional.of("aString");
		if (wrapped.isPresent()) {
			System.out.println("Got string - " + wrapped.get());
		} else {
			System.out.println("Gotcha!");
		}
	}
}
