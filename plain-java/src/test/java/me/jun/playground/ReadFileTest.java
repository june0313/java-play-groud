package me.jun.playground;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileTest {
    @Test
    void readFile() {
        try(InputStream inputStream = ReadFileTest.class.getClassLoader().getResourceAsStream ("5MB.json")) {
            if (inputStream == null) {
                System.out.println("File is not found");
            }

            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
