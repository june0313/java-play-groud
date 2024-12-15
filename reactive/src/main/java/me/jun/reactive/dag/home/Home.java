package me.jun.reactive.dag.home;

import me.jun.reactive.dag.member.Member;
import me.jun.reactive.dag.product.Product;

import java.util.List;

public record Home(Member member, List<Product> products) {
}
