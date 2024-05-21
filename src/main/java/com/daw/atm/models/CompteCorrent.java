package com.daw.atm.models;

// Clase que representa una cuenta corriente, que es un tipo de cuenta bancaria
public class CompteCorrent extends Compte {

    // Constructor que llama al constructor de la clase padre (Compte)
    public CompteCorrent(double saldo, Client preopietari) {
        super(saldo, preopietari);
    }

    // Método toString para representar la información de la cuenta corriente
    @Override
    public String toString() {
        return "Comptecorrent " + this.numero + " té " + this.saldo + " euros";
    }
}
