package me.jun.sgt.service;

import jakarta.annotation.PostConstruct;
import me.jun.sgt.model.Coffee;
import me.jun.sgt.model.Size;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoffeeService {

    private final List<Coffee> coffees = new ArrayList<>();

    @PostConstruct
    public void init() {
        Size smallSize = new Size(1, "작은 사이즈");
        Size mediumSize = new Size(2, "중간 사이즈");
        Size largeSize = new Size(3, "큰 사이즈");

        coffees.add(new Coffee(1, "에스프레소", smallSize));
        coffees.add(new Coffee(2, "라떼", mediumSize));
        coffees.add(new Coffee(3, "카푸치노", largeSize));
    }

    public List<Coffee> getAllCoffees() {
        return coffees;
    }

    public Coffee getCoffeeById(int id) {
        return coffees.stream()
                .filter(coffee -> coffee.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

