package com.daw.atm.models;

// Clase que representa una cuenta de ahorro, que es un tipo de cuenta bancaria
public class CompteEstalvi extends Compte {

    // Constante para la cantidad mínima permitida en la cuenta de ahorro
    static final double QUANTITAT_MINIMA = 1000;

    // Atributo que representa el interés de la cuenta de ahorro
    private double interes;

    // Constructor que recibe saldo, propietario e interés
    public CompteEstalvi(double saldo, Client propietari, double interes) {
        super(saldo, propietari);
        this.interes = interes;
    }

    // Método toString para representar la información de la cuenta de ahorro
    @Override
    public String toString() {
        return "Compte Estalvi " + this.numero + " té " + this.saldo + " euros";
    }

    // Método getter para obtener el interés
    public double getInteres() {
        return interes;
    }

    // Método setter para establecer el interés
    public void setInteres(double interes) {
        this.interes = interes;
    }

    // Método para retirar dinero de la cuenta de ahorro
    @Override
    public boolean retirar(double quantitat) {
        if (this.saldo - quantitat < QUANTITAT_MINIMA) {
            System.out.println("No s'ha realitzat l'extracció. Vigila amb el saldo del compte.");
            return false;
        }
        return super.retirar(quantitat);
    }

    // Método para aplicar el interés a la cuenta de ahorro
    public double aplicarInteres() {
        this.saldo += this.saldo * this.interes; // Incrementa el saldo según el interés
        return this.saldo; // Devuelve el saldo actualizado
    }
}
