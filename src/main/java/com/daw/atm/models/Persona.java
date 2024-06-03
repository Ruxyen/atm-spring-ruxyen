package com.daw.atm.models;

import java.time.LocalDate;
import java.time.Period;

// Clase que representa una persona
public class Persona {

    // Atributos de la clase
    protected String nom; // Nombre de la persona
    protected String cognom; // Apellido de la persona
    protected String dni; // DNI de la persona
    protected LocalDate dataNaixement; // Fecha de nacimiento de la persona

    // Métodos

    // Método para calcular la edad de la persona
    public int edat() {
        return Period.between(dataNaixement, LocalDate.now()).getYears();
    }

    // Método estático para validar el DNI
    static public boolean validarDNI(String dni) {
        char[] lletres = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
                'H', 'L', 'C', 'K', 'E' };
        if (dni.length() != 9) {
            return false;
        }
        String numero = dni.substring(0, 8);
        System.out.println(numero);

        try {
            int numInt = Integer.parseInt(numero);
            int index = numInt % 23;
            if (lletres[index] != Character.toUpperCase(dni.charAt(8))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            System.out.println("Errorrrrrrrrrrrrrrrrrrr, espabila!");
            return false;
        }
    }

    // Constructor por defecto
    public Persona() {
        System.out.println("Sóc una persona");
    }

    // Método toString para representar la persona como una cadena de texto
    @Override
    public String toString() {
        return "Persona [nom=" + nom + ", cognom=" + cognom + ", dni=" + dni + ", data naixement=" + dataNaixement
                + "]";
    }

    // Constructor con parámetros
    public Persona(String nom, String cognom, String dni, LocalDate dataNaixement) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.dataNaixement = dataNaixement;
    }

    // Método para que la persona hable
    public void parlar() {
        System.out.println("Voy a hablar");
        System.out.println("Em dic " + this.nom);
    }

    // Método para que la persona hable en un idioma específico
    public void parlar(String Idioma) {
        if (Idioma.equals("cat")) {
            System.out.println("Vaig a parlar");
            System.out.println("Em dic " + this.nom);
        }
        if (Idioma.equals("ing")) {
            System.out.println("I'm going to talk");
            System.out.println("I'm " + this.nom);
        }
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }
}
