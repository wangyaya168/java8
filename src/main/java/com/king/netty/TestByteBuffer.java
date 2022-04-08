package com.king.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class TestByteBuffer {

	public static void main(String[] args) {
		
		Charset utf8 = Charset.forName("UTF-8"); 
		ByteBuf buf   = Unpooled.copiedBuffer("Netty in   Action rocks!", utf8); 
		System.out.println((char)buf.readByte()); 
		int readerIndex = buf.readerIndex(); 
		int writerIndex = buf.writerIndex(); 
		System.out.println(readerIndex);
		System.out.println(writerIndex);
		buf.writeByte((byte)'?');
		writerIndex = buf.writerIndex(); 
		System.out.println(writerIndex);
		//EventLoopGroup 
		//ChannelInitializer
	}
}
