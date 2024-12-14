package me.jun.playground.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteExam1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try (
                FileInputStream fis = new FileInputStream("plain-java/src/main/java/me/jun/playground/io/ByteExam1.java");
                FileOutputStream fos = new FileOutputStream("byte.text")
        ) {
            int readData;

            while ((readData = fis.read()) != -1) {
                fos.write(readData);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("duration : " + (endTime - startTime));
    }
}
