package me.jun.sgt.service;

import lombok.RequiredArgsConstructor;
import me.jun.sgt.codegen.types.AddUserInput;
import me.jun.sgt.codegen.types.Cart;
import me.jun.sgt.codegen.types.User;
import me.jun.sgt.repository.Database;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserService {
    private final Database database;
    private final CartService cartService;

    public User getUser(String userId) {
        return database.users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .map(user -> {
                    Cart cart = cartService.getUserCart(user.getId());
                    user.setCart(cart);
                    return user;
                }).orElseThrow(() -> new IllegalStateException("User not found"));
    }

    public User addUser(AddUserInput addUserInput) {
        User user = User.newBuilder()
                .id(UUID.randomUUID().toString().substring(0, 5))
                .name(addUserInput.getName())
                .email(addUserInput.getEmail())
                .createdAt(OffsetDateTime.now())
                .build();

        database.users.add(user);
        Cart cart = cartService.addUserCart(user);
        user.setCart(cart);

        return user;
    }

}
