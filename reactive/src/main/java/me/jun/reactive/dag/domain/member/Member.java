package me.jun.reactive.dag.domain.member;

public record Member(Long id, String name, Long segmentId) {
    public static Member of(Long id, String name, Long segmentId) {
        return new Member(id, name, segmentId);
    }
}
