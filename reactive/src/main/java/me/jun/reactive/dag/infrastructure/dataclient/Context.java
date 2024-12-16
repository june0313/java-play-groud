package me.jun.reactive.dag.infrastructure.dataclient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Context {
    private final Map<Class<?>, Mono<?>> cache = new ConcurrentHashMap<>();

    public Mono<?> get(Class<?> clazz) {
        return cache.get(clazz);
    }

    public void put(Class<?> clazz, Mono<?> mono) {
        cache.put(clazz, mono);
    }
}
