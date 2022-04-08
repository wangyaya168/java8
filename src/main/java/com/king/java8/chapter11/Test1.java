package com.king.java8.chapter11;

import java.math.BigDecimal;

public class Test1 {

	public static void main(String[] args) {
		int a = 3;
		if (a < 3) {
			System.out.println("aa");
			
		} else if (a < 4) {
			System.out.println("bb");
		}
	}
	
	public static String underscoreName(String name) {
	    StringBuilder result = new StringBuilder();
	     if (name != null && name.length() > 0) {
	         // 将第一个字符处理成大写
	         result.append(name.substring(0, 1).toUpperCase());
	        // 循环处理其余字符
	        for (int i = 1; i < name.length(); i++) {
	           String s = name.substring(i, i + 1);
	             // 在大写字母前添加下划线
             if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
	                result.append("_");
	            }
	             // 其他字符直接转成大写
             result.append(s.toUpperCase());
	         }
	    }
	     return result.toString().toLowerCase();
	 }

}
