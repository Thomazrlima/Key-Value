package com.example.storage.repository;

import com.example.storage.model.KeyValuePair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyValuePairRepository extends CrudRepository<KeyValuePair, String> {
}
