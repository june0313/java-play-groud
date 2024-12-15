package me.jun.reactive.dag.infrastructure.dataclient;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public abstract class BlockingToReactiveDataClient<REQ, RES> implements ReactiveDataClient<REQ, RES> {
    protected abstract RES blockingGet(REQ request);

    @Override
    public Mono<RES> get(REQ request) {
        return Mono.fromCallable(() -> blockingGet(request))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
