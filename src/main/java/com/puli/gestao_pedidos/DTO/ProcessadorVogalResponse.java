package com.puli.gestao_pedidos.DTO;

public class ProcessadorVogalResponse {
    private String string;
    private char vogal;
    private String tempoTotal;

    public ProcessadorVogalResponse(String string, char vogal, String tempoTotal) {
        this.string = string;
        this.vogal = vogal;
        this.tempoTotal = tempoTotal;
    }

    // Getters and setters
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public char getVogal() {
        return vogal;
    }

    public void setVogal(char vogal) {
        this.vogal = vogal;
    }

    public String getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(String tempoTotal) {
        this.tempoTotal = tempoTotal;
    }
}