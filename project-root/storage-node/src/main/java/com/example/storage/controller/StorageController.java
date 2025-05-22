package com.example.storage.controller;

import com.example.storage.model.KeyValuePair;
import com.example.storage.repository.KeyValuePairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@CrossOrigin
public class StorageController {

    private final KeyValuePairRepository repository;

    @Autowired
    public StorageController(KeyValuePairRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{key}")
    public ResponseEntity<String> save(@PathVariable String key, @RequestBody KeyValuePair kvp) {
        if (kvp == null || kvp.getValue() == null) {
            return ResponseEntity.badRequest().body("Valor ausente.");
        }
        kvp.setKey(key);
        repository.save(kvp);
        return ResponseEntity.ok("Chave '" + key + "' salva com sucesso.");
    }

    @GetMapping("/{key}")
    public ResponseEntity<KeyValuePair> get(@PathVariable String key) {
        return repository.findById(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<String> delete(@PathVariable String key) {
        if (repository.existsById(key)) {
            repository.deleteById(key);
            return ResponseEntity.ok("Chave '" + key + "' removida com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
