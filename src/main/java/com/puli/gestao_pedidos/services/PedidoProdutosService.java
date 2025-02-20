package com.puli.gestao_pedidos.services;

import com.puli.gestao_pedidos.exceptions.ResourceNotFoundException;
import com.puli.gestao_pedidos.model.PedidoProdutos;
import com.puli.gestao_pedidos.repositories.PedidoRepository;
import com.puli.gestao_pedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.puli.gestao_pedidos.repositories.PedidoProdutosRepository;

import java.util.List;
import java.util.logging.Logger;


@Service
public class PedidoProdutosService {

    private Logger logger = Logger.getLogger(PedidoProdutosService.class.getName());

    @Autowired
    private PedidoProdutosRepository pedidoProdutosRepository;

    @Autowired
    public PedidoRepository pedidoRepository;

    @Autowired
    public ProdutoRepository produtoRepository;

    public PedidoProdutos createPedidoProdutos(PedidoProdutos pedidoProdutos) {
        logger.info("Criando um pedido de produtos");

        pedidoProdutos.setPedido(pedidoRepository.findById(pedidoProdutos.getPedidoId()).orElseThrow(
                () -> new ResourceNotFoundException("Pedido não encontrado com esse id" + pedidoProdutos.getPedido().getId())
        ));

        pedidoProdutos.setProduto(produtoRepository.findById(pedidoProdutos.getProduto().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Produto não encontrado com esse id" + pedidoProdutos.getProduto().getId())
        ));

        return pedidoProdutosRepository.save(pedidoProdutos);
    }

    public PedidoProdutos findPedidoProdutos(long id) {
        logger.info("Buscando um pedido de produtos");

        return pedidoProdutosRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Pedido de produtos não encontrado com esse id" + id)
        );
    }

    public List<PedidoProdutos> findAllPedidoProdutos() {
        logger.info("Buscando todos os pedidos de produtos");

        return pedidoProdutosRepository.findAll();
    }

    public PedidoProdutos updatePedidoProdutos(PedidoProdutos pedidoProdutos) {
        logger.info("Atualizando um pedido de produtos");

        PedidoProdutos pedidoProdutosEncontrado = findPedidoProdutos(pedidoProdutos.getId());
        pedidoProdutosEncontrado.setPedido(pedidoProdutos.getPedido());
        pedidoProdutosEncontrado.setProduto(pedidoProdutos.getProduto());
        pedidoProdutosEncontrado.setQuantidade(pedidoProdutos.getQuantidade());
        pedidoProdutosEncontrado.setSubtotal(pedidoProdutos.getSubtotal());

        return pedidoProdutosRepository.save(pedidoProdutosEncontrado);
    }

    public void deletePedidoProdutos(long id) {
        logger.info("Deletando um pedido de produtos");

        PedidoProdutos pedidoProdutosEncontrado = findPedidoProdutos(id);
        pedidoProdutosRepository.delete(pedidoProdutosEncontrado);
    }

}
