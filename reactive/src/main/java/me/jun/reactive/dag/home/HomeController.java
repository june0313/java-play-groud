package me.jun.reactive.dag.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/home")
    public Mono<Home> home() {
        log.info("Http request start");
        Mono<Home> home = homeService.getHome();
        log.info("Http request end");

        return home;
    }
}
