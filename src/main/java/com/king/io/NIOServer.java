package com.king.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    private Selector selector ;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        new NIOServer().init(8099);
    }
    private void init(int port){
        try {
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
            while(true){
                this.selector.select();
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while(keys.hasNext()){
                    SelectionKey key = keys.next();
                    if (key.isValid()){
                        if (key.isAcceptable()){
                            accept(key);
                        }else if (key.isReadable()) {
                            read(key);
                        }else if (key.isWritable()){
                            write(key);
                        }
                    }
                }
                keys.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    private void write(SelectionKey key) throws IOException {
        this.writeBuffer.clear();
        SocketChannel channel = (SocketChannel)key.channel();
        writeBuffer.put("你好客户端".getBytes("UTF-8"));
        writeBuffer.flip();
        channel.write(writeBuffer);
        channel.register(this.selector,SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        this.readBuffer.clear();
        // 获取通道
        SocketChannel channel = (SocketChannel)key.channel();
        // 将通道中的数据读到缓存中。通道中的数据，就是客户端发送给服务器的数据。
        int readLength = channel.read(readBuffer);
        // 检查客户端是否写入数据
        if(readLength == -1){
            // 通道关闭
            key.channel().close();
            // 关闭连接
            key.cancel();
            return;
        }
        // flip,NIO中最复杂的操作就是Buffer的控制
        /** Buffer中有一个游标。游标的信息在操作后不会归零，如果直接访问Buffer的话，数据有可能不一致。
         * flip是重置游标的方法.NIO编程中，flip方法是常用的方法
         *
         */
        this.readBuffer.flip();
        // 字节数据，保存具体数据。Buffer.remaining() ->获取Buffer中有效数据长度的方法。
        byte[] datas = new byte[readBuffer.remaining()];
        // 是将Buffer中的有效数据保存到有效数组中。
        readBuffer.get(datas);
        System.out.println("from" + channel.getRemoteAddress() + " client ： " + new String(datas,"UTF-8"));
        channel.register(this.selector,SelectionKey.OP_WRITE);
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
        SocketChannel channel = serverSocketChannel.accept();
        channel.configureBlocking(false);
        // 设置对用客户端的通道标记状态,此通道为读取数据使用的。
        channel.register(this.selector,SelectionKey.OP_READ);
    }
}
