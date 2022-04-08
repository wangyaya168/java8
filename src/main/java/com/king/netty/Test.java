package com.king.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

public class Test {

	public static void main(String[] args) {
		//负责处理客户端的连接，认证等
		poolDirectMemory();
		directMemory();
	}

	private static void poolDirectMemory() {
		int loop = 3000000;
		long startTime = System.currentTimeMillis();
		ByteBuf poolBuffer = null;
		for (int i = 0; i < loop; i++) {
			poolBuffer = PooledByteBufAllocator.DEFAULT.directBuffer(1024);
			poolBuffer.writeByte(123456);
			poolBuffer.release();
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
	private static void directMemory() {
		int loop = 3000000;
		long startTime = System.currentTimeMillis();
		ByteBuf poolBuffer = null;
		for (int i = 0; i < loop; i++) {
			poolBuffer = Unpooled.directBuffer(1024);
			poolBuffer.writeByte(123456);
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
