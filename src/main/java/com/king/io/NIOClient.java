package com.king.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {

	public static void main(String[] args) throws Exception {
		Selector serverSelector = Selector.open();
		Selector clientSelector = Selector.open();
		new Thread(() -> {
			try {
				ServerSocketChannel listenChannel = ServerSocketChannel.open();
				listenChannel.socket().bind(new InetSocketAddress(8000));
				listenChannel.configureBlocking(false);
				listenChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
				while (true) {
					if (serverSelector.select(1) > 0) {
						Set<SelectionKey> set = serverSelector.selectedKeys();
						Iterator<SelectionKey> iterator = set.iterator();
						while (iterator.hasNext()) {
							SelectionKey key = iterator.next();
							if (key.isAcceptable()) {
								try {
									SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
									clientChannel.configureBlocking(false);
									clientChannel.register(clientSelector, SelectionKey.OP_READ);
								} finally {
									iterator.remove();
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		//----------
		new Thread(() -> {
			try {
				while(true) {
					//批量轮询是否有哪些连接有数据可读，这里的1指的是阻塞的时间为1ms
					if (clientSelector.select(1) > 0) {
						Set<SelectionKey> set = clientSelector.selectedKeys();
						Iterator<SelectionKey> keyIterator = set.iterator();
						while(keyIterator.hasNext()) {
							SelectionKey key = keyIterator.next();
							if (key.isReadable()) {
								 SocketChannel clientChannel = (SocketChannel) key.channel();
								 ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
								 //(3) 读取数据以块为单位批量读取
								 clientChannel.read(byteBuffer);
								 byteBuffer.flip();
                                 System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer)
                                         .toString());
                                 //ConcurrentHashMap
							}
						}
					}
				}
			}catch(Exception e) {
			}finally {
				
			}
		}).start(); ;
	}

}
