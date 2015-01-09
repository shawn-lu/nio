package com.shawn.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server1 {
	public static void main(String[] args) {
		ServerSocketChannel serverSocketChannel;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(8120));

			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				ByteBuffer bf = ByteBuffer.allocate(1024);
				int num = socketChannel.read(bf);
				System.out.println(bf.limit());
				System.out.println(bf.position());
				while(bf.hasRemaining()){
					System.out.print(bf.getChar());
				}
				System.out.println("");
				System.out.print("count:"+num);
				// do something with socketChannel...
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
