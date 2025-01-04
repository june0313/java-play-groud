package me.jun.sgt.controller;

import lombok.RequiredArgsConstructor;
import me.jun.sgt.model.Coffee;
import me.jun.sgt.service.CoffeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GraphQLController {
    private final CoffeeService coffeeService;

    @QueryMapping
    public String hello() {
        return "Hello, GraphQL!";
    }

    /*
    매핑 조건
    1. 메서드 이름을 쿼리와 동일하게 작성한다.
    2. @QueryMapping 어노테이션의 name 또는 value 값을 쿼리와 동일하게 설정한다.
     */
    @QueryMapping(value = "getCoffeeById")
    public Coffee getCoffeeById(@Argument int id) {
        return coffeeService.getCoffeeById(id);
    }

    @QueryMapping
    public List<Coffee> getAllCoffees() {
        return coffeeService.getAllCoffees();
    }

}
