package com.daw.atm.models;

import java.time.LocalDate;

public class Targeta extends Compte{
    protected String numero;
    protected LocalDate DataTancament;
    protected int cvv;
    protected int pin;
    protected boolean activo;
    protected boolean bloqueada;
    protected int intents;
    protected int NUMERO_MAX_INTENTS = 3;


    public boolean validarPin (int pin){
        if(this.bloqueada) return false;
        if (pin == this.pin){
            return true;
        } else { this.intents++;}

        if(this.intents == NUMERO_MAX_INTENTS){this.bloqueada = true;}
        return false;

    }

    private CompteCorrent CompteCorrent;

        public CompteCorrent getCompteCorrent() {
        return CompteCorrent;
    }

        public void setCompteCorrent(CompteCorrent compteCorrent) {
        CompteCorrent = compteCorrent;
    }
    
        public Targeta(String numero, LocalDate DataTancament, int cvv, int pin, CompteCorrent compteCorrent){
        this.numero = numero;
        this.DataTancament = DataTancament;
        this.cvv = cvv;
        this.pin = pin;
        this.activo = true;
        this.bloqueada = false;
        this.intents = 0;
        this.CompteCorrent = compteCorrent;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public LocalDate getDataTancament() {
        return DataTancament;
    }
    
    public void setDataTancament(LocalDate dataTancament) {
        DataTancament = dataTancament;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public boolean isBloqueada() {
        return bloqueada;
    }
    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }
    public int getIntents() {
        return intents;
    }
    public void setIntents(int intents) {
        this.intents = intents;
    }
    public int getNUMERO_MAX_INTENTS() {
        return NUMERO_MAX_INTENTS;
    }
    public void setNUMERO_MAX_INTENTS(int NUMERO_MAX_INTENTS) {
        NUMERO_MAX_INTENTS = 3;
    }

    @Override
    public String toString() {
        return "Targeta [numero=" + numero + ", DataTancament=" + DataTancament + ", cvv=" + cvv + ", pin=" + pin
                + ", activo=" + activo + ", bloqueada=" + bloqueada + ", intents=" + intents + ", NUMERO_MAX_INTENTS="
                + NUMERO_MAX_INTENTS + ", CompteCorrent=" + CompteCorrent + "]";
    }

}