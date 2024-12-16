package me.jun.reactive.dag.infrastructure.dataclient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Objects;

@Slf4j
public abstract class BlockingToReactiveDataClient<REQ, RES> implements ReactiveDataClient<REQ, RES> {
    protected abstract RES blockingGet(REQ request);

    @Override
    public Mono<RES> get(REQ request, Context context) {

        //FIXME : 강제 캐스팅을 어떻게 없앨 수 있을까?
        Mono<RES> mono = (Mono<RES>) context.get(getClass());

        if (Objects.isNull(mono)) {
            mono = Mono.fromCallable(() -> blockingGet(request))
                    .subscribeOn(Schedulers.boundedElastic())
                    .cache();

            context.put(getClass(), mono);
        }

        return mono;
    }
}
