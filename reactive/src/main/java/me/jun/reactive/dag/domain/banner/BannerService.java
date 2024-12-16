package me.jun.reactive.dag.domain.banner;

import lombok.RequiredArgsConstructor;
import me.jun.reactive.dag.domain.member.MemberService;
import me.jun.reactive.dag.infrastructure.dataclient.Context;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerService {
    private final MemberService memberService;
    private final BannerReactiveDataClient bannerReactiveDataClient;

    public Mono<List<Banner>> getBanners(Long memberId, Context context) {
        return memberService.getMember(memberId, context)
                .flatMap(member -> bannerReactiveDataClient.get(member.segmentId(), context));
    }
}
