package com.daw.atm.models;

import java.time.LocalDate;

public class Client extends Persona{

    private String email;


    public Client(String nom, String cognom, String dni, LocalDate dataNaixement, String email) {
        super(nom, cognom, dni, dataNaixement);
        this.email = email;
    }

    public Client(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client [email=" + email + "]" + super.toString();
    }
}
