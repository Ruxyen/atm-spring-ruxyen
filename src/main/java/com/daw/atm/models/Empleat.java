package com.daw.atm.models;

import java.time.LocalDate;

public class Empleat extends Persona{
    private String categoria;
    private double sou;
    private String nom;
    
    public Empleat() {
    }
    public Empleat(String nom, String cognom, String dni, LocalDate dataNaixement, String categoria, double sou) {
        super(nom, cognom, dni, dataNaixement);
        this.categoria = categoria;
        this.sou = sou;
        this.nom = nom;
    }
    public Empleat(String categoria, double sou) {
        this.categoria = categoria;
        this.sou = sou;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getSou() {
        return sou;
    }
    public void setSou(double sou) {
        this.sou = sou;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    } 
    
}