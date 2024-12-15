package me.jun.reactive.dag.domain.banner;

public record Banner(String title, String url) {
    public static Banner of(String title, String url) {
        return new Banner(title, url);
    }
}
