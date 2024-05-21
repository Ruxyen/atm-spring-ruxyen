package com.daw.atm.models;

import java.time.LocalDate;

// Clase que representa a un empleado, hereda de Persona
public class Empleat extends Persona {

    // Atributos específicos de un empleado
    private String categoria; // Categoría del empleado
    private double sou; // Sueldo del empleado
    private String nom; // Nombre del empleado

    // Constructor vacío
    public Empleat() {
    }

    // Constructor completo que inicializa todos los atributos
    public Empleat(String nom, String cognom, String dni, LocalDate dataNaixement, String categoria, double sou) {
        super(nom, cognom, dni, dataNaixement); // Llama al constructor de la clase base (Persona)
        this.categoria = categoria;
        this.sou = sou;
        this.nom = nom;
    }

    // Constructor que inicializa solo la categoría y el sueldo
    public Empleat(String categoria, double sou) {
        this.categoria = categoria;
        this.sou = sou;
    }

    // Getter para obtener la categoría del empleado
    public String getCategoria() {
        return categoria;
    }

    // Setter para establecer la categoría del empleado
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Getter para obtener el sueldo del empleado
    public double getSou() {
        return sou;
    }

    // Setter para establecer el sueldo del empleado
    public void setSou(double sou) {
        this.sou = sou;
    }

    // Getter para obtener el nombre del empleado
    public String getNom() {
        return nom;
    }

    // Setter para establecer el nombre del empleado
    public void setNom(String nom) {
        this.nom = nom;
    }
}
