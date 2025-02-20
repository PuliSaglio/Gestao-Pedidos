document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("formataStringForm").addEventListener("submit", function (event) {
        event.preventDefault();
        formataString();
    });
});

function formataString() {
    const string = document.getElementById("string").value;

    fetch("http://localhost:8080/api/v1/processador-vogal", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(string)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao formatar string");
            }
            return response.json();
        }).then(data => {
        document.getElementById("resultadoString").innerText = "String: " + data.string;
        document.getElementById("resultadoVogal").innerText = "Vogal: " + data.vogal;
        document.getElementById("resultadoTempo").innerText = "Tempo Total: " + data.tempoTotal;
    })
        .catch(error => document.getElementById("resultado").innerText = "Erro ao formatar string: " + error);
}