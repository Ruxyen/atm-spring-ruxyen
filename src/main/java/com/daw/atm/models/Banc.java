package com.daw.atm.models;

import java.time.LocalDate;

public class Banc {

	private String nom;
	private int numbanc;

	private Compte[] llistaComptes;

	private Client[] llistaClients;

	private Targeta[] llistaTargetes;

	public Compte[] getLlistaComptes() {
    	return llistaComptes;
	}

	public Client[] getLlistaClients() {
    	return llistaClients;
	}

	public Banc() {

    	llistaClients = new Client[5];

    	llistaClients[0] = new Client("Ana", "Ponts Sants", "12341234A", LocalDate.parse("2000-01-08"),
            	"aponts@correu.com");
    	llistaClients[1] = new Client("Carlos", "Ponts Sants", "23442345A", LocalDate.parse("2000-01-08"),
            	"cponts@correu.com");
    	llistaClients[2] = new Client("Felip", "Ponts Sants", "55341234A", LocalDate.parse("2000-01-08"),
            	"fponts@correu.com");
    	llistaClients[3] = new Client("Esther", "Ponts Sants", "66341234A", LocalDate.parse("2000-01-08"),
            	"eponts@correu.com");
    	llistaClients[4] = new Client("Sandra", "Ponts Sants", "77341234A", LocalDate.parse("2000-01-08"),
            	"sponts@correu.com");

    	llistaComptes = new Compte[10];

    	llistaComptes[0] = new CompteCorrent(1000, llistaClients[0]);
    	llistaComptes[1] = new CompteCorrent(1000, llistaClients[1]);
    	llistaComptes[2] = new CompteCorrent(1000, llistaClients[2]);
    	llistaComptes[3] = new CompteCorrent(1000, llistaClients[3]);
    	llistaComptes[4] = new CompteCorrent(1000, llistaClients[4]);

    	llistaComptes[5] = new CompteEstalvi(1000, llistaClients[0], 2);
    	llistaComptes[6] = new CompteEstalvi(1000, llistaClients[1], 2);
    	llistaComptes[7] = new CompteEstalvi(1000, llistaClients[2], 2);
    	llistaComptes[8] = new CompteEstalvi(1000, llistaClients[3], 2);
    	llistaComptes[9] = new CompteEstalvi(1000, llistaClients[4], 2);

    	llistaTargetes = new Targeta[5];

    	llistaTargetes[0] = new Targeta("111111111111A", LocalDate.parse("2027-01-01"), 111, 1111,
            	(CompteCorrent) llistaComptes[0]);
    	llistaTargetes[1] = new Targeta("222222222222B", LocalDate.parse("2027-01-01"), 222, 2222,
            	(CompteCorrent) llistaComptes[1]);
    	llistaTargetes[2] = new Targeta("333333333333C", LocalDate.parse("2027-01-01"), 333, 3333,
            	(CompteCorrent) llistaComptes[2]);
    	llistaTargetes[3] = new Targeta("444444444444D", LocalDate.parse("2027-01-01"), 444, 4444,
            	(CompteCorrent) llistaComptes[3]);
    	llistaTargetes[4] = new Targeta("555555555555E", LocalDate.parse("2027-01-01"), 555, 5555,
            	(CompteCorrent) llistaComptes[4]);
	}

	@Override
	public String toString() {
    	return "Banc [nom=" + nom + ", numbanc=" + numbanc + "]";
	}

	public Banc(String nom, int numbanc) {
    	this.nom = nom;
    	this.numbanc = numbanc;
	}

	public String getNom() {
    	return nom;
	}

	public void setNom(String nom) {
    	this.nom = nom;
	}

	public int getNumbanc() {
    	return numbanc;
	}

	public void setNumbanc(int numbanc) {
    	this.numbanc = numbanc;
	}

	public Targeta[] getLlistaTargetes() {
    	return llistaTargetes;
	}

	public Targeta getTargeta(String numero) {
    	for (Targeta t : llistaTargetes) {
        	if (t.getNumero().equals(numero))
            	return t;
    	}
    	return null;
	}

	public Compte getCompte(String numero) {
    	for (Compte compte : llistaComptes) {
        	if (compte.getNumero().equals(numero))
            	return compte;
    	}
    	return null;
	}
}
