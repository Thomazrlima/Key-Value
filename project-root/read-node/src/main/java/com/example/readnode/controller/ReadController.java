package com.example.readnode.controller;

import com.example.readnode.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/read")
public class ReadController {

    @Autowired
    private ReadService readService;

    @GetMapping("/key/{key}")
    public String getValueByKey(@PathVariable String key) {
        return readService.getValue(key);
    }
}
