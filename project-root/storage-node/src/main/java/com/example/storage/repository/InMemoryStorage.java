package com.example.storage.repository;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStorage {
    private static final ConcurrentHashMap<String, String> store = new ConcurrentHashMap<>();

    public static void save(String key, String value) {
        store.put(key, value);
    }

    public static String get(String key) {
        return store.getOrDefault(key, null);
    }
}
