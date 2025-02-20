document.addEventListener("DOMContentLoaded", function () {
    carregarProdutos();

    document.getElementById("produtoForm").addEventListener("submit", function (event) {
        event.preventDefault();
        cadastrarProduto();
    });
});

const API_BASE_URL = "https://gestao-pedidos-0300afe3141d.herokuapp.com";

function carregarProdutos() {
    fetch(`${API_BASE_URL}/api/v1/produtos`)
        .then(response => response.json())
        .then(produtos => {
            let tbody = document.getElementById("produtosTabela");
            tbody.innerHTML = "";

            produtos.forEach(produto => {
                let row = `<tr>
                    <td>${produto.id}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.preco}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.estoque}</td>
                    <td>
                        <button class="btn btn-primary btn-sm" onclick="encontrarProduto(${produto.id})">Editar</button>
                        <button class="btn btn-danger btn-sm" onclick="excluirProduto(${produto.id})">Excluir</button>
                    </td>
                </tr>`;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar produtos:", error));
}

function cadastrarProduto() {
    const produto = {
        nome: document.getElementById("produtoNome").value,
        preco: document.getElementById("produtoPreco").value,
        descricao: document.getElementById("produtoDescricao").value,
        estoque: document.getElementById("produtoEstoque").value
    };

    fetch(`${API_BASE_URL}/api/v1/produtos`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(produto)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao cadastrar produto");
            }
            return response.json();
        })
        .then(() => {
            alert("Produto cadastrado com sucesso!");
            carregarProdutos();
        })
        .catch(error => console.error("Erro ao cadastrar produto:", error));
}

function excluirProduto(id) {
    fetch(`${API_BASE_URL}/api/v1/produtos/${id}`, {
        method: "DELETE"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao excluir produto");
            }
        })
        .then(() => {
            alert("Produto excluído com sucesso!");
            carregarProdutos();
        })
        .catch(error => console.error("Erro ao excluir produto:", error));
}

function encontrarProduto(id) {
    fetch(`${API_BASE_URL}/api/v1/produtos/${id}`)
        .then(response => response.json())
        .then(produto => {
            document.getElementById("produtoId").value = produto.id;
            document.getElementById("produtoNome").value = produto.nome;
            document.getElementById("produtoPreco").value = produto.preco;
            document.getElementById("produtoDescricao").value = produto.descricao;
            document.getElementById("produtoEstoque").value = produto.estoque;
        })
        .catch(error => console.error("Erro ao encontrar produto:", error));
}

function atualizarProduto() {
    const produto = {
        id: document.getElementById("produtoId").value,
        nome: document.getElementById("produtoNome").value,
        preco: document.getElementById("produtoPreco").value,
        descricao: document.getElementById("produtoDescricao").value,
        estoque: document.getElementById("produtoEstoque").value
    };

    fetch(`${API_BASE_URL}/api/v1/produtos`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(produto)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao atualizar produto");
            }
            return response.json();
        })
        .then(() => {
            alert("Produto atualizado com sucesso!");
            carregarProdutos();
        })
        .catch(error => console.error("Erro ao atualizar produto:", error));
}