package com.example.gateway.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/store")
public class KeyValueController {

    private final WebClient webClient;

    public KeyValueController(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://read-node").build();
    }

    @GetMapping("/{key}")
    public Mono<String> getValue(@PathVariable String key) {
        return webClient.get()
                .uri("/read/store/{key}", key)
                .retrieve()
                .bodyToMono(Map.class)
                .map(map -> "Chave: " + map.get("chave") + "\nValor: " + map.get("value"))
                .onErrorResume(WebClientResponseException.NotFound.class,
                        ex -> Mono.just("Chave '" + key + "' não encontrada."))
                .onErrorResume(e -> Mono.just("Erro ao acessar o head node: " + e.getMessage()));
    }

    @PostMapping("/{key}")
    public Mono<String> postValue(@PathVariable String key, @RequestBody Map<String, String> payload) {
        return webClient.post()
                .uri("/read/store/{key}", key)
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.just("Erro ao salvar valor no head node: " + e.getMessage()));
    }

    @DeleteMapping("/{key}")
    public Mono<String> deleteValue(@PathVariable String key) {
        return webClient.delete()
                .uri("/read/store/{key}", key)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.NotFound.class,
                        ex -> Mono.just("Chave '" + key + "' não encontrada para remoção."))
                .onErrorResume(e -> Mono.just("Erro ao remover valor no head node: " + e.getMessage()));
    }
}
