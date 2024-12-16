package me.jun.reactive.dag.infrastructure.dataclient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Context {
    private final Map<Class<?>, Mono<?>> cache = new ConcurrentHashMap<>();

    public Mono<?> fromCacheIfAbsent(Class<?> clazz, Mono<?> mono) {
        return this.cache.computeIfAbsent(clazz, k -> mono);
    }
}
