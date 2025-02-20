package com.puli.gestao_pedidos.controllers;

import com.puli.gestao_pedidos.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.puli.gestao_pedidos.services.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @PutMapping
    public Produto updateProduto(@RequestBody Produto produto) {
        return produtoService.updateProduto(produto);
    }

    @GetMapping("/{id}")
    public Produto findProduto(@PathVariable long id) {
        return produtoService.findProduto(id);
    }

    @GetMapping
    public List<Produto> findAllProdutos() {
        return produtoService.findAllProdutos();
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable long id) {
        produtoService.deleteProduto(id);
    }
}
