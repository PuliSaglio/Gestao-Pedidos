package com.puli.gestao_pedidos.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProcessadorVogalService {

    //Pelo que entendi o desafio propoe encontrar uma estrutura do tipo: [vogal , consoante, vogal não repetida] e retornar a vogal não repetida
    public char processarVogal(String palavra){
        Set<Character> vogaisEncontradas = new HashSet<>();

        Set<Character> vogais = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        Set<Character> consoantes = Set.of(
                'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z',
                'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'
        );
        for (int i = 0; i < palavra.length() - 2; i++) {
            char atual = palavra.charAt(i);
            char proximo = palavra.charAt(i + 1);
            char depoisProximo = palavra.charAt(i + 2);

            //verifica se a letra atual é uma vogal
            if(vogais.contains(atual)){
                //adiciona a vogal encontrada no set
                vogaisEncontradas.add(atual);
                //verifica se a próxima letra é uma consoante e se a proxima letra(pós consoante) é vogal não foi encontrada ainda
                if (consoantes.contains(proximo) && vogais.contains(depoisProximo) && !vogaisEncontradas.contains(depoisProximo)) {
                    return depoisProximo;
                }
            }
        }
        return ' ';
    }
}
