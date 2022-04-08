package com.king.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8080);
		new Thread(() ->  {
			while(true) {
				try {
					Socket socket = serverSocket.accept();
					new Thread(() -> {
						try {
							byte[] a = new byte[1024];
							InputStream is = socket.getInputStream();
							while(true) {
								int len;
								while((len = is.read(a)) != -1) {
									System.out.println(new String(a, 0, len));
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}).start();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}).start();;
	}

}
