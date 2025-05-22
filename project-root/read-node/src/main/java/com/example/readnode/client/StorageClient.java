package com.example.readnode.client;

import com.example.readnode.model.KeyValuePair;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "storage-node")
public interface StorageClient {

    @PostMapping("/store/{key}")
    String save(@PathVariable("key") String key, @RequestBody KeyValuePair kvp);

    @GetMapping("/store/{key}")
    KeyValuePair get(@PathVariable("key") String key);

    @DeleteMapping("/store/{key}")
    String delete(@PathVariable("key") String key);
}
