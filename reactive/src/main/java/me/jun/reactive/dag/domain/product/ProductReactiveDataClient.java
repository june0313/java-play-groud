package me.jun.reactive.dag.domain.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jun.reactive.dag.common.DelaySimulator;
import me.jun.reactive.dag.infrastructure.dataclient.BlockingToReactiveDataClient;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductReactiveDataClient extends BlockingToReactiveDataClient<String, List<Product>> {
    private static final Map<Long, Product> PRODUCT_DB = Map.of(
            1L, new Product(1L, "phone", 10_000L),
            2L, new Product(2L, "macbook", 20_000L),
            3L, new Product(3L, "camera", 30_000L)
    );

    private final DelaySimulator delaySimulator;

    @Override
    protected List<Product> blockingGet(String request) {
        log.info("finding products...");
        delaySimulator.delay(Duration.ofSeconds(1));
        log.info("found products.");

        return PRODUCT_DB.values().stream().toList();
    }
}
