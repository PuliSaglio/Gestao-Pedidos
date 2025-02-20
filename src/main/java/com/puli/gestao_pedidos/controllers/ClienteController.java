package com.puli.gestao_pedidos.controllers;


import com.puli.gestao_pedidos.model.Cliente;
import com.puli.gestao_pedidos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.createCliente(cliente);
    }

    @PutMapping
    public Cliente updateCliente(@RequestBody Cliente cliente){
        return clienteService.updateCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente findCliente(@PathVariable long id){
        return clienteService.findCliente(id);
    }

    @GetMapping
    public List<Cliente> findAllClientes(){
        return clienteService.findAllClientes();
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable long id){
        clienteService.deleteCliente(id);
    }
}
