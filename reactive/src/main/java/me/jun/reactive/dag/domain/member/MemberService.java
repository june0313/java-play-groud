package me.jun.reactive.dag.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Mono<Member> getMember() {
        return Mono.fromCallable(memberRepository::findMember)
                .subscribeOn(Schedulers.boundedElastic());
    }

}
