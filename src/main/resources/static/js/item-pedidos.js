document.addEventListener("DOMContentLoaded", function () {
    carregarItemPedidos();
});

function carregarItemPedidos() {
    fetch(`${API_BASE_URL}/api/v1/pedido-produtos`)
        .then(response => response.json())
        .then(itemPedidos => {
            let tbody = document.getElementById("item-pedidosTabela");
            tbody.innerHTML = "";

            itemPedidos.forEach(itemPedido => {
                let row = `<tr>
                    <td>${itemPedido.id}</td>
                    <td>${itemPedido.pedido.id}</td>
                    <td>${itemPedido.produto.id}</td>
                    <td>${itemPedido.quantidade}</td>
                    <td>${itemPedido.subtotal}</td>
                    <td>
                        <button class="btn btn-danger btn-sm" onclick="excluirItemPedidos(${itemPedido.id})">Excluir</button>
                    </td>
                </tr>`;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar itens pedidos:", error));
}

function excluirItemPedidos(id) {
    fetch(`${API_BASE_URL}/api/v1/pedido-produtos/${id}`, {
        method: "DELETE"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao excluir item pedidos");
            }
        })
        .then(() => {
            alert("Item pedido excluído com sucesso!");
            carregarItemPedidos();
        })
        .catch(error => console.error("Erro ao excluir item pedido:", error));
}
