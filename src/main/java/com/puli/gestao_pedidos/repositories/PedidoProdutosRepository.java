package com.puli.gestao_pedidos.repositories;

import com.puli.gestao_pedidos.model.PedidoProdutos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutosRepository extends JpaRepository<PedidoProdutos, Long> {
}
