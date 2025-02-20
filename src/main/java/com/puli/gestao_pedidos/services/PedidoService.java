package com.puli.gestao_pedidos.services;

import com.puli.gestao_pedidos.DTO.ItemPedidoRequest;
import com.puli.gestao_pedidos.DTO.PedidoRequest;
import com.puli.gestao_pedidos.DTO.PedidoUpdateRequest;
import com.puli.gestao_pedidos.exceptions.ResourceNotFoundException;
import com.puli.gestao_pedidos.model.Cliente;
import com.puli.gestao_pedidos.model.Pedido;
import com.puli.gestao_pedidos.model.PedidoProdutos;
import com.puli.gestao_pedidos.model.Produto;
import com.puli.gestao_pedidos.model.enums.PedidoStatus;
import com.puli.gestao_pedidos.repositories.ClienteRepository;
import com.puli.gestao_pedidos.repositories.PedidoProdutosRepository;
import com.puli.gestao_pedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.puli.gestao_pedidos.repositories.PedidoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PedidoService {

    Logger logger = Logger.getLogger(PedidoService.class.getName());

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoProdutosRepository pedidoProdutosRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public Pedido createPedido(PedidoRequest pedidoRequest) {
        logger.info("Criando um pedido");
        Cliente cliente = clienteRepository.findById(pedidoRequest.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setStatus(PedidoStatus.EM_ANDAMENTO);
        pedido.setValorTotal(BigDecimal.ZERO);
        pedido = pedidoRepository.save(pedido);

        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ItemPedidoRequest item : pedidoRequest.getItens()) {
            Produto produto = produtoRepository.findById(item.getProdutoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

            PedidoProdutos pedidoProduto = new PedidoProdutos();
            pedidoProduto.setPedido(pedido);
            pedidoProduto.setProduto(produto);
            pedidoProduto.setQuantidade(item.getQuantidade());
            pedidoProduto.setSubtotal(produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
            produto.setEstoque(produto.getEstoque() - item.getQuantidade());
            valorTotal = valorTotal.add(pedidoProduto.getSubtotal());
            produtoRepository.save(produto);
            pedidoProdutosRepository.save(pedidoProduto);
        }
        pedido.setValorTotal(valorTotal);
        pedido = pedidoRepository.save(pedido);

        return pedido;
    }

    public Pedido findPedido(long id) {
        logger.info("Buscando um pedido");

        return pedidoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Pedido não encontrado com esse id" + id)
        );
    }
    public List<Pedido> findAllPedidos() {
        logger.info("Buscando todos os pedidos");

        return pedidoRepository.findAll();
    }

    public Pedido updatePedido(PedidoUpdateRequest pedido) {
        logger.info("Atualizando um pedido");

        Pedido pedidoEncontrado = findPedido(pedido.getId());
        pedidoEncontrado.setCliente(clienteRepository.findById(pedido.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado")));
        pedidoEncontrado.setDataPedido(pedido.getDataPedido());
        pedidoEncontrado.setStatus(pedido.getStatus());
        pedidoEncontrado.setValorTotal(pedido.getValorTotal());

        return pedidoRepository.save(pedidoEncontrado);
    }

    //deletar primeiro os produtos associados ao pedido
    public void deletePedido(long id) {
        logger.info("Deletando um pedido");

        Pedido pedido = findPedido(id);
        pedidoRepository.delete(pedido);
    }

}
