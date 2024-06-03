package com.daw.atm.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operacio {

    private LocalDateTime data; // Fecha y hora de la operación
    private String descripcio; // Descripción de la operación
    private double quantitat; // Cantidad involucrada en la operación
    private String destinatari; // Destinatario en caso de transferencia

    // Constructor por defecto
    public Operacio() {
        this.data = LocalDateTime.now();
    }

    // Constructor con parámetros para crear una operación con todos los detalles
    public Operacio(String descripcio, double quantitat, String destinatari) {
        this.data = LocalDateTime.now();
        this.descripcio = descripcio;
        this.quantitat = quantitat;
        this.destinatari = destinatari;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }

    public String getDestinatari() {
        return destinatari;
    }

    public void setDestinatari(String destinatari) {
        this.destinatari = destinatari;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataFormatted = data.format(formatter);
        return String.format("Tipus: %s / Quantitat: %.2f%s / Data i hora: %s",
                             descripcio, quantitat,
                             destinatari != null ? " / Destinatari: " + destinatari : "",
                             dataFormatted);
    }
}
