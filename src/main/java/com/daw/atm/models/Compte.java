package com.daw.atm.models;

import java.time.LocalDate;
import java.util.ArrayList;

public /* abstract */ class Compte {

	protected String numero;
	protected double saldo;
	protected LocalDate DataObertura;
	protected Client propietari;
	// protected Operacio[] llistaMoviments;
	protected ArrayList<Operacio> llistaMoviments;

    

	public ArrayList<Operacio> getLlistaMoviments() {
    	return llistaMoviments;
	}

	static public String format = "ES1025";

	static public int comptador = 0;

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

	@Override
	public String toString() {
    	return numero + " " + saldo + " " + DataObertura + " " + propietari;
	}

	public Compte() {

	}

	public Compte(double saldo, Client propietari) {
    	comptador++;
    	this.numero = format + String.format("%08d", comptador); // el %08d vol dir que posa 8 ceros davant del numero
    	this.saldo = saldo;
    	DataObertura = LocalDate.now();
    	this.propietari = propietari;
    	// llistaMoviments = new Operacio[10];
    	llistaMoviments = new ArrayList<Operacio>();
    	//llistaMoviments.add(new Operacio());
    	// llistaMoviments.remove(0);

    	for (Operacio operacio : llistaMoviments) {
        	System.out.println(operacio);
    	}
    	Operacio op = new Operacio();
    	op.setDescripcio("hola");
    	llistaMoviments.add(op);
	}
	/*
 	* public Compte() { //si no generem aquest Constructor en el main ens sortira
 	* error en "Compte compte1 = new Compte();"
 	* this.saldo = 10; //si no li dones cap saldo automaticamente inicialmente hi
 	* haura 10 de saldo
 	* }
 	*/

	public void ingresar(double quantitat) {

    	this.saldo = this.saldo + quantitat;

    	llistaMoviments.add(new Operacio());
    	for (Operacio operacio : llistaMoviments) {
        	System.out.println(operacio);
    	}
	}

	public boolean retirar(double quantitat) {

    	if (saldo >= quantitat) {
        	this.saldo = this.saldo - quantitat;
        	return true;
    	} else {
        	return false;
    	}

	}

	public boolean transferencia(Compte desti, double quantitat) {
    	if (this.retirar(quantitat)) {
        	desti.ingresar(quantitat);
        	return true;
    	}
    	return false;
	}

}