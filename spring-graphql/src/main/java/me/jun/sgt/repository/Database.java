package me.jun.sgt.repository;

import me.jun.sgt.codegen.types.*;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Database {
    public final List<Product> products;
    public final List<User> users;
    public final List<Cart> carts;
    public final List<CartItem> cartItems;

    public Database() {

        products = new ArrayList<>(List.of(
                Electronics.newBuilder().id("1").productType(ProductType.ELECTRONICS).name("mac book air").price(1000.0).warrantyPeriod("3years").build(),
                Electronics.newBuilder().id("2").productType(ProductType.ELECTRONICS).name("iphone 19").price(2000.0).warrantyPeriod("2years").build(),
                Electronics.newBuilder().id("3").productType(ProductType.ELECTRONICS).name("samsung tv").price(3000.0).warrantyPeriod("1years").build(),
                Clothing.newBuilder().id("4").productType(ProductType.CLOTHING).name("T-shirt").price(300.0).size("M").build(),
                Clothing.newBuilder().id("5").productType(ProductType.CLOTHING).name("Jeans").price(200.0).size("L").build(),
                Clothing.newBuilder().id("6").productType(ProductType.CLOTHING).name("Dress").price(100.0).size("S").build()
        ));

        users = new ArrayList<>(List.of(
                User.newBuilder().id("1").name("Burger").email("burger@goopang.com").createdAt(OffsetDateTime.now().minusDays(30)).build(),
                User.newBuilder().id("2").name("Jane").email("jane@goopang.com").createdAt(OffsetDateTime.now().minusDays(60)).build()
        ));

        carts = new ArrayList<>(List.of(
                Cart.newBuilder().id("1").user(users.get(0)).build(),
                Cart.newBuilder().id("1").user(users.get(1)).build()
        ));

        cartItems = new ArrayList<>(List.of(
                CartItem.newBuilder().id("1").quantity(1).product(products.get(0)).cart(carts.get(0)).build(),
                CartItem.newBuilder().id("2").quantity(3).product(products.get(2)).cart(carts.get(0)).build(),
                CartItem.newBuilder().id("3").quantity(2).product(products.get(4)).cart(carts.get(0)).build(),
                CartItem.newBuilder().id("4").quantity(1).product(products.get(5)).cart(carts.get(1)).build(),
                CartItem.newBuilder().id("5").quantity(2).product(products.get(1)).cart(carts.get(1)).build()
        ));
    }
}
