package com.puli.gestao_pedidos.repositories;

import com.puli.gestao_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    @Query(value = "SELECT COUNT(DISTINCT p.id) AS total_pedidos,  " +
            "COALESCE(SUM(CASE WHEN p.status != 1 THEN p.valor_total ELSE 0 END), 0) AS total_faturado, " +
            "COALESCE(SUM(pp.quantidade), 0) AS total_produtos_vendidos " +
            "FROM pedidos p " +
            "LEFT JOIN pedidos_produtos pp ON p.id = pp.pedido_id",
            nativeQuery = true)

    Object[] getResumoVendas();

    @Query(value = "SELECT * FROM pedidos p WHERE p.status = 0", nativeQuery = true)
    List<Pedido> findPedidosEmAndamento();

    @Query(value = "SELECT c.id, c.nome, COUNT(p.id) AS total_pedidos " +
            "FROM clientes c " +
            "JOIN pedidos p ON c.id = p.cliente_id " +
            "GROUP BY c.id, c.nome " +
            "ORDER BY total_pedidos DESC", nativeQuery = true)
    List<Object[]> findClientesMaisAtivos();
}
