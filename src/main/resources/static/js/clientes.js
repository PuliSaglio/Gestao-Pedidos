document.addEventListener("DOMContentLoaded", function () {
    carregarClientes();

    document.getElementById("clienteForm").addEventListener("submit", function (event) {
        event.preventDefault();
        cadastrarCliente();
    });
});

function carregarClientes() {
    fetch(`${API_BASE_URL}/api/v1/cliente`)
        .then(response => response.json())
        .then(clientes => {
            let tbody = document.getElementById("clientesTabela");
            tbody.innerHTML = "";

            clientes.forEach(cliente => {
                let row = `<tr>
                    <td>${cliente.id}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.endereco}</td>
                    <td>
                        <button class="btn btn-primary btn-sm" onclick="encontrarCliente(${cliente.id})">Editar</button>
                        <button class="btn btn-danger btn-sm" onclick="excluirCliente(${cliente.id})">Excluir</button>
                    </td>
                </tr>`;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao buscar clientes:", error));
}

function cadastrarCliente() {
    const cliente = {
        nome: document.getElementById("clienteNome").value,
        telefone: document.getElementById("clienteTelefone").value,
        email: document.getElementById("clienteEmail").value,
        endereco: document.getElementById("clienteEndereco").value
    };

    fetch(`${API_BASE_URL}/api/v1/cliente`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cliente)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao cadastrar cliente");
            }
            return response.json();
        })
        .then(() => {
            alert("Cliente cadastrado com sucesso!");
            carregarClientes();
        })
        .catch(error => console.error("Erro ao cadastrar cliente:", error));
}

function excluirCliente(id) {
    fetch(`${API_BASE_URL}/api/v1/cliente/${id}`, {
        method: "DELETE"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao excluir cliente");
            }
        })
        .then(() => {
            alert("Cliente excluído com sucesso!");
            carregarClientes();
        })
        .catch(error => console.error("Erro ao excluir cliente:", error));
}

function encontrarCliente(id) {
    fetch(`${API_BASE_URL}/api/v1/cliente/${id}`)
        .then(response => response.json())
        .then(cliente => {
            document.getElementById("clienteId").value = cliente.id;
            document.getElementById("clienteNome").value = cliente.nome;
            document.getElementById("clienteTelefone").value = cliente.telefone;
            document.getElementById("clienteEmail").value = cliente.email;
            document.getElementById("clienteEndereco").value = cliente.endereco;
        })
        .catch(error => console.error("Erro ao encontrar cliente:", error));
}

function atualizarCliente() {
    const cliente = {
        id: document.getElementById("clienteId").value,
        nome: document.getElementById("clienteNome").value,
        telefone: document.getElementById("clienteTelefone").value,
        email: document.getElementById("clienteEmail").value,
        endereco: document.getElementById("clienteEndereco").value
    };

    fetch(`${API_BASE_URL}/api/v1/cliente/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cliente)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao atualizar cliente");
            }
            return response.json();
        })
        .then(() => {
            alert("Cliente atualizado com sucesso!");
            carregarClientes();
        })
        .catch(error => console.error("Erro ao atualizar cliente:", error));
}