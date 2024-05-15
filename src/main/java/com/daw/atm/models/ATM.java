package com.daw.atm.models;

import org.springframework.stereotype.Service;

@Service
public class ATM {

	private int codiatm;
	private String adreça;
	private String estat;

	private Banc banc;
	private Targeta targetaActual;

	public Targeta getTargetaActual() {
    	return targetaActual;
	}

	public boolean assignarTargeta(String numero, int PIN) {
    	Targeta t = banc.getTargeta(numero);
    	if (t == null)
        	return false;
    	if (t.validarPin(PIN) == false)
        	return false;
    	this.targetaActual = t;

    	return true;
	}

	public boolean isLogged() {
    	return this.targetaActual != null;
	}

	public void ingressar(double quantitat) {

    	if (this.targetaActual != null)
        	;
    	this.targetaActual.getCompteCorrent().ingresar(quantitat);
	}

	public void retirar(double quantitat) {

    	if (this.targetaActual != null)
        	;
    	this.targetaActual.getCompteCorrent().retirar(quantitat);
	}

	@Override
	public String toString() {
    	return "ATM codiatm=" + codiatm + ", adreça=" + adreça + ", estat=" + estat;
	}

	public ATM(int codiatm, String adreça, String estat) {
    	this.codiatm = codiatm;
    	this.adreça = adreça;
    	this.estat = "Tancat";
    	this.banc = new Banc();
	}

	public int getCodiatm() {
    	return codiatm;
	}

	public void setCodiatm(int codiatm) {
    	this.codiatm = codiatm;
	}

	public String getAdreça() {
    	return adreça;
	}

	public void setAdreça(String adreça) {
    	this.adreça = adreça;
	}

	public String getEstat() {
    	return estat;
	}

	public void setEstat(String estat) {
    	this.estat = estat;
	}

	public void tancar() {
    	this.estat = "Tancat";
	}

	public void obrir() {
    	this.estat = "Obert";
	}

	Diposit[] llistaDiposits;

	public void ATM() {
    	llistaDiposits = new Diposit[4];
    	llistaDiposits[0] = new Diposit(50, 75);
	}

	public ATM() {
    	this.banc = new Banc();
	}

	public boolean transferencia(int quantitat, String numero) {
    	Compte desti = banc.getCompte(numero);
    	if (desti == null)
        	return false;
    	return targetaActual.getCompteCorrent().transferencia(desti, quantitat);
	}
}
