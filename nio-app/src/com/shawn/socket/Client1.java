package com.shawn.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client1 {
	public static void main(String[] args) {
		SocketChannel sc = null;
		try {
			sc = SocketChannel.open();
			sc.connect(new InetSocketAddress("192.168.8.81", 8120));
			String message = "hello world";
			ByteBuffer bf = ByteBuffer.allocate(message.length());
			bf.put(message.getBytes());
			sc.write(bf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=sc){
				try {
					sc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
