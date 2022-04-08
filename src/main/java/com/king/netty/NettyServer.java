package com.king.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

	public static void main(String[] args) {

		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(new NioEventLoopGroup(),new NioEventLoopGroup())
		.channel(NioServerSocketChannel.class)
		.childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
			ChannelFuture connectFuture;
			@Override
			public void channelActive(ChannelHandlerContext ctx) throws Exception {
				Bootstrap bootstrap = new Bootstrap();
			}

			@Override
			protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
				
				
			}
		});
	}

}
