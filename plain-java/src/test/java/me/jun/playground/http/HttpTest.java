package me.jun.playground.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

import static java.lang.System.out;

public class HttpTest {
    @Test
    void test_sync() throws URISyntaxException, IOException, InterruptedException {
        try (var client = HttpClient.newBuilder().build()) {
            var uri = new URI("https://google.com");
            var request = HttpRequest.newBuilder(uri).build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));

            out.println(response.body());
        }
    }

    @Test
    void test_async() throws URISyntaxException {
        try (var client = HttpClient.newBuilder().build()) {
            var uri = new URI("https://google.com");
            var request = HttpRequest.newBuilder(uri).build();

            var handler = HttpResponse.BodyHandlers.ofString(Charset.defaultCharset());

            var completableFuture = CompletableFuture.allOf(
                    client.sendAsync(request, handler).thenAccept(resp -> out.println(resp.body())),
                    client.sendAsync(request, handler).thenAccept(resp -> out.println(resp.body())),
                    client.sendAsync(request, handler).thenAccept(resp -> out.println(resp.body()))
            );

            completableFuture.join();

        }
    }
}
