package com.example.gateway.controller;

import com.example.gateway.service.KeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/keyvalue")
public class KeyValueController {

    @Autowired
    private KeyValueService keyValueService;

    @GetMapping("/{key}")
    public Mono<ResponseEntity<String>> getValue(@PathVariable String key) {
        return keyValueService.getValue(key)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{key}")
    public Mono<ResponseEntity<String>> putValue(@PathVariable String key, @RequestBody String value) {
        return keyValueService.putValue(key, value)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
