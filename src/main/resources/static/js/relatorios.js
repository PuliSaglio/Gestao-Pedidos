document.addEventListener("DOMContentLoaded", function () {
    carregarResumoVendas();
    carregarPedidosAndamento()
    carregarClientesMaisAtivos()
});

function carregarResumoVendas() {
    fetch(`${API_BASE_URL}/api/v1/relatorios/resumo-vendas`)
        .then(response => response.json())
        .then(resumo => {
            let tbody = document.getElementById("resumoVendasTabela").querySelector("tbody");
            tbody.innerHTML = "";

            for (const [key, value] of Object.entries(resumo)) {
                let row = `
<tr>
    <td>${key}</td>
    <td>${value}</td>
</tr>`;
                tbody.innerHTML += row;
            }
        })
        .catch(error => console.error("Erro ao buscar resumo de vendas:", error));
}

function carregarPedidosAndamento(){
    fetch(`${API_BASE_URL}/api/v1/relatorios/pedidos-em-andamento`)
        .then(response => response.json())
        .then(pedidos => {
            let tbody = document.getElementById("pedidosAndamentoTabela");
            tbody.innerHTML = "";

            pedidos.forEach(pedido => {
                let row = `<tr>
                    <td>${pedido.id}</td>
                    <td>${pedido.cliente.nome}</td>
                    <td>${pedido.dataPedido}</td>
                    <td>${pedido.valorTotal}</td>
                </tr>`;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar pedidos em andamento:", error));
}

function carregarClientesMaisAtivos() {
    fetch(`${API_BASE_URL}/api/v1/relatorios/clientes-mais-ativos`)
        .then(response => response.json())
        .then(resumo => {
            let tbody = document.getElementById("resumoClientesAtivosTabela").querySelector("tbody");
            tbody.innerHTML = "";

            for (const cliente of resumo.clientes) {
                let row = `<tr>
        <td>${cliente.id}</td>
        <td>${cliente.nome}</td>
        <td>${cliente.totalPedidos}</td>
    </tr>`;
                tbody.innerHTML += row;
            }
        })
        .catch(error => console.error("Erro ao buscar resumo de vendas:", error));
}

