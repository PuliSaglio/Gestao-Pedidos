package com.puli.gestao_pedidos.services;

import com.puli.gestao_pedidos.exceptions.ResourceNotFoundException;
import com.puli.gestao_pedidos.model.Cliente;
import com.puli.gestao_pedidos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ClienteService {

    private Logger logger = Logger.getLogger(ClienteService.class.getName());

    @Autowired
    private ClienteRepository clienteRepository;

    // create, read, update, delete

    public Cliente createCliente(Cliente cliente) {
        logger.info("Criando um cliente");
        return clienteRepository.save(cliente);
    }

    public Cliente findCliente(long id) {
        logger.info("Buscando um cliente");

        return clienteRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado com esse id" + id)
        );
    }

    public List<Cliente> findAllClientes() {
        logger.info("Buscando todos os clientes");

        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Cliente cliente) {
        logger.info("Atualizando um cliente");

        Cliente clienteEncontrado = findCliente(cliente.getId());
        clienteEncontrado.setNome(cliente.getNome());
        clienteEncontrado.setEmail(cliente.getEmail());
        clienteEncontrado.setTelefone(cliente.getTelefone());
        clienteEncontrado.setEndereco(cliente.getEndereco());

        return clienteRepository.save(clienteEncontrado);
    }

    public void deleteCliente(long id) {
        logger.info("Deletando um cliente");

        Cliente clienteEncontrado = findCliente(id);
        clienteRepository.delete(clienteEncontrado);
    }

}
