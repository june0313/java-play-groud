package me.jun.reactive.dag.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jun.reactive.dag.common.DelaySimulator;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private static final Map<Long, Member> MEMBER_DB = Map.of(
            1L, Member.of(1L, "wayne", 100L)
    );

    private final DelaySimulator delaySimulator;

    public Member findMember() {
        log.info("finding member...");
        delaySimulator.delay(Duration.ofSeconds(1L));
        log.info("found member.");

        return MEMBER_DB.get(1L);
    }

}
