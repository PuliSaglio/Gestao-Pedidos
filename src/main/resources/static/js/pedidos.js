document.addEventListener("DOMContentLoaded", function () {
    carregarPedidos();
    carregarItens();

    document.getElementById("pedidoCadastroForm").addEventListener("submit", function (event) {
        event.preventDefault();
        cadastrarPedido();
    });
});

function carregarPedidos() {
    fetch("http://localhost:8080/api/v1/pedidos")
        .then(response => response.json())
        .then(pedidos => {
            let tbody = document.getElementById("pedidosTabela");
            tbody.innerHTML = "";

            pedidos.forEach(pedido => {
                let row = `<tr>
                    <td>${pedido.id}</td>
                    <td>${pedido.cliente.id}</td>
                    <td>${pedido.dataPedido}</td>
                    <td>${pedido.status}</td>
                    <td>${pedido.valorTotal}</td>
                    <td>
                        <button class="btn btn-primary btn-sm" onclick="encontrarPedido(${pedido.id}); location.hash='#pedidoAtualizarForm';">Editar</button>
                        <button class="btn btn-danger btn-sm" onclick="excluirPedido(${pedido.id})">Excluir</button>
                    </td>
                </tr>`;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar pedidos:", error));
}

function carregarItens() {
    fetch("http://localhost:8080/api/v1/produtos")
        .then(response => response.json())
        .then(produtos => {
            let tbody = document.getElementById("itensTabela");
            tbody.innerHTML = "";

            produtos.forEach(produto => {
                let row = `<tr>
                    <td>${produto.nome}</td>
                    <td>${produto.preco}</td>
                    <td>${produto.estoque}</td>
                    <td><input type="number" id="quantidade-${produto.id}" class="form-control" min="1" max="${produto.estoque}" value="1"></td>
                    <td><button class="btn btn-success btn-sm" onclick="adicionarItem(${produto.id}, '${produto.nome}')">Adicionar</button></td>
                </tr>`;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar itens:", error));
}

function adicionarItem(id, nome) {
    let quantidade = document.getElementById(`quantidade-${id}`).value;
    let itensDiv = document.getElementById("itensPedido");
    let itemDiv = document.createElement("div");
    itemDiv.innerHTML = `Produto: ${nome}, Quantidade: ${quantidade}`;
    itemDiv.dataset.produtoId = id;
    itemDiv.dataset.quantidade = quantidade;
    itensDiv.appendChild(itemDiv);
}

function cadastrarPedido() {
    const clienteId = document.getElementById("clienteId").value;
    const itensDiv = document.getElementById("itensPedido").children;
    const itens = Array.from(itensDiv).map(item => ({
        produtoId: item.dataset.produtoId,
        quantidade: item.dataset.quantidade
    }));

    const pedido = {
        clienteId: clienteId,
        itens: itens
    };

    fetch("http://localhost:8080/api/v1/pedidos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pedido)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao cadastrar pedido");
            }
            return response.json();
        })
        .then(() => {
            alert("Pedido cadastrado com sucesso!");
            carregarPedidos();
        })
        .catch(error => console.error("Erro ao cadastrar pedido:", error));
}



function excluirPedido(id) {
    fetch(`http://localhost:8080/api/v1/pedidos/${id}`, {
        method: "DELETE"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao excluir pedido");
            }
        })
        .then(() => {
            alert("Pedido excluído com sucesso!");
            carregarPedidos();
        })
        .catch(error => console.error("Erro ao excluir pedido:", error));
}

function encontrarPedido(id) {
    fetch(`http://localhost:8080/api/v1/pedidos/${id}`)
        .then(response => response.json())
        .then(pedido => {
            document.getElementById("pedidoId").value = pedido.id;
            document.getElementById("clienteIdAtualizar").value = pedido.cliente.id;
            document.getElementById("pedidoData").value = pedido.dataPedido;
            document.getElementById("pedidoStatus").value = pedido.status;
            document.getElementById("pedidoValorTotal").value = pedido.valorTotal;
        })
        .catch(error => console.error("Erro ao encontrar pedido:", error));
}

function atualizarPedido() {
    const pedido = {
        id: document.getElementById("pedidoId").value,
        clienteId: document.getElementById("clienteIdAtualizar").value,
        dataPedido: document.getElementById("pedidoData").value,
        status: document.getElementById("pedidoStatus").value,
        valorTotal: document.getElementById("pedidoValorTotal").value
    };

    fetch(`http://localhost:8080/api/v1/pedidos`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pedido)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao atualizar pedido");
            }
            return response.json();
        })
        .then(() => {
            alert("Pedido atualizado com sucesso!");
            carregarPedidos();
        })
        .catch(error => console.error("Erro ao atualizar pedido:", error));
}