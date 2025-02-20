package com.puli.gestao_pedidos.services;

import com.puli.gestao_pedidos.exceptions.ResourceNotFoundException;
import com.puli.gestao_pedidos.model.Produto;
import com.puli.gestao_pedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProdutoService {

    Logger logger = Logger.getLogger(ProdutoService.class.getName());

    @Autowired
    private ProdutoRepository produtoRepository;

    // create, read, update, delete

    public Produto createProduto(Produto produto) {
        logger.info("Criando um produto");
        return produtoRepository.save(produto);
    }

    public Produto findProduto(long id) {
        logger.info("Buscando um produto");

        return produtoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Produto não encontrado com esse id" + id)
        );
    }

    public List<Produto> findAllProdutos() {
        logger.info("Buscando todos os produtos");

        return produtoRepository.findAll();
    }

    public Produto updateProduto(Produto produto) {
        logger.info("Atualizando um produto");

        Produto produtoEncontrado = findProduto(produto.getId());
        produtoEncontrado.setNome(produto.getNome());
        produtoEncontrado.setDescricao(produto.getDescricao());
        produtoEncontrado.setPreco(produto.getPreco());
        produtoEncontrado.setEstoque(produto.getEstoque());

        return produtoRepository.save(produtoEncontrado);
    }

    public void deleteProduto(long id) {
        logger.info("Deletando um produto");

        Produto produtoEncontrado = findProduto(id);
        produtoRepository.delete(produtoEncontrado);
    }
}
