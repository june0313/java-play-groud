package me.jun.playground.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteExam1 {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("src/main/java/me/jun/playground/io/ByteExam1.java");
                FileOutputStream fos = new FileOutputStream("byte.text")
        ) {
            int readData;

            while ((readData = fis.read()) != -1) {
                System.out.println(readData);
                fos.write(readData);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
