package com.daw.atm.models;

import java.time.LocalDateTime;

// Clase que representa una operación bancaria
public class Operacio {
    
    // Atributos de la clase
    LocalDateTime data;  // Fecha y hora de la operación
    String descripcio;   // Descripción de la operación

    // Constructor por defecto que inicializa la fecha y hora a la actual
    public Operacio() {
        data = LocalDateTime.now();
    }

    // Getter para obtener la fecha y hora de la operación
    public LocalDateTime getData() {
        return data;
    }

    // Setter para establecer la fecha y hora de la operación
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    // Getter para obtener la descripción de la operación
    public String getDescripcio() {
        return descripcio;
    }

    // Setter para establecer la descripción de la operación
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    // Método toString para representar la operación como una cadena de texto
    @Override
    public String toString() {
        return "Operacio en data=" + data;
    }
}
