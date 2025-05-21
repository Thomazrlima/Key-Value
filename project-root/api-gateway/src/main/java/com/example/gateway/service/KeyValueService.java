package com.example.gateway.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class KeyValueService {

    private final WebClient webClient;

    public KeyValueService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> getValue(String key) {
        return webClient.get()
                .uri("http://read-node/keyvalue/{key}", key)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> putValue(String key, String value) {
        return webClient.put()
                .uri("http://storage-node/keyvalue/{key}", key)
                .bodyValue(value)
                .retrieve()
                .bodyToMono(String.class);
    }
}
