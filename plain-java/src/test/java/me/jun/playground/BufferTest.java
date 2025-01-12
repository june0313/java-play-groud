package me.jun.playground;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static org.assertj.core.api.Assertions.*;

public class BufferTest {
    @Test
    void byteBufferTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        assertThat(byteBuffer.position()).isEqualTo(0);

        byte b = byteBuffer.get();

        assertThat(byteBuffer.position()).isEqualTo(1);
        assertThat(b).isEqualTo((byte) 0);
    }
}
