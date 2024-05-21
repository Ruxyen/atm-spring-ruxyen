package com.daw.atm.models;

// Clase que representa un depósito
public class Diposit {
    
    // Atributo que representa el valor del depósito
    protected double valor;
    
    // Atributo que representa la cantidad del depósito
    protected double quantitat;
    
    // Constructor que inicializa los valores del depósito
    public Diposit(double valor, double quantitat) {
        this.valor = valor;
        this.quantitat = quantitat;
    }

    // Método getter para obtener el valor del depósito
    public double getValor() {
        return valor;
    }

    // Método setter para establecer el valor del depósito
    public void setValor(double valor) {
        this.valor = valor;
    }

    // Método getter para obtener la cantidad del depósito
    public double getQuantitat() {
        return quantitat;
    }

    // Método setter para establecer la cantidad del depósito
    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }

    // Método toString para representar la información del depósito
    @Override
    public String toString() {
        return "Diposit [valor=" + valor + ", quantitat=" + quantitat + "]";
    }
}
