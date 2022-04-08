package com.king.java8.chapter13;

import java.io.File;
import java.io.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) throws ParseException {
		String separator = ",";
		Arrays.asList("a","b","c").forEach((String e) -> System.out.println(e + separator));
		
		
	}
}
