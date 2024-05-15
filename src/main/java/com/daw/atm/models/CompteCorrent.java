package com.daw.atm.models;

public class CompteCorrent extends Compte {

	public CompteCorrent(double saldo, Client preopietari){
    	super(saldo, preopietari);
	}

	@Override
	public String toString() {
    	return "Comptecorrent "+this.numero+" té "+this.saldo+" euros";
	}
    
    
}
