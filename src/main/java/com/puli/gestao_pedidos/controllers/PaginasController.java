package com.puli.gestao_pedidos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class PaginasController {

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/clientes")
    public ModelAndView clientes() {
        return new ModelAndView("clientes");
    }

    @GetMapping("/produtos")
    public ModelAndView produtos() {
        return new ModelAndView("produtos");
    }

    @GetMapping("/pedidos")
    public ModelAndView pedidos() {
        return new ModelAndView("pedidos");
    }

    @GetMapping("/item-pedidos")
    public ModelAndView itemPedidos() {
        return new ModelAndView("item-pedidos");
    }

    @GetMapping("/relatorios")
    public ModelAndView relatorios() {
        return new ModelAndView("relatorios");
    }

    @GetMapping("/formata-string")
    public ModelAndView formataString() {
        return new ModelAndView("formata-string");
    }
}