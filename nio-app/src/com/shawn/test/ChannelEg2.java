package com.shawn.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelEg2 {
	public static void main(String[] args) {
		try {
			RandomAccessFile fromFile = new RandomAccessFile("data/fromFile.txt", "rw");
			FileChannel      fromChannel = fromFile.getChannel();

			RandomAccessFile toFile = new RandomAccessFile("data/toFile.txt", "rw");
			FileChannel      toChannel = toFile.getChannel();
			
			long position = 1;
			long count = fromChannel.size();
			//µ±toChannel.sizeÎª0Ê±£¬
//			long num = toChannel.transferFrom(fromChannel,position, count);
			long num2 = fromChannel.transferTo(position, count, toChannel);
			System.out.println(num2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
