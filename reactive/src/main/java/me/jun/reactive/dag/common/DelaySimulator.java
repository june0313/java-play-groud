package me.jun.reactive.dag.common;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class DelaySimulator {
    public void delay(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
