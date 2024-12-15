package me.jun.reactive.dag.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public Mono<Member> member(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }
}
