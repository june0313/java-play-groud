package me.jun.playground.collection;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;


public class CollectionFactoryTest {
    @Test
    void map_test() {
        var map = Map.ofEntries(
                entry("key1", "value1"),
                entry("key2", "value2")
        );

        assertThat(map)
                .isEqualTo(
                        Map.of(
                                "key1", "value1",
                                "key2", "value2"
                        )
                );
    }
}
