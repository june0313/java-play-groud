package me.jun.reactive.dag.domain.member;

import lombok.RequiredArgsConstructor;
import me.jun.reactive.dag.infrastructure.dataclient.Context;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberReactiveDataClient memberReactiveDataClient;

    public Mono<Member> getMember(Long memberId, Context context) {
        return memberReactiveDataClient.get(memberId, context);
    }
}
