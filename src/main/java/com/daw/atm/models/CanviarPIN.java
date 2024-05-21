package com.daw.atm.models;

public class CanviarPIN {
    // Atributos para el PIN actual, nuevo PIN y confirmación del nuevo PIN
    private int currentPIN;
    private int newPIN;
    private int confirmNewPIN;

    // Getters y Setters para el PIN actual
    public int getCurrentPIN() {
        return currentPIN;
    }

    public void setCurrentPIN(int currentPIN) {
        this.currentPIN = currentPIN;
    }

    // Getters y Setters para el nuevo PIN
    public int getNewPIN() {
        return newPIN;
    }

    public void setNewPIN(int newPIN) {
        this.newPIN = newPIN;
    }

    // Getters y Setters para la confirmación del nuevo PIN
    public int getConfirmNewPIN() {
        return confirmNewPIN;
    }

    public void setConfirmNewPIN(int confirmNewPIN) {
        this.confirmNewPIN = confirmNewPIN;
    }
}
