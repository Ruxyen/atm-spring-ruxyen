package com.daw.atm.models;

import java.time.LocalDate;
import java.util.ArrayList;


public class Banc {

	private String nom;
	private int numbanc;

	private ArrayList<Compte> llistaComptes;
private ArrayList<Client> llistaClients;
private ArrayList<Targeta> llistaTargetes;


	public ArrayList<Compte> getLlistaComptes() {
    return llistaComptes;
}

public ArrayList<Client> getLlistaClients() {
    return llistaClients;
}

	public Banc() {

    	llistaClients = new ArrayList<>();
    llistaClients.add(new Client("Ana", "Ponts Sants", "12341234A", LocalDate.parse("2000-01-08"), "aponts@correu.com"));
    llistaClients.add(new Client("Carlos", "Ponts Sants", "23442345A", LocalDate.parse("2000-01-08"), "cponts@correu.com"));
    llistaClients.add(new Client("Felip", "Ponts Sants", "55341234A", LocalDate.parse("2000-01-08"), "fponts@correu.com"));
    llistaClients.add(new Client("Esther", "Ponts Sants", "66341234A", LocalDate.parse("2000-01-08"), "eponts@correu.com"));
    llistaClients.add(new Client("Sandra", "Ponts Sants", "77341234A", LocalDate.parse("2000-01-08"), "sponts@correu.com"));

    llistaComptes = new ArrayList<>();
    llistaComptes.add(new CompteCorrent(1000, llistaClients.get(0)));
    llistaComptes.add(new CompteCorrent(1000, llistaClients.get(1)));
    llistaComptes.add(new CompteCorrent(1000, llistaClients.get(2)));
    llistaComptes.add(new CompteCorrent(1000, llistaClients.get(3)));
    llistaComptes.add(new CompteCorrent(1000, llistaClients.get(4)));
    llistaComptes.add(new CompteEstalvi(1000, llistaClients.get(0), 2));
    llistaComptes.add(new CompteEstalvi(1000, llistaClients.get(1), 2));
    llistaComptes.add(new CompteEstalvi(1000, llistaClients.get(2), 2));
    llistaComptes.add(new CompteEstalvi(1000, llistaClients.get(3), 2));
    llistaComptes.add(new CompteEstalvi(1000, llistaClients.get(4), 2));

    llistaTargetes = new ArrayList<>();
    llistaTargetes.add(new Targeta("111111111111A", LocalDate.parse("2027-01-01"), 111, 1111, (CompteCorrent) llistaComptes.get(0)));
    llistaTargetes.add(new Targeta("222222222222B", LocalDate.parse("2027-01-01"), 222, 2222, (CompteCorrent) llistaComptes.get(1)));
    llistaTargetes.add(new Targeta("333333333333C", LocalDate.parse("2027-01-01"), 333, 3333, (CompteCorrent) llistaComptes.get(2)));
    llistaTargetes.add(new Targeta("444444444444D", LocalDate.parse("2027-01-01"), 444, 4444, (CompteCorrent) llistaComptes.get(3)));
    llistaTargetes.add(new Targeta("555555555555E", LocalDate.parse("2027-01-01"), 555, 5555, (CompteCorrent) llistaComptes.get(4)));
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

	public ArrayList<Targeta> getLlistaTargetes() {
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
