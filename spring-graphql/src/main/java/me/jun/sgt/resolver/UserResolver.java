package me.jun.sgt.resolver;

import lombok.RequiredArgsConstructor;
import me.jun.sgt.codegen.types.AddUserInput;
import me.jun.sgt.codegen.types.User;
import me.jun.sgt.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserResolver {
    private final UserService userService;

    @QueryMapping
    public User getUser(@Argument String userId) {
        return userService.getUser(userId);
    }

    @MutationMapping
    public User addUser(@Argument AddUserInput addUserInput) {
        return userService.addUser(addUserInput);
    }

}
