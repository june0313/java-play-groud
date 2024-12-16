package me.jun.reactive.dag.infrastructure.dataclient;

import reactor.core.publisher.Mono;

public interface ReactiveDataClient<REQ, RES> {
    Mono<RES> get(REQ request, Context context);
}
