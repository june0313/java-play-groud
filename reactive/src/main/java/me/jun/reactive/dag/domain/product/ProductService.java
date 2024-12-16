package me.jun.reactive.dag.domain.product;

import lombok.RequiredArgsConstructor;
import me.jun.reactive.dag.infrastructure.dataclient.Context;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductReactiveDataClient productReactiveDataClient;

    public Mono<List<Product>> getProducts(String query, Context context) {
        return productReactiveDataClient.get(query, context);
    }
}
