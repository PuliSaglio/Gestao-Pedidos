# 📦 Sistema de Gestão de Pedidos – Aplicação Web

## 📝 Descrição

Esta aplicação Web foi desenvolvida para atender às necessidades do setor de vendas da empresa, permitindo o gerenciamento de pedidos realizados por clientes e facilitando o acompanhamento e análise das vendas.

## 🚀 Funcionalidades

### ✅ Gerenciamento de Pedidos
- Cadastro, edição e exclusão de pedidos.
- Inclusão de múltiplos produtos por pedido, com definição de quantidade e cálculo do valor total.
- Acompanhamento do status dos pedidos: **"Em andamento"**, **"Finalizado"**, **"Cancelado"**.

### 📊 Geração de Relatórios
A aplicação gera relatórios em formato de tabelas, contendo:

- **Resumo das Vendas**:
  - Total de pedidos realizados.
  - Valor total faturado.
  - Quantidade total de produtos vendidos.

- **Pedidos Pendentes**:
  - Listagem completa dos pedidos com status "Em andamento".

- **Clientes Mais Ativos**:
  - Relação dos clientes que mais realizaram pedidos.

## 🛠️ Tecnologias Utilizadas

- **Back-end**: Java + Spring Boot
- **Banco de Dados**: MySQL
- **Front-end**: HTML, CSS, Bootstrap, JS

## 📁 Organização do Projeto
```
├── Configuração do Projeto
│   ├── .gitattributes / .gitignore
│   ├── mvnw / mvnw.cmd (scripts wrapper do Maven)
│   ├── pom.xml (configuração do Maven)
│   ├── system.properties
│   └── README.md

├── Wrapper Maven
│   └── .mvn/wrapper/maven-wrapper.properties

├── Código Fonte
│   └── src/main
│       ├── java/com/puli/gestao_pedidos
│       │   ├── DTO (objetos de transferência de dados)
│       │   ├── config (configurações como CORS)
│       │   ├── controllers (controladores das rotas)
│       │   ├── exceptions (tratamento de exceções)
│       │   ├── model (entidades do sistema)
│       │   ├── repositories (interfaces JPA)
│       │   └── services (regras de negócio)
│       └── resources
│           ├── application.yml (configuração da aplicação)
│           ├── db/migration (scripts Flyway para criação/população do BD)
│           ├── static (arquivos estáticos: CSS, JS)
│           └── templates (páginas HTML)

├── Testes
│   └── src/test/java/com/puli/gestao_pedidos
│       └── GestaoPedidosApplicationTests.java
```
