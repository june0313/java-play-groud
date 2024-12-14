package me.jun.playground.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteExam2 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try (
                FileInputStream fis = new FileInputStream("plain-java/src/main/java/me/jun/playground/io/ByteExam1.java");
                FileOutputStream fos = new FileOutputStream("byte2.text")
        ) {
            int readCount;
            byte[] buffer = new byte[512];
            while ((readCount = fis.read(buffer)) != -1) {
                System.out.println("Read " + readCount + " bytes");
                fos.write(buffer, 0, readCount);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("duration : " + (endTime - startTime));
    }
}
