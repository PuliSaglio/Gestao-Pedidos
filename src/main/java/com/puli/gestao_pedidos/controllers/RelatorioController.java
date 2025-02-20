package com.puli.gestao_pedidos.controllers;

import com.puli.gestao_pedidos.services.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/relatorios")
public class RelatorioController {


    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/resumo-vendas")
    public Map<String, Object> getResumoVendas() {
        return relatorioService.getResumoVendas();
    }

    @GetMapping("/pedidos-em-andamento")
    public List<?> findPedidosEmAndamento() {
        return relatorioService.findPedidosEmAndamento();
    }

    @GetMapping("/clientes-mais-ativos")
    public Map<String, Object> findClientesMaisAtivos() {
        return relatorioService.findClientesMaisAtivos();
    }
}
