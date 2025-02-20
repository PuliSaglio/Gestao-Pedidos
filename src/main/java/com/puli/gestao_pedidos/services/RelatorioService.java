package com.puli.gestao_pedidos.services;

import com.puli.gestao_pedidos.model.Pedido;
import com.puli.gestao_pedidos.repositories.PedidoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class RelatorioService {

    private static final Log log = LogFactory.getLog(RelatorioService.class);
    Logger logger = Logger.getLogger(RelatorioService.class.getName());

    @Autowired
    private PedidoRepository pedidoRepository;

    public Map<String, Object> getResumoVendas() {
        logger.info("Gerando resumo de vendas");
        Object[] result = (Object[]) pedidoRepository.getResumoVendas()[0];
        Map<String, Object> resumo = new HashMap<>();
        resumo.put("Total Pedidos", result[0]);
        resumo.put("Total Faturado", result[1]);
        resumo.put("Total Produtos Vendidos", result[2]);
        return resumo;
    }

    public List<Pedido> findPedidosEmAndamento() {
        logger.info("Buscando pedidos em andamento");
        return pedidoRepository.findPedidosEmAndamento();
    }

    public Map<String, Object> findClientesMaisAtivos() {
        logger.info("Buscando clientes mais ativos");
        List<Object[]> clientes = pedidoRepository.findClientesMaisAtivos();
        List<Map<String, Object>> clientesFormatado = new ArrayList<>();
        for (Object[] cliente : clientes) {
            Map<String, Object> clienteMap = new HashMap<>();
            clienteMap.put("id", cliente[0]);
            clienteMap.put("nome", cliente[1]);
            clienteMap.put("totalPedidos", cliente[2]);
            clientesFormatado.add(clienteMap);
        }
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("clientes", clientesFormatado);
        return resultado;
    }
}
