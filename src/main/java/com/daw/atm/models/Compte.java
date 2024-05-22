package com.daw.atm.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compte {

    protected String numero;
    protected double saldo;
    protected LocalDate DataObertura;
    protected Client propietari;
    protected ArrayList<Operacio> llistaMoviments;

    static public String format = "ES1025";
    static public int comptador = 0;

    public Compte() {
    }

    public Compte(double saldo, Client propietari) {
        comptador++;
        this.numero = format + String.format("%08d", comptador);
        this.saldo = saldo;
        this.DataObertura = LocalDate.now();
        this.propietari = propietari;
        this.llistaMoviments = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataObertura() {
        return DataObertura;
    }

    public void setDataObertura(LocalDate dataObertura) {
        DataObertura = dataObertura;
    }

    public Client getPropietari() {
        return propietari;
    }

    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }

    public ArrayList<Operacio> getLlistaMoviments() {
        return llistaMoviments;
    }

    public void ingressar(double quantitat) {
        if (quantitat % 10 == 0) {
            this.saldo += quantitat;
            Operacio operacio = new Operacio("INGRÉS", quantitat, null);
            llistaMoviments.add(operacio);
        } else {
            System.out.println("La cantidad debe ser un múltiplo de 10.");
        }
    }
    
    

    public boolean retirar(double quantitat) {
        if (saldo >= quantitat) {
            this.saldo -= quantitat;
            Operacio operacio = new Operacio("RETIR", quantitat, null);
            llistaMoviments.add(operacio);
            return true;
        } else {
            System.out.println("No s'ha realitzat l'extracció. Vigila amb el saldo del compte.");
            return false;
        }
    }
    
    

    public boolean transferencia(Compte desti, double quantitat) {
        if (this.retirar(quantitat)) {
            desti.ingressar(quantitat);
            Operacio operacio = new Operacio("TRANSFERÈNCIA", quantitat, desti.getNumero());
            llistaMoviments.add(operacio);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return numero + " " + saldo + " " + DataObertura + " " + propietari;
    }
}
