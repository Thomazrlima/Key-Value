package com.example.storage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "key_value_pair")
public class KeyValuePair {
    @Id
    private String chave;
    private String value;

    public KeyValuePair() {}

    public KeyValuePair(String chave, String value) {
        this.chave = chave;
        this.value = value;
    }

    public String getKey() {
        return chave;
    }

    public void setKey(String chave) {
        this.chave = chave;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
