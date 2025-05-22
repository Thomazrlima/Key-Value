package com.example.readnode.service;

import com.example.readnode.model.KeyValuePair;
import com.example.readnode.repository.KeyValuePairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadService {

    @Autowired
    private KeyValuePairRepository repository;

    public String getValue(String key) {
        Optional<KeyValuePair> kvp = repository.findById(key);
        return kvp.map(KeyValuePair::getValue).orElse(null);
    }
}
