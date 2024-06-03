package com.daw.atm.models;

import java.time.LocalDate;

public class Client extends Persona {
    // Atributo para almacenar el correo electrónico del cliente
    private String email;

    // Constructor que inicializa todos los atributos de la clase padre (Persona) y
    // el atributo email
    public Client(String nom, String cognom, String dni, LocalDate dataNaixement, String email) {
        super(nom, cognom, dni, dataNaixement); // Llama al constructor de la clase padre
        this.email = email;
    }

    // Constructor alternativo que solo inicializa el atributo email
    public Client(String email) {
        this.email = email;
    }

    // Getter para el correo electrónico
    public String getEmail() {
        return email;
    }

    // Setter para el correo electrónico
    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString para representar la información del cliente
    @Override
    public String toString() {
        return "Client [email=" + email + "]" + super.toString(); // Llama al método toString de la clase padre
    }
}
