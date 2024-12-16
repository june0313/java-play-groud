package me.jun.reactive.dag.domain.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jun.reactive.dag.infrastructure.dataclient.Context;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @PostMapping("/home")
    public Mono<Home> home(@RequestBody RequestContext request) {
        log.info("Http request start");
        Mono<Home> home = homeService.getHome(request, new Context());
        log.info("Http request end");

        return home;
    }
}
