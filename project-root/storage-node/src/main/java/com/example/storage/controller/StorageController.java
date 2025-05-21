package com.example.storage.controller;

import com.example.storage.model.KeyValuePair;
import com.example.storage.repository.InMemoryStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StorageController {

    @PostMapping("/{key}")
    public ResponseEntity<String> save(@PathVariable String key, @RequestBody KeyValuePair kvp) {
        InMemoryStorage.save(key, kvp.getValue());
        return ResponseEntity.ok("Chave '" + key + "' salva com sucesso.");
    }

    @GetMapping("/{key}")
    public ResponseEntity<KeyValuePair> get(@PathVariable String key) {
        String value = InMemoryStorage.get(key);
        if (value == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new KeyValuePair(key, value));
    }
}
