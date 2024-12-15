package me.jun.reactive.dag.domain.banner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jun.reactive.dag.common.DelaySimulator;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BannerRepository {
    private static final Map<Long, List<Banner>> BANNER_DB = Map.of(
            100L, List.of(Banner.of("Black Friday Sale", "https://foo.bar"), Banner.of("임직원 할인", "https://foo.bar2"))
    );

    private final DelaySimulator delaySimulator;

    public List<Banner> findBannerByMemberId(Long memberSegmentId) {
        log.info("Finding banner by segment id: {}", memberSegmentId);
        delaySimulator.delay(Duration.ofMillis(500));
        log.info("Found banner by segment id: {}", memberSegmentId);

        return BANNER_DB.get(memberSegmentId);
    }
}
