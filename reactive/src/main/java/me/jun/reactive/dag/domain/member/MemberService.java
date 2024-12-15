package me.jun.reactive.dag.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberReactiveDataClient memberReactiveDataClient;

    public Mono<Member> getMember(Long memberId) {
        return memberReactiveDataClient.get(memberId);
    }
}
