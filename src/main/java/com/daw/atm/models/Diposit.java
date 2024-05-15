package com.daw.atm.models;

public class Diposit {
    
    protected double valor;
    protected double quantitat;
    
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getQuantitat() {
        return quantitat;
    }
    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }
    public Diposit(double valor, double quantitat) {
        this.valor = valor;
        this.quantitat = quantitat;
    }
    @Override
    public String toString() {
        return "Diposit [valor=" + valor + ", quantitat=" + quantitat + "]";
    }


}
