package com.king.java8.chapter2;

import java.util.Arrays;
import java.util.List;

public class Apple {

	private String name;

	private String color;

	private int weight;
	
	public Apple(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}
	
	public Apple(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public static List<Apple> getApples(){
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), 
				new Apple(155, "green"),new Apple(120, "red"));
		return inventory;
	}

	@Override
	public String toString() {
		return "Apple [name=" + name + ", color=" + color + ", weight=" + weight + "]";
	}
	
}
