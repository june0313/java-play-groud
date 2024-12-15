package me.jun.reactive.dag.member;

public record Member(Long id, String name) {
    public static Member of(Long id, String name) {
        return new Member(id, name);
    }
}
