package me.jun.sgt.resolver;

import lombok.RequiredArgsConstructor;
import me.jun.sgt.codegen.types.AddCartItemInput;
import me.jun.sgt.codegen.types.Cart;
import me.jun.sgt.codegen.types.DeleteCartItemInput;
import me.jun.sgt.service.CartService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CartResolver {
    private final CartService cartService;

    @QueryMapping
    public Cart getUserCart(@Argument String userId) {
        return cartService.getUserCart(userId);
    }

    @MutationMapping
    public Cart addCartItem(@Argument AddCartItemInput addCartItemInput) {
        return cartService.addCartItem(addCartItemInput);
    }

    @MutationMapping
    public Cart deleteCartItem(@Argument DeleteCartItemInput deleteCartItemInput) {
        return cartService.deleteCartItem(deleteCartItemInput);
    }
}
