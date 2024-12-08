package me.jun.playground.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamExam {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"))) {
            int i = dis.readInt();
            boolean b = dis.readBoolean();
            double d = dis.readDouble();

            System.out.println("i = " + i);
            System.out.println("b = " + b);
            System.out.println("d = " + d);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
