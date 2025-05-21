package com.example.readnode.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ReadService {

    private final WebClient webClient;

    public ReadService() {
        this.webClient = WebClient.builder().build();
    }

    public String getValue(String key) {

        String storageNodeUrl = "http://storage-node/storage/" + key;

        return webClient.get()
                .uri(storageNodeUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
