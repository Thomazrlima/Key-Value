package com.docsapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExemploController {

    @Operation(
            summary = "Endpoint de teste",
            description = "Retorna uma mensagem fixa para testar a API"
    )
    @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida")
    @GetMapping("/api/hello")
    public String hello() {
        return "Olá, esta é a sua API funcionando na porta 8082!";
    }
}
