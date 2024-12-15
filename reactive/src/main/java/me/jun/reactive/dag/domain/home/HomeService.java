package me.jun.reactive.dag.domain.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jun.reactive.dag.domain.banner.Banner;
import me.jun.reactive.dag.domain.banner.BannerService;
import me.jun.reactive.dag.domain.member.Member;
import me.jun.reactive.dag.domain.member.MemberService;
import me.jun.reactive.dag.domain.product.Product;
import me.jun.reactive.dag.domain.product.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple3;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeService {
    private final MemberService memberService;
    private final ProductService productService;
    private final BannerService bannerService;

    public Mono<Home> getHome() {
        return Mono.zip(
                        memberService.getMember(),
                        productService.getProducts(),
                        bannerService.getBanners()
                )
                .publishOn(Schedulers.parallel())
                .map(this::aggregate);
    }

    private Home aggregate(Tuple3<Member, List<Product>, List<Banner>> tuple) {
        log.info("Aggregate Home data");

        var member = tuple.getT1();
        var products = tuple.getT2();
        var banners = tuple.getT3();

        return new Home(member, products, banners);
    }

}
