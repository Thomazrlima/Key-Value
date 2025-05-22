package com.example.readnode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "key_value_pair")
public class KeyValuePair {
    @Id
    private String chave;
    private String value;

    public String getChave() { return chave; }
    public void setChave(String chave) { this.chave = chave; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
