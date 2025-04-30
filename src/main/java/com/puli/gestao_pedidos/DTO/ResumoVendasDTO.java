package com.puli.gestao_pedidos.DTO;

import java.math.BigDecimal;

public class ResumoVendasDTO {
    private Long totalPedidos;
    private BigDecimal totalFaturado;
    private BigDecimal totalProdutosVendidos;

    public ResumoVendasDTO(Long totalPedidos, BigDecimal totalFaturado, BigDecimal totalProdutosVendidos) {
        this.totalPedidos = totalPedidos;
        this.totalFaturado = totalFaturado;
        this.totalProdutosVendidos = totalProdutosVendidos;
    }

    public Long getTotalPedidos() {
        return totalPedidos;
    }

    public void setTotalPedidos(Long totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public BigDecimal getTotalFaturado() {
        return totalFaturado;
    }

    public void setTotalFaturado(BigDecimal totalFaturado) {
        this.totalFaturado = totalFaturado;
    }

    public BigDecimal getTotalProdutosVendidos() {
        return totalProdutosVendidos;
    }

    public void setTotalProdutosVendidos(BigDecimal totalProdutosVendidos) {
        this.totalProdutosVendidos = totalProdutosVendidos;
    }
}
