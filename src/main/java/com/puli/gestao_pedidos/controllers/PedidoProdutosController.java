package com.puli.gestao_pedidos.controllers;


import com.puli.gestao_pedidos.model.PedidoProdutos;
import com.puli.gestao_pedidos.services.PedidoProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedido-produtos")
public class PedidoProdutosController {

    @Autowired
    private PedidoProdutosService pedidoProdutosService;

    @PostMapping
    public PedidoProdutos createPedidoProdutos(PedidoProdutos pedidoProdutos){
        return pedidoProdutosService.createPedidoProdutos(pedidoProdutos);
    }

    @PutMapping("/{id}")
    public PedidoProdutos updatePedidoProdutos(PedidoProdutos pedidoProdutos){
        return pedidoProdutosService.updatePedidoProdutos(pedidoProdutos);
    }

    @GetMapping("/{id}")
    public PedidoProdutos findPedidoProdutos(long id){
        return pedidoProdutosService.findPedidoProdutos(id);
    }

    @GetMapping
    public List<PedidoProdutos> findAllPedidoProdutos(){
        return pedidoProdutosService.findAllPedidoProdutos();
    }

    @DeleteMapping("/{id}")
    public void deletePedidoProdutos(@PathVariable long id){
        pedidoProdutosService.deletePedidoProdutos(id);
    }


}
