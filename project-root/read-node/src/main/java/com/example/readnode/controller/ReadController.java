package com.example.readnode.controller;

import com.example.readnode.client.StorageClient;
import com.example.readnode.model.KeyValuePair;
import com.example.readnode.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/read")
public class ReadController {

    @Autowired
    private StorageClient storageClient;

    @PostMapping("/store/{key}")
    public String save(@PathVariable String key, @RequestBody KeyValuePair kvp) {
        return storageClient.save(key, kvp);
    }

    @GetMapping("/store/{key}")
    public KeyValuePair get(@PathVariable String key) {
        return storageClient.get(key);
    }

    @DeleteMapping("/store/{key}")
    public String delete(@PathVariable String key) {
        return storageClient.delete(key);
    }
}
