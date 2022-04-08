package com.king.java8.chapter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("aaaa", new Apple("aa","read"));
		System.out.println(map);
	}
}
