package com.puli.gestao_pedidos.DTO;

import java.util.List;

public class PedidoRequest {
    private Long clienteId;
    private List<ItemPedidoRequest> itens;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedidoRequest> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoRequest> itens) {
        this.itens = itens;
    }
}
