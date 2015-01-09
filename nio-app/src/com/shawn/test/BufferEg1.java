package com.shawn.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferEg1 {
	public static void main(String[] args) {
		try {
			RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
			FileChannel inChannel = aFile.getChannel();

			// create buffer with capacity of 48 bytes
			ByteBuffer buf = ByteBuffer.allocate(48);

			int bytesRead = inChannel.read(buf); // read into buffer.
			
			while (bytesRead != -1) {

				buf.flip(); // make buffer ready for read

				while (buf.hasRemaining()) {
					System.out.print((char) buf.get()); // read 1 byte at a time
				}

				buf.clear(); // make buffer ready for writing
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
