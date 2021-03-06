package com.king.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

	private final int port;

	public EchoServer(int port) {
		super();
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		
		new EchoServer(8900).start();
	}

	public void start() throws Exception {
		final EchoServerHandler serverHandler = new EchoServerHandler();
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group)
			 .channel(NioServerSocketChannel.class)
			 .localAddress(new InetSocketAddress(port))
			 .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
			 .childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(serverHandler);
				}
			});
			ChannelFuture f = b.bind().sync();
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}
