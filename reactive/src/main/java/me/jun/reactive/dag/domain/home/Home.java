package me.jun.reactive.dag.domain.home;

import me.jun.reactive.dag.domain.banner.Banner;
import me.jun.reactive.dag.domain.product.Product;
import me.jun.reactive.dag.domain.member.Member;

import java.util.List;

public record Home(Member member, List<Product> products, List<Banner> banners) {
}
