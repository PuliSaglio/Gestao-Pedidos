package com.puli.gestao_pedidos.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/static")
public class StaticController {
    //tive que fazer essa gambiarra porque o static não estava funcionando

    @GetMapping("/css/estilo.css")
    public ResponseEntity<Resource> getCss() {
        Resource resource = new ClassPathResource("static/css/estilo.css");
        return ResponseEntity.ok().body(resource);
    }
    @GetMapping("/css/index.css")
    public ResponseEntity<Resource> getIndexCss() {
        Resource resource = new ClassPathResource("static/css/index.css");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/js/clientes.js")
    public ResponseEntity<Resource> getClientesJs() {
        Resource resource = new ClassPathResource("static/js/clientes.js");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/js/pedidos.js")
    public ResponseEntity<Resource> getPedidosJs() {
        Resource resource = new ClassPathResource("static/js/pedidos.js");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/js/produtos.js")
    public ResponseEntity<Resource> getProdutosJs() {
        Resource resource = new ClassPathResource("static/js/produtos.js");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/js/item-pedidos.js")
    public ResponseEntity<Resource> getItemPedidosJs() {
        Resource resource = new ClassPathResource("static/js/item-pedidos.js");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/js/formata-string.js")
    public ResponseEntity<Resource> getFormataStringJs() {
        Resource resource = new ClassPathResource("static/js/formata-string.js");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/js/relatorios.js")
    public ResponseEntity<Resource> getRelatoriosJs() {
        Resource resource = new ClassPathResource("static/js/relatorios.js");
        return ResponseEntity.ok().body(resource);
    }
}
