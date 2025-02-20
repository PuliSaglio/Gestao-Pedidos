package com.puli.gestao_pedidos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PaginasController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/clientes")
    public String clientes() {
        return "clientes";
    }

    @GetMapping("/produtos")
    public String produtos() {
        return "produtos";
    }

    @GetMapping("/pedidos")
    public String pedidos() {
        return "pedidos";
    }

    @GetMapping("/item-pedidos")
    public String itemPedidos() {
        return "item-pedidos";
    }

    @GetMapping("/relatorios")
    public String relatorios() {
        return "relatorios";
    }

    @GetMapping("/formata-string")
    public String formataString() {
        return "formata-string";
    }
}