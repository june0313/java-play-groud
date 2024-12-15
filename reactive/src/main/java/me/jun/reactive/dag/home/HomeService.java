package me.jun.reactive.dag.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jun.reactive.dag.member.Member;
import me.jun.reactive.dag.member.MemberService;
import me.jun.reactive.dag.product.Product;
import me.jun.reactive.dag.product.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeService {
    private final MemberService memberService;
    private final ProductService productService;

    public Mono<Home> getHome() {
        return Mono.zip(
                        memberService.getMember(),
                        productService.getProducts())
                .publishOn(Schedulers.parallel())
                .map(this::aggregate);
    }

    private Home aggregate(Tuple2<Member, List<Product>> tuple) {
        log.info("Aggregate Home data");

        var member = tuple.getT1();
        var products = tuple.getT2();

        return new Home(member, products);
    }

}
