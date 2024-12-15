package me.jun.reactive.dag.domain.banner;

import lombok.RequiredArgsConstructor;
import me.jun.reactive.dag.domain.member.MemberService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerService {
    private final MemberService memberService;
    private final BannerRepository bannerRepository;

    public Mono<List<Banner>> getBanners() {
        return memberService.getMember()
                .map(member -> bannerRepository.findBannerByMemberId(member.segmentId()));
    }
}
