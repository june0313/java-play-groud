package me.jun.playground.memory;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("maxMemory: " + runtime.maxMemory() / 1024 / 1024 + " MB");
        System.out.println("freeMemory: " + runtime.freeMemory() / 1024 / 1024 + " MB");
        System.out.println("totalMemory: " + runtime.totalMemory() / 1024 / 1024 + " MB");

        ByteBuffer byteBuffer = ByteBuffer.allocate(8 * 100_000_000);

        for (long i = 0; i < 100_000_000; i++) {
            byteBuffer.putLong(i);
        }

        System.out.println("final maxMemory is " + runtime.maxMemory() / 1024 / 1024 + "mb");
        System.out.println("final freeMemory is " + runtime.freeMemory() / 1024 / 1024 + "mb");
        System.out.println("final totalMemory is " + runtime.totalMemory() / 1024 / 1024 + "mb");
        byteBuffer.flip();

        System.out.println("first value is " + byteBuffer.getLong());
        System.out.println("last value is " + byteBuffer.getLong(8 * 100_000_000 - 8));
    }
}
