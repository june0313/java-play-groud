package me.jun.sgt.service;

import lombok.RequiredArgsConstructor;
import me.jun.sgt.codegen.types.*;
import me.jun.sgt.repository.Database;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CartService {
    private final Database database;
    private final ProductService productService;

    public Cart addCartItem(AddCartItemInput input) {
        CartItem cartItem = CartItem.newBuilder()
                .id(UUID.randomUUID().toString().substring(0, 5))
                .quantity(input.getQuantity())
                .product(productService.getProduct(input.getProductId()))
                .cart(getUserCart(input.getUserId()))
                .build();

        database.cartItems.add(cartItem);

        return getUserCart(input.getUserId());
    }

    public Cart deleteCartItem(DeleteCartItemInput input) {
        database.cartItems.removeIf(cartItem -> cartItem.getId().equals(input.getCartItemId()));
        return getUserCart(input.getUserId());
    }

    public Cart addUserCart(User user) {
        Cart cart = Cart.newBuilder()
                .id(UUID.randomUUID().toString().substring(0, 5))
                .user(user)
                .build();

        database.carts.add(cart);

        return cart;
    }

    public Cart getUserCart(String userId) {
        return database.carts.stream()
                .filter(cart -> cart.getUser().getId().equals(userId))
                .findFirst()
                .map(cart -> {
                    var cartItems = getCartItems(cart);
                    var totalAmount = calculateTotalAmount(cartItems);

                    cart.setItems(cartItems);
                    cart.setTotalAmount(totalAmount);

                    return cart;
                }).orElseThrow(() -> new IllegalStateException("Cart not found for user " + userId));
    }

    private static double calculateTotalAmount(List<CartItem> cartItems) {
        return cartItems.stream()
                .mapToDouble(cartItem -> cartItem.getQuantity() * cartItem.getProduct().getPrice())
                .sum();
    }

    private List<CartItem> getCartItems(Cart cart) {
        return database.cartItems.stream()
                .filter(cartItem -> cartItem.getId().equals(cart.getId()))
                .toList();
    }
}
