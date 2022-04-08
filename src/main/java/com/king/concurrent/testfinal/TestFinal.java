package com.king.concurrent.testfinal;

public class TestFinal {

	final int[] arrays;
	private TestFinal testFinal;
	public TestFinal() {
		arrays = new int[1];
		arrays[0] = 1;
	}
	public void writerOne() {
		testFinal = new TestFinal();
	}
	public void writerTwo() {
		arrays[0] = 2;
	}
	public void reader() {
		if (testFinal != null) {
			int temp = testFinal.arrays[0];
		}
	}
	public static void main(String[] args) {
		

	}

}
