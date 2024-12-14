package me.jun.playground.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharIOExample01 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
