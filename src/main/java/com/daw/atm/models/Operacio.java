package com.daw.atm.models;

import java.time.LocalDateTime;

public class Operacio {
	LocalDateTime data;
	String descripcio;

	public Operacio() {
    	data = LocalDateTime.now();
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

	@Override
	public String toString() {
    	return "Operacio en data=" + data;
	}
    
}
