## Tarefa 1: Desenvolver uma API

Você deverá desenvolver uma API (Restful) simples que receba uma requisição HTTP com uma string, e encontre o primeiro caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita na string.

Premissas:

Não será possível reiniciar o fluxo da leitura da string.
Na tarefa 1 não poderá ser utilizado nenhuma lib, apenas código nativo na identificação da vogal.

Exemplo:

Input: aAbBABacafe
Output: e

No exemplo, ‘e’ é o primeiro caractere Vogal da stream que não se repete após a primeira Consoante ‘f’ o qual tem uma vogal ‘a’ como antecessora.

E o resultado do processamento deverá ser igual à:
```json
{
  "string": " aAbBABacafe",
  "vogal": "e",
  "tempoTotal": "10ms"
}
```

## Tarefa 2: Criar uma aplicação Web

O setor de vendas da empresa precisa de uma ferramenta para gerenciar os pedidos realizados pelos clientes e facilitar o acompanhamento das vendas. Seu objetivo será desenvolver uma aplicação Web para atender a essa necessidade.

A aplicação deverá permitir que os vendedores possam:

- Cadastrar e gerenciar pedidos, incluindo os produtos, quantidade e valor total.
- Acompanhar o status dos pedidos (Exemplo: "Em andamento", "Finalizado", "Cancelado").
- Gerar relatórios para facilitar a análise das vendas. O relatório deverá conter os seguintes dados em tabelas:
   - Resumo das Vendas: Total de pedidos realizados, valor total faturado e quantidade total de produtos vendidos.
   - Pedidos Pendentes: Listagem dos pedidos que ainda estão em andamento.
   - Clientes Mais Ativos: Listagem dos clientes que mais realizaram pedidos.


**Obs:** As tarefas 1 e 2 deverão ser desenvolvidas dentro da mesma aplicação Web.

## Entrega e Avaliação
- As Tarefas 1 e 2 devem ser desenvolvidas dentro da mesma aplicação Web.
- A modelagem do banco de dados, organização do código, estrutura do repositório e interface gráfica serão avaliados.
- A aplicação deve ser hospedada na nuvem e as instruções de acesso a aplicação devem ser enviadas por e-mail.
- O candidato deve enviar o link do repositório contendo o código-fonte da solução.


