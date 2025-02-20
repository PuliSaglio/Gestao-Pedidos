package com.puli.gestao_pedidos.controllers;

import com.puli.gestao_pedidos.DTO.ProcessadorVogalResponse;
import com.puli.gestao_pedidos.services.ProcessadorVogalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/processador-vogal"))
public class ProcessadorVogalController {

    @Autowired
    private ProcessadorVogalService processadorVogalService;

    @PostMapping
    public ProcessadorVogalResponse processarVogal(@RequestBody String palavra){
        Long startTime = System.currentTimeMillis();
        char vogal = processadorVogalService.processarVogal(palavra);
        Long endTime = System.currentTimeMillis();
        String tempoTotal = (endTime - startTime) + "ms";
        return new ProcessadorVogalResponse(palavra, vogal, tempoTotal);
    }


}
