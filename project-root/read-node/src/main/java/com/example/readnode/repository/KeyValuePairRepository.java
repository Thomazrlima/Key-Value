package com.example.readnode.repository;

import com.example.readnode.model.KeyValuePair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyValuePairRepository extends CrudRepository<KeyValuePair, String> {
}
