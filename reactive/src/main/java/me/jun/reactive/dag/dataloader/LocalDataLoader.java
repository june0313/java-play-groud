package me.jun.reactive.dag.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LocalDataLoader {
    private final ObjectMapper objectMapper;

    private List<User> users;

    @PostConstruct
    public void init() {
        loadLocalFile();
        log.info("File loaded from init()");
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void load() {
        loadLocalFile();
        log.info("File loaded from load()");
    }

    private void loadLocalFile() {
        try (InputStream inputStream = getClass().getResourceAsStream("/40mb.json")) {
            if (inputStream == null) {
                throw new FileNotFoundException("file not found");
            }

            users = objectMapper.readValue(inputStream, new TypeReference<>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
