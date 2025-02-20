package com.puli.gestao_pedidos.controllers;

import com.puli.gestao_pedidos.DTO.PedidoRequest;
import com.puli.gestao_pedidos.DTO.PedidoUpdateRequest;
import com.puli.gestao_pedidos.model.PedidoProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.puli.gestao_pedidos.services.PedidoService;
import com.puli.gestao_pedidos.model.Pedido;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido createPedido(@RequestBody PedidoRequest pedido) {
        return pedidoService.createPedido(pedido);
    }

    @PutMapping
    public Pedido updatePedido(@RequestBody PedidoUpdateRequest pedido) {
        return pedidoService.updatePedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido findPedido(@PathVariable long id) {
        return pedidoService.findPedido(id);
    }

    @GetMapping
    public List<Pedido> findAllPedidos() {
        return pedidoService.findAllPedidos();
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable long id) {
        pedidoService.deletePedido(id);
    }



}
