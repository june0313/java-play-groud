package me.jun.reactive.dag.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Mono<List<Product>> getProducts() {
        return Mono.fromCallable(productRepository::findProducts)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
