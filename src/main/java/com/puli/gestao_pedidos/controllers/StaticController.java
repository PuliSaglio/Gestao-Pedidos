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
}
